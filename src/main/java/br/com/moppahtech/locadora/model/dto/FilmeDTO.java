package br.com.moppahtech.locadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {
    private String name;
    private Integer classificacao;
    private Integer lancamento;
    private String produtora;
    private String genero;
    private Integer quantidade;
    private Double preco;
    private String idioma;
    private String diretor;
}
