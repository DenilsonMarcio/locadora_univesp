package br.com.moppahtech.locadora.repository;

import br.com.moppahtech.locadora.model.entities.LocacaoFilmeModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoFilmeRepository extends JpaRepository<LocacaoFilmeModel, String>
{
    List<LocacaoFilmeModel> findByIdLocacao(String idLocacao);
    List<LocacaoFilmeModel> findByIdLocacaoAndIdFilme(String idLocacao, String idFilme);
}
