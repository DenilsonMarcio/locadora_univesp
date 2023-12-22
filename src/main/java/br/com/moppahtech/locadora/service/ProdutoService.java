package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.dto.RequestProdutosDTO;

public interface ProdutoService {
    void persistirProdutos(RequestProdutosDTO produtosDTO);
}
