package br.com.moppahtech.locadora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.LocacaoFilmeModel;
import br.com.moppahtech.locadora.repository.LocacaoFilmeRepository;
import br.com.moppahtech.locadora.service.LocacaoFilmeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoFilmeServiceImpl implements LocacaoFilmeService
{
    private final LocacaoFilmeRepository locacaoFilmeRepository;

    @Override
    public LocacaoFilmeModel persistirLocacaoFilme(LocacaoFilmeModel model)
	{
        return locacaoFilmeRepository.save(model);
    }

    @Override
    public LocacaoFilmeModel buscaLocacaoFilmeById(String id)
	{
        Optional<LocacaoFilmeModel> locacaoFilmeModelOptional = locacaoFilmeRepository.findById(id);
        if(locacaoFilmeModelOptional.isEmpty())
        {
            throw new NotFoundException("Filme não encontrado nesta locação");
        }

        return locacaoFilmeModelOptional.get();
    }

    @Override
    public LocacaoFilmeModel atualizarLocacaoFilme(LocacaoFilmeModel model)
	{
        return locacaoFilmeRepository.save(generatedLocacaoFilmeModel(model));
    }

    @Override
    public void removerLocacaoFilme(String id)
	{
        Optional<LocacaoFilmeModel> locacaoFilmeModelOptional = locacaoFilmeRepository.findById(id);
        if (locacaoFilmeModelOptional.isEmpty())
        {
            throw new NotFoundException("Não existe locação com esse id!");
        }
        locacaoFilmeRepository.delete(locacaoFilmeModelOptional.get());
    }

    @Override
    public List<LocacaoFilmeModel> listaLocacoesFilmes(String idLocacao)
	{
        return locacaoFilmeRepository.findByIdLocacao(idLocacao);
    }

    private LocacaoFilmeModel generatedLocacaoFilmeModel(LocacaoFilmeModel model) throws BusinessException
    {
        try
        {
            LocacaoFilmeModel retorno = locacaoFilmeRepository.findById(model.getId()).get();
            retorno.setId(model.getId());
            retorno.setIdLocacao( model.getIdLocacao());
            retorno.setIdFilme( model.getIdFilme());

            return retorno;
        }
        catch (Exception exception)
        {
            throw new BusinessException("Não foi possível atualizar a locação", exception.getMessage());
        }
    }

    
}
