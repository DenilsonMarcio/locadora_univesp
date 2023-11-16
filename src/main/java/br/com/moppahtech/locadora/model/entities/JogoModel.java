package br.com.moppahtech.locadora.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_jogo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogoModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer classificacao;
    private Integer lancamento;
    private String produtora;
    private String genero;
    private Integer quantidade;
    private Double preco;
    private String plataforma;
}
