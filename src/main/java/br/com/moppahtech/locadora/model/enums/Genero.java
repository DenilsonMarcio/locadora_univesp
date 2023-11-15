package br.com.moppahtech.locadora.model.enums;

public enum Genero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    CINEMA_DE_ARTE("Cinema de Arte"),
    CHANCHADA("Chanchada"),
    COMEDIA("Comédia"),
    COMEDIA_DE_ACAO("Comédia de Ação"),
    COMEDIA_DE_TERROR("Comédia de Terror"),
    COMEDIA_DRAMATICA("Comédia Dramática"),
    COMEDIA_ROMANTICA("Comédia Romântica"),
    DANCA("Dança"),
    DOCUMENTARIO("Documentário"),
    DOCUFICCAO("Docuficção"),
    DRAMA("Drama"),
    ESPIONAGEM("Espionagem"),
    FAROESTE("Faroeste"),
    FANTASIA("Fantasia"),
    FANTASIA_CIENTIFICA("Fantasia Científica"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    FILMES_COM_TRUQUES("Filmes com Truques"),
    FILMES_DE_GUERRA("Filmes de Guerra"),
    MISTERIO("Mistério"),
    MUSICAL("Musical"),
    FILME_POLICIAL("Filme Policial"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    THRILLER("Thriller");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}

