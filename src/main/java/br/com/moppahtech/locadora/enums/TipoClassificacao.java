package br.com.moppahtech.locadora.enums;

public enum TipoClassificacao {
    LIVRE ("livre"),
    DEZ_ANOS ("10 anos"),
    DOZE_ANOS ("12 anos"),
    CATORZE_ANOS ("14 anos"),
    DEZESSEIS_ANOS ("16 anos"),
    DEZOITO_ANOS ("18 anos");

    private String descricao;

    TipoClassificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

