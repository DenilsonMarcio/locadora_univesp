package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.entities.FilmeModel;

import java.util.List;

public interface FilmeService {
    List<FilmeModel> listaFilmes();
    FilmeModel buscaFilmePorId(String id);
    FilmeModel persistirFilme(FilmeModel model);
    FilmeModel atualizarFilme(FilmeModel model);
    void removerJogo(String id);
}
