package br.com.moppahtech.locadora.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.moppahtech.locadora.model.enums.TipoClassificacao;
import br.com.moppahtech.locadora.model.enums.TipoGenero;
import br.com.moppahtech.locadora.model.enums.TipoPlataforma;
import br.com.moppahtech.locadora.model.enums.TipoPreco;
import br.com.moppahtech.locadora.service.ClassificacaoService;
import br.com.moppahtech.locadora.service.GeneroService;
import br.com.moppahtech.locadora.service.PlataformaService;
import br.com.moppahtech.locadora.service.PrecoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EnumsController {

    private final ClassificacaoService classificacaoService;
    private final GeneroService generoService;
    private final PlataformaService plataformaService;
    private final PrecoService precoService;

    @GetMapping("/classificacao")
    public ResponseEntity<List<TipoClassificacao>> listaClassificacoes()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(classificacaoService.listaClassificacoes());
    }

    @GetMapping("/genero")
    public ResponseEntity<List<TipoGenero>> listaGeneros()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.listaGeneros() );
    }

    @GetMapping("/plataforma")
    public ResponseEntity<List<TipoPlataforma>> listaPlataformas()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(plataformaService.listaPlataformas());
    }

    @GetMapping("/preco")
    public ResponseEntity<List<TipoPreco>> listaPrecos()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(precoService.listaPrecos());
    }
}
