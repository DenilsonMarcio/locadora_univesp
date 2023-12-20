package br.com.moppahtech.locadora.service;

import java.util.List;

import br.com.moppahtech.locadora.model.entities.LocacaoJogoModel;

public interface LocacaoJogoService
{
    LocacaoJogoModel persistirLocacaoJogo(LocacaoJogoModel model);
    LocacaoJogoModel buscaLocacaoJogoById(String id);
    LocacaoJogoModel atualizarLocacaoJogo(LocacaoJogoModel model);
    void removerLocacaoJogo(String id);
    List<LocacaoJogoModel> listaLocacoesJogos(String idLocacao);
}
