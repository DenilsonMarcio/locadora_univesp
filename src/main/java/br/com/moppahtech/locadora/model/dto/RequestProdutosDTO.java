package br.com.moppahtech.locadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProdutosDTO {
    List<JogoDTO> jogos;
    List<FilmeDTO> filmes;
}
