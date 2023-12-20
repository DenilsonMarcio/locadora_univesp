package br.com.moppahtech.locadora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.LocacaoJogoModel;
import br.com.moppahtech.locadora.repository.LocacaoJogoRepository;
import br.com.moppahtech.locadora.service.LocacaoJogoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoJogoServiceImpl implements LocacaoJogoService
{

    private final LocacaoJogoRepository locacaoJogoRepository;

    @Override
    public LocacaoJogoModel persistirLocacaoJogo(LocacaoJogoModel model)
	{
        return locacaoJogoRepository.save(model);
    }

    @Override
    public LocacaoJogoModel buscaLocacaoJogoById(String id)
	{
        Optional<LocacaoJogoModel> locacaoJogoModelOptional = locacaoJogoRepository.findById(id);
        if(locacaoJogoModelOptional.isEmpty())
        {
            throw new NotFoundException("Jogo não encontrado nesta locação");
        }

        return locacaoJogoModelOptional.get();
    }

    @Override
    public LocacaoJogoModel atualizarLocacaoJogo(LocacaoJogoModel model)
	{
        return locacaoJogoRepository.save(generatedLocacaoJogoModel(model));
    }

    @Override
    public void removerLocacaoJogo(String id)
	{
        Optional<LocacaoJogoModel> locacaoJogoModelOptional = locacaoJogoRepository.findById(id);
        if (locacaoJogoModelOptional.isEmpty())
        {
            throw new NotFoundException("Não existe locação com esse id!");
        }
        locacaoJogoRepository.delete(locacaoJogoModelOptional.get());
    }

    @Override
    public List<LocacaoJogoModel> listaLocacoesJogos(String idLocacao)
	{
        return locacaoJogoRepository.findAll();
    }

    private LocacaoJogoModel generatedLocacaoJogoModel(LocacaoJogoModel model) throws BusinessException
    {
        try
        {
            LocacaoJogoModel retorno = locacaoJogoRepository.findById(model.getId()).get();
            retorno.setId(model.getId());
            retorno.setIdLocacao( model.getIdLocacao());
            retorno.setIdJogo( model.getIdJogo());

            return retorno;
        }
        catch (Exception exception)
        {
            throw new BusinessException("Não foi possível atualizar a locação", exception.getMessage());
        }
    }
    
}
