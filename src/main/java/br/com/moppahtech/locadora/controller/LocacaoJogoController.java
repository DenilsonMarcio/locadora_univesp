package br.com.moppahtech.locadora.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

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

import br.com.moppahtech.locadora.model.entities.LocacaoJogoModel;
import br.com.moppahtech.locadora.service.LocacaoJogoService;

@RestController
@RequiredArgsConstructor
public class LocacaoJogoController
{
    private final LocacaoJogoService locacaoJogoService;

    @PostMapping("/locacao/jogo")
    public ResponseEntity<LocacaoJogoModel> persistirLocacaoJogo(@RequestBody LocacaoJogoModel model)
    {
        LocacaoJogoModel retorno = locacaoJogoService.persistirLocacaoJogo(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @GetMapping("/locacao/jogo/{id}")
    public ResponseEntity<LocacaoJogoModel> buscaLocacaoJogoById(@PathVariable String id)
    {
        LocacaoJogoModel retorno = locacaoJogoService.buscaLocacaoJogoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @PutMapping("/locacao/jogo")
    public ResponseEntity<LocacaoJogoModel> atualizarLocacaoJogo(@RequestBody LocacaoJogoModel model)
    {
        LocacaoJogoModel retorno = locacaoJogoService.atualizarLocacaoJogo(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }

    @DeleteMapping("/locacao/jogo")
    public ResponseEntity<Void> removerLocacaoJogo(@PathVariable String id)
    {
        locacaoJogoService.removerLocacaoJogo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/locacao/jogo/filtro")
    public ResponseEntity<List<LocacaoJogoModel>> jogosPorLocacao(@RequestParam(value = "idLocacao") String idLocacao)
    {
        List<LocacaoJogoModel> retorno = locacaoJogoService.listaLocacoesJogos(idLocacao);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
}
