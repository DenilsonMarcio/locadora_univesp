package br.com.moppahtech.locadora.repository;

import br.com.moppahtech.locadora.model.entities.LocacaoModel;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<LocacaoModel, String>
{
    List<LocacaoModel> findByIdClienteAndRetiradaBetween(String idCliente, Date desde, Date ate);    
    List<LocacaoModel> findByRetiradaBetween(Date desde, Date ate);
}
