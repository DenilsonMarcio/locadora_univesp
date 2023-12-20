package br.com.moppahtech.locadora.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_filme")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer codigo;
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
