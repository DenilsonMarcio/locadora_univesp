package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.FilmeModel;
import br.com.moppahtech.locadora.repository.FilmeRepository;
import br.com.moppahtech.locadora.service.FilmeService;
import br.com.moppahtech.locadora.utils.GenerateUUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;
    private final GenerateUUID uuid;

    @Override
    public List<FilmeModel> listaFilmes() {
        return filmeRepository.findAll();
    }

    @Override
    public FilmeModel buscaFilmePorId(String id) {
        Optional<FilmeModel> filmeModelOptional = filmeRepository.findById(id);
        if (filmeModelOptional.isEmpty()){
            throw new NotFoundException("Filme não encontrado!");
        }
        return filmeModelOptional.get();
    }

    @Override
    public FilmeModel persistirFilme(FilmeModel model) {
        return filmeRepository.save(model);
    }

    @Override
    public FilmeModel atualizarFilme(FilmeModel model) {
        return filmeRepository.save(generatedJogoModel(model));
    }

    @Override
    public void removerJogo(String id) {
        Optional<FilmeModel> filmeModelOptional = filmeRepository.findById(id);
        if (filmeModelOptional.isEmpty()){
            throw new NotFoundException("Não existe filme cadastrado com esse id!");
        }
        filmeRepository.delete(filmeModelOptional.get());
    }
    @SneakyThrows
    private FilmeModel generatedJogoModel(FilmeModel model) {
        try {
            FilmeModel filmeModel = filmeRepository.findById(model.getId()).get();
            filmeModel.setId(model.getId());
            filmeModel.setName(model.getName());
            filmeModel.setClassificacao(model.getClassificacao());
            filmeModel.setLancamento(model.getLancamento());
            filmeModel.setProdutora(model.getProdutora());
            filmeModel.setGenero(model.getGenero());
            filmeModel.setQuantidade(model.getQuantidade());
            filmeModel.setPreco(model.getPreco());
            filmeModel.setIdioma(model.getIdioma());
            filmeModel.setDiretor(model.getDiretor());
            return filmeModel;
        } catch (Exception exception){
            throw new BusinessException("Não foi possivel atualizar o jogo", exception.getMessage());
        }
    }
}
