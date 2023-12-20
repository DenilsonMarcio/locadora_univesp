package br.com.moppahtech.locadora.model.enums;

public enum TipoPlataforma {
    MEGADRIVE("MEGADRIVE"),
    SEGA_SATURN("SEGA_SATURN"),
    PLAYSTATION("PLAYSTATION"),
    VIRTUAL_BOY("VIRTUAL_BOY"),
    NINTENDO_64("NINTENDO_64"),
    SUPER_NINTENDO("SUPER_NINTENDO"),
    NEO_GEO_POCKET("NEO_GEO_POCKET"),
    GAME_BOY_COLOR("GAME_BOY_COLOR");
    private String plataforma;
    TipoPlataforma(String plataforma) {this.plataforma = plataforma; }
    public String getPlataforma() {
        return plataforma;
    }

}