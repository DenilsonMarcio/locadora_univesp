package br.com.moppahtech.locadora.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TabelaPreco {

    AMARELO (3.00),
    AZUL (4.00),
    VERDE (6.00),
    VERMELHO (10.00),
    DOURADO (15.00);

    private Double valor;
}
