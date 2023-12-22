package br.com.moppahtech.locadora.service;

import java.util.List;

import br.com.moppahtech.locadora.model.enums.TipoClassificacao;

public interface ClassificacaoService
{
    List<TipoClassificacao> listaClassificacoes();
}
