package br.com.moppahtech.locadora.model.enums;

public enum TipoPlataforma {
    MEGADRIVE("mega_drive"),
    SEGA_SATURN("sega_saturn"),
    PLAYSTATION("playstation"),
    VIRTUAL_BOY("virtual_boy"),
    NINTENDO_64("nintendo_64"),
    SUPER_NINTENDO("super_nintendo"),
    NEO_GEO_POCKET("neo_geo_pocket"),
    GAME_BOY_COLOR("game_boy_color");

    private String plataforma;

    TipoPlataforma(String plataforma) {this.plataforma = plataforma; }

    public String getPlataforma() {
        return plataforma;
    }





}