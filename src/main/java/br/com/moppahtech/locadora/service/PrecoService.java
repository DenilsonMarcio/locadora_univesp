package br.com.moppahtech.locadora.service;

import java.util.List;

import br.com.moppahtech.locadora.model.enums.TipoPreco;

public interface PrecoService
{
    List<TipoPreco> listaPrecos();
}
