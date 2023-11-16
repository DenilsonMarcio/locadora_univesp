package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.model.entities.FilmeModel;
import br.com.moppahtech.locadora.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping("/filme")
    public ResponseEntity<List<FilmeModel>> listaJogos() {
        List<FilmeModel> list = filmeService.listaFilmes();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<FilmeModel> buscaJogoPorId(@PathVariable String id) {
        FilmeModel filme = filmeService.buscaFilmePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(filme);
    }

    @PostMapping("/filme")
    public ResponseEntity<FilmeModel> persistirJogo(@RequestBody FilmeModel model) {
        FilmeModel filme = filmeService.persistirFilme(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    @PutMapping("/filme")
    public ResponseEntity<FilmeModel> atualizarJogo(@RequestBody FilmeModel model) throws BusinessException {
        FilmeModel filme = filmeService.atualizarFilme(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(filme);
    }

    @DeleteMapping("/filme/{id}")
    public ResponseEntity<Void> removerJogo(@PathVariable String id) {
        filmeService.removerJogo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
