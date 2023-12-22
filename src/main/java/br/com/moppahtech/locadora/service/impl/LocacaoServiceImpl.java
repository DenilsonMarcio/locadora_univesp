package br.com.moppahtech.locadora.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.FilmeModel;
import br.com.moppahtech.locadora.model.entities.JogoModel;
import br.com.moppahtech.locadora.model.entities.LocacaoFilmeModel;
import br.com.moppahtech.locadora.model.entities.LocacaoJogoModel;
import br.com.moppahtech.locadora.model.entities.LocacaoModel;
import br.com.moppahtech.locadora.repository.FilmeRepository;
import br.com.moppahtech.locadora.repository.JogoRepository;
import br.com.moppahtech.locadora.repository.LocacaoFilmeRepository;
import br.com.moppahtech.locadora.repository.LocacaoJogoRepository;
import br.com.moppahtech.locadora.repository.LocacaoRepository;
import br.com.moppahtech.locadora.service.LocacaoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService
{
    private final LocacaoRepository locacaoRepository;
    private final LocacaoFilmeRepository locacaoFilmeRepository;
    private final LocacaoJogoRepository locacaoJogoRepository;
    private final FilmeRepository filmeRepository;
    private final JogoRepository jogoRepository;    

    private LocacaoModel generatedLocacaoModel(LocacaoModel model) throws BusinessException
    {
        try
        {
            LocacaoModel retorno = locacaoRepository.findById(model.getId()).get();
            retorno.setId(model.getId());

            retorno.setDevolucao( model.getDevolucao());
            retorno.setIdCliente( model.getIdCliente());
            retorno.setIdUsuario( model.getIdUsuario());
            retorno.setPrecoTotal( model.getPrecoTotal());
            retorno.setRetirada(model.getRetirada());

            return retorno;
        }
        catch (Exception exception)
        {
            throw new BusinessException("Não foi possível atualizar a locação", exception.getMessage());
        }
    }

    @Override
    @Transactional
    public LocacaoModel persistirLocacao(LocacaoModel model)
    {
        try
        {
            model.setRetirada(new Date());

            int diasDeLocacao = model.getListFilmes().size() + model.getListJogos().size();
            Date dataDevolucao = DateUtils.addDays(model.getRetirada(), diasDeLocacao);

            dataDevolucao = DateUtils.setHours(dataDevolucao, 23);
            dataDevolucao = DateUtils.setMinutes(dataDevolucao, 59);
            dataDevolucao = DateUtils.setMilliseconds(dataDevolucao, 999);

            model.setDevolucao(dataDevolucao);

            // Preenche o valor total da locação
            double valorLocacao = 0;
            for (LocacaoFilmeModel item : model.getListFilmes())
            {
                // Busca os dados do filme
                FilmeModel filme = filmeRepository.findById(item.getIdFilme()).get();
                if(Objects.isNull(filme) || filme.getPreco() == null)
                {
                    throw new NotFoundException("Filme não localizado!");
                }

                valorLocacao += filme.getPreco();
            }

            for (LocacaoJogoModel item : model.getListJogos())
            {
                // Busca os dados do jogo
                JogoModel jogo = jogoRepository.findById(item.getIdJogo()).get();
                if(Objects.isNull(jogo) || jogo.getPreco() == null)
                {
                    throw new NotFoundException("Jogo não localizado!");
                }

                valorLocacao += jogo.getPreco();
            }

            model.setPrecoTotal(valorLocacao);

            LocacaoModel tempLocacao = locacaoRepository.save(model);
            
            // Agora, com o id da locação, salvamos os itens da locação
            for (LocacaoFilmeModel item : model.getListFilmes())
            {
                item.setIdLocacao(tempLocacao.getId());
                locacaoFilmeRepository.save(item);
            }
            for (LocacaoJogoModel item : model.getListJogos())
            {
                item.setIdLocacao(tempLocacao.getId());
                locacaoJogoRepository.save(item);
            }
            
            return tempLocacao;
        }
        catch (Exception e)
        {
            throw new BusinessException("Não foi possivel efetuar a locação", e.getMessage());
        }
    }
    
    @Override
    public LocacaoModel buscaLocacaoById(String id)
    {
        Optional<LocacaoModel> locacaoModelOptional = locacaoRepository.findById(id);
        if(locacaoModelOptional.isEmpty())
        {
            throw new NotFoundException("Locação não encontrada");
        }

        LocacaoModel locacao = locacaoModelOptional.get();

        List<LocacaoFilmeModel> filmes = locacaoFilmeRepository.findByIdLocacao(locacao.getId());
        List<LocacaoJogoModel> jogos = locacaoJogoRepository.findByIdLocacao(locacao.getId());

        locacao.setListFilmes(filmes);
        locacao.setListJogos(jogos);

        return locacao;
    }

    @Override
    public LocacaoModel atualizarLocacao(LocacaoModel model) throws BusinessException
    {
        return locacaoRepository.save(generatedLocacaoModel(model));
    }

    @Override
    @Transactional
    public void removerLocacao(String id)
    {
        try
        {
            LocacaoModel locacaoModel = buscaLocacaoById(id);
            if (Objects.isNull(locacaoModel))
            {
                throw new NotFoundException("Não existe locação com esse id!");
            }
            if (locacaoModel.getListFilmes().size() > 0)
                locacaoFilmeRepository.deleteAll(locacaoModel.getListFilmes());

            if (locacaoModel.getListJogos().size() > 0)
                locacaoJogoRepository.deleteAll(locacaoModel.getListJogos());

            locacaoRepository.delete(locacaoModel);
        }
        catch (Exception e)
        {
            throw new BusinessException("Não foi possivel remover a locação", e.getMessage());
        }
    }

    @Override
    public List<LocacaoModel> listaLocacoes()
    {
        return locacaoRepository.findAll();
    }

    @Override
    public List<LocacaoModel> locacoesPorIdClienteEPeriodo(String idCliente, Date desde, Date ate)
    {
        if ( idCliente.isBlank() )
            return locacaoRepository.findByRetiradaBetween(desde, ate);
        else
            return locacaoRepository.findByIdClienteAndRetiradaBetween(idCliente, desde, ate);
    }
}