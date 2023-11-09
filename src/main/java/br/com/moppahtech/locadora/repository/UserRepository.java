package br.com.moppahtech.locadora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.moppahtech.locadora.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{

    UserModel findByUsername(String username);
    
}
