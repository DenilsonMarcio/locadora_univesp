package br.com.moppahtech.locadora.model.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_locacao")
public class LocacaoModel
{
    public LocacaoModel()
    {
    }

    public LocacaoModel(String id, Date retirada, Date devolucao, String idCliente, String idUsuario, double precoTotal)
    {
        this.id = id;
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.precoTotal = precoTotal;
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

    private Date retirada;
    public Date getRetirada()
	{
        return retirada;
    }
    public void setRetirada(Date retirada)
	{
        this.retirada = retirada;
    }

    private Date devolucao;
    public Date getDevolucao()
	{
        return devolucao;
    }
    public void setDevolucao(Date devolucao)
	{
        this.devolucao = devolucao;
    }

    private String idCliente;
    public String getIdCliente()
	{
        return idCliente;
    }
    public void setIdCliente(String idCliente)
	{
        this.idCliente = idCliente;
    }

    private String idUsuario;
    public String getIdUsuario()
	{
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario)
	{
        this.idUsuario = idUsuario;
    }

    private double precoTotal;
    public double getPrecoTotal()
	{
        return precoTotal;
    }
    public void setPrecoTotal(double precoTotal)
	{
        this.precoTotal = precoTotal;
    }

    @Transient
    private List<LocacaoJogoModel> listJogos;
    public List<LocacaoJogoModel> getListJogos() {
        return listJogos;
    }
    public void setListJogos(List<LocacaoJogoModel> listJogos) {
        this.listJogos = listJogos;
    }

    @Transient
    private List<LocacaoFilmeModel> listFilmes;
    public List<LocacaoFilmeModel> getListFilmes() {
        return listFilmes;
    }

    public void setListFilmes(List<LocacaoFilmeModel> listFilmes) {
        this.listFilmes = listFilmes;
    }

}
