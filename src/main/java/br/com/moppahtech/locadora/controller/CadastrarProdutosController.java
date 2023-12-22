package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.dto.RequestProdutosDTO;
import br.com.moppahtech.locadora.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class CadastrarProdutosController {

    private final ProdutoService service;
    @PostMapping("/catalogo")
    public ResponseEntity<Void> persistirProdutos(@RequestBody RequestProdutosDTO produtosDTO) {
        service.persistirProdutos(produtosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
