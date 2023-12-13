package br.com.moppahtech.locadora.repository;

import br.com.moppahtech.locadora.model.entities.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, String> {
    @Query(nativeQuery = true, value = "SELECT MAX(CODIGO) FROM TB_JOGO")
    Integer gerarCodigoJogo();
}
