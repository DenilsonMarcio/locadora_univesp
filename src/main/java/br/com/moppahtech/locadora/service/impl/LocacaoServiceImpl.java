package br.com.moppahtech.locadora.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.LocacaoModel;
import br.com.moppahtech.locadora.repository.LocacaoRepository;
import br.com.moppahtech.locadora.service.LocacaoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService
{
    private final LocacaoRepository locacaoRepository;

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
    public LocacaoModel persistirLocacao(LocacaoModel model)
    {
        return locacaoRepository.save(model);
    }
    
    @Override
    public LocacaoModel buscaLocacaoById(String id)
    {
        Optional<LocacaoModel> locacaoModelOptional = locacaoRepository.findById(id);
        if(locacaoModelOptional.isEmpty())
        {
            throw new NotFoundException("Locação não encontrada");
        }

        return locacaoModelOptional.get();        
    }

    @Override
    public LocacaoModel atualizarLocacao(LocacaoModel model) throws BusinessException
    {
        return locacaoRepository.save(generatedLocacaoModel(model));
    }

    @Override
    public void removerLocacao(String id)
    {
        Optional<LocacaoModel> locacaoModelOptional = locacaoRepository.findById(id);
        if (locacaoModelOptional.isEmpty())
        {
            throw new NotFoundException("Não existe locação com esse id!");
        }
        locacaoRepository.delete(locacaoModelOptional.get());
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