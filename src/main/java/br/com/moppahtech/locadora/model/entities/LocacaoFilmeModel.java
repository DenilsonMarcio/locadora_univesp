package br.com.moppahtech.locadora.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_locacao_filme")
public class LocacaoFilmeModel
{
    public LocacaoFilmeModel() {}
    
    public LocacaoFilmeModel(String id, String idLocacao, String idFilme)
	{
        this.id = id;
        this.idLocacao = idLocacao;
        this.idFilme = idFilme;
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

    private String idFilme;
    public String getIdFilme()
	{
        return idFilme;
    }
    public void setIdFilme(String idFilme)
	{
        this.idFilme = idFilme;
    }

}
