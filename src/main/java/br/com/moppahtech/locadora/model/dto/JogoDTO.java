package br.com.moppahtech.locadora.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogoDTO {
    private String name;
    private Integer classificacao;
    private Integer lancamento;
    private String produtora;
    private String genero;
    private Integer quantidade;
    private Double preco;
    private String plataforma;
}
