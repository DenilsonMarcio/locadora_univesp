package br.com.moppahtech.locadora.model.enums;

public enum TipoPreco {
    AMARELO(3.00),
    AZUL(4.00),
    VERDE(6.00),
    VERMELHO(10.00),
    DOURADO(15.00);

    private double valor;
    TipoPreco(Double valor){
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
