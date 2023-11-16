package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.model.entities.JogoModel;
import br.com.moppahtech.locadora.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JogoController {

    private final JogoService jogoService;

    @GetMapping("/jogo")
    public ResponseEntity<List<JogoModel>> listaJogos() {
        List<JogoModel> list = jogoService.listaJogos();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/jogo/{id}")
    public ResponseEntity<JogoModel> buscaJogoPorId(@PathVariable String id) {
        JogoModel jogo = jogoService.buscaJogoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(jogo);
    }

    @PostMapping("/jogo")
    public ResponseEntity<JogoModel> persistirJogo(@RequestBody JogoModel model) {
        JogoModel jogo = jogoService.persistirJogo(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
    }

    @PutMapping("/jogo")
    public ResponseEntity<JogoModel> atualizarJogo(@RequestBody JogoModel model) throws BusinessException {
        JogoModel jogo = jogoService.atualizarJogo(model);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(jogo);
    }

    @DeleteMapping("/jogo/{id}")
    public ResponseEntity<Void> removerJogo(@PathVariable String id) {
        jogoService.removerJogo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
