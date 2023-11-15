package br.com.moppahtech.locadora.model.enums;

public enum TipoClassificacao {
    LIVRE (0),
    DEZ_ANOS (10),
    DOZE_ANOS (12),
    CATORZE_ANOS (14),
    DEZESSEIS_ANOS (16),
    DEZOITO_ANOS (18);

    private int idade;

    TipoClassificacao(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}

