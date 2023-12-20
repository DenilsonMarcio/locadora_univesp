package br.com.moppahtech.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.moppahtech.locadora.model.entities.LocacaoJogoModel;

public interface LocacaoJogoRepository extends JpaRepository<LocacaoJogoModel, String>
{
    List<LocacaoJogoModel> findByIdLocacao(String idLocacao);
    List<LocacaoJogoModel> findByIdLocacaoAndIdJogo(String idLocacao, String idJogo);
}
