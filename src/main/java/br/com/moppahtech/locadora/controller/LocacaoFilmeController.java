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

import br.com.moppahtech.locadora.model.entities.LocacaoFilmeModel;
import br.com.moppahtech.locadora.service.LocacaoFilmeService;

@RestController
@RequiredArgsConstructor
public class LocacaoFilmeController
{
    private final LocacaoFilmeService locacaoFilmeService;

    @PostMapping("/locacao/filme")
    public ResponseEntity<LocacaoFilmeModel> persistirLocacaoFilme(@RequestBody LocacaoFilmeModel model)
    {
        LocacaoFilmeModel retorno = locacaoFilmeService.persistirLocacaoFilme(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @GetMapping("/locacao/filme/{id}")
    public ResponseEntity<LocacaoFilmeModel> buscaLocacaoFilmeById(@PathVariable String id)
    {
        LocacaoFilmeModel retorno = locacaoFilmeService.buscaLocacaoFilmeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @PutMapping("/locacao/filme")
    public ResponseEntity<LocacaoFilmeModel> atualizarLocacaoFilme(@RequestBody LocacaoFilmeModel model)
    {
        LocacaoFilmeModel retorno = locacaoFilmeService.atualizarLocacaoFilme(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }

    @DeleteMapping("/locacao/filme")
    public ResponseEntity<Void> removerLocacaoFilme(@PathVariable String id)
    {
        locacaoFilmeService.removerLocacaoFilme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/locacao/filme/filtro")
    public ResponseEntity<List<LocacaoFilmeModel>> filmesPorLocacao(@RequestParam(value = "idLocacao") String idLocacao)
    {
        List<LocacaoFilmeModel> retorno = locacaoFilmeService.listaLocacoesFilmes(idLocacao);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

}
