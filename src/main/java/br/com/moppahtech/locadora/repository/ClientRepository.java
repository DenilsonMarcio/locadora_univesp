package br.com.moppahtech.locadora.repository;

import br.com.moppahtech.locadora.model.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM TB_CLIENT WHERE NAME LIKE %:name%")
    List<ClientModel> findClientByName(String name);
}
