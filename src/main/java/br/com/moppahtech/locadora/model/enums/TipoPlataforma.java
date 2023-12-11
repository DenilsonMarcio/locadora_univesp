package br.com.moppahtech.locadora.model.enums;

public enum TipoPlataforma {
    MEGADRIVE,
    SEGA_SATURN,
    PLAYSTATION,
    VIRTUAL_BOY,
    NINTENDO_64,
    SUPER_NINTENDO,
    NEO_GEO_POCKET,
    GAME_BOY_COLOR;

    private String plataforma;

    TipoPlataforma() {this.plataforma = plataforma; }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }




}