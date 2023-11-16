package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import br.com.moppahtech.locadora.model.entities.JogoModel;
import br.com.moppahtech.locadora.repository.JogoRepository;
import br.com.moppahtech.locadora.service.JogoService;
import br.com.moppahtech.locadora.utils.GenerateUUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;
    private final GenerateUUID uuid;
    @Override
    public List<JogoModel> listaJogos() {
        return jogoRepository.findAll();
    }

    @Override
    public JogoModel buscaJogoPorId(String id) {
        Optional<JogoModel> jogoModelOptional = jogoRepository.findById(id);
        if (jogoModelOptional.isEmpty()){
            throw new NotFoundException("Jogo não encontrado!");
        }
        return jogoModelOptional.get();
    }

    @Override
    public JogoModel persistirJogo(JogoModel model) {
        return jogoRepository.save(model);
    }

    @Override
    public void removerJogo(String id) {
        Optional<JogoModel> jogoModelOptional = jogoRepository.findById(id);
        if (jogoModelOptional.isEmpty()){
            throw new NotFoundException("Não existe jogo cadastrado com esse id!");
        }
        jogoRepository.delete(jogoModelOptional.get());
    }

    @Override
    public JogoModel atualizarJogo(JogoModel model) throws BusinessException {
        return jogoRepository.save(generatedJogoModel(model));
    }
    private JogoModel generatedJogoModel(JogoModel model) throws BusinessException {
        try {
            JogoModel jogoModel = jogoRepository.findById(model.getId()).get();
            jogoModel.setId(model.getId());
            jogoModel.setName(model.getName());
            jogoModel.setClassificacao(model.getClassificacao());
            jogoModel.setLancamento(model.getLancamento());
            jogoModel.setProdutora(model.getProdutora());
            jogoModel.setGenero(model.getGenero());
            jogoModel.setQuantidade(model.getQuantidade());
            jogoModel.setPreco(model.getPreco());
            jogoModel.setPlataforma(model.getPlataforma());
            return jogoModel;
        } catch (Exception exception){
            throw new BusinessException("Não foi possivel atualizar o jogo", exception.getMessage());
        }
    }
}
