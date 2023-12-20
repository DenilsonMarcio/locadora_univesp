package br.com.moppahtech.locadora.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.model.entities.LocacaoModel;
import br.com.moppahtech.locadora.service.LocacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LocacaoController
{
    private final LocacaoService locacaoService;
    
    @PostMapping("/locacao")
    public ResponseEntity<LocacaoModel> persistirLocacao(@RequestBody LocacaoModel model)
    {
        LocacaoModel locacao = locacaoService.persistirLocacao(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(locacao);
    }

    @GetMapping("/locacao/{id}")
    public ResponseEntity<LocacaoModel> buscaLocacaoById(@PathVariable String id)
    {
        LocacaoModel locacao = locacaoService.buscaLocacaoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(locacao);
    }

    @PutMapping("/locacao")
    public ResponseEntity<LocacaoModel> atualizarLocacao(@RequestBody LocacaoModel model) throws BusinessException
    {
        LocacaoModel locacao = locacaoService.atualizarLocacao(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(locacao);
    }

    @DeleteMapping("/locacao")
    public ResponseEntity<Void> removerLocacao(@PathVariable String id)
    {
        locacaoService.removerLocacao(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @GetMapping("/locacao/all")
    public ResponseEntity<List<LocacaoModel>> listaLocacoes()
    {
        List<LocacaoModel> list = locacaoService.listaLocacoes();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/locacao/filtro")
    public ResponseEntity<List<LocacaoModel>> locacoesPorIdClienteEPeriodo(
        @RequestParam(value = "idCliente", defaultValue = "") String idCliente,
        @RequestParam(value = "desde") @DateTimeFormat(pattern="yyyy-MM-dd") Date desde,
        @RequestParam(value = "ate") @DateTimeFormat(pattern="yyyy-MM-dd") Date ate)
    {
        List<LocacaoModel> list = locacaoService.locacoesPorIdClienteEPeriodo(idCliente, desde, ate);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}