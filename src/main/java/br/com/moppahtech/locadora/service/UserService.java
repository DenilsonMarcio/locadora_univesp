package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.dto.UserDTO;
import br.com.moppahtech.locadora.model.entities.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<UserDTO> listUsers();
    Optional<UserDTO> findUserById(UUID id);
    UserDTO upDateUser(UserModel userModel);
    void deleteUser(UUID id);
    UserDTO createUser(UserModel userModel);
}
