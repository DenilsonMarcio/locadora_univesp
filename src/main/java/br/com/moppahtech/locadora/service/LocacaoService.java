package br.com.moppahtech.locadora.service;

import java.util.Date;
import java.util.List;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.model.entities.LocacaoModel;

public interface LocacaoService
{
    LocacaoModel persistirLocacao(LocacaoModel model);
    LocacaoModel buscaLocacaoById(String id);
    LocacaoModel atualizarLocacao(LocacaoModel model) throws BusinessException;
    void removerLocacao(String id);    
    List<LocacaoModel> listaLocacoes();

    public List<LocacaoModel> locacoesPorIdClienteEPeriodo(String idCliente, Date desde, Date ate);
}