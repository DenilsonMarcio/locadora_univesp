package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.entities.JogoModel;

import java.util.List;

public interface JogoService {
    List<JogoModel> listaJogos();
    JogoModel buscaJogoPorId(String id);
    JogoModel persistirJogo(JogoModel model);
    void removerJogo(String id);
    JogoModel atualizarJogo(JogoModel model) ;
}
