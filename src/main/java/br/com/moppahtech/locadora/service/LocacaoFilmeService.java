package br.com.moppahtech.locadora.service;

import java.util.List;

import br.com.moppahtech.locadora.model.entities.LocacaoFilmeModel;

public interface LocacaoFilmeService
{
    LocacaoFilmeModel persistirLocacaoFilme(LocacaoFilmeModel model);
    LocacaoFilmeModel buscaLocacaoFilmeById(String id);
    LocacaoFilmeModel atualizarLocacaoFilme(LocacaoFilmeModel model);
    void removerLocacaoFilme(String id);    
    List<LocacaoFilmeModel> listaLocacoesFilmes(String idLocacao);
}
