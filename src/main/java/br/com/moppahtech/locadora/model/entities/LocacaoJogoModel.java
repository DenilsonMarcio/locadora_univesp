package br.com.moppahtech.locadora.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_locacao_jogo")
public class LocacaoJogoModel
{
    public LocacaoJogoModel() {}
    
    public LocacaoJogoModel(String id, String idLocacao, String idJogo)
	{
        this.id = id;
        this.idLocacao = idLocacao;
        this.idJogo = idJogo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    public String getId()
	{
        return id;
    }
    public void setId(String id)
	{
        this.id = id;
    }

    private String idLocacao;
    public String getIdLocacao()
	{
        return idLocacao;
    }
    public void setIdLocacao(String idLocacao)
	{
        this.idLocacao = idLocacao;
    }

    private String idJogo;
    public String getIdJogo()
	{
        return idJogo;
    }
    public void setIdJogo(String idFilme)
	{
        this.idJogo = idFilme;
    }
}
