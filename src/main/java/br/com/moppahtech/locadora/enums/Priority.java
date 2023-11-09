package br.com.moppahtech.locadora.enums;

public enum Priority {
    NIVEL_0 ("ALTA"),
    NIVEL_1 ("MEDIA"),
    NIVEL_2 ("BAIXA");

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
