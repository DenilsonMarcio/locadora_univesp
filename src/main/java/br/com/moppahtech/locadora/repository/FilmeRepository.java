package br.com.moppahtech.locadora.repository;

import br.com.moppahtech.locadora.model.entities.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, String> {
}
