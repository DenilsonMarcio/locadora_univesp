package br.com.moppahtech.locadora.service;

import br.com.moppahtech.locadora.model.entities.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<UserModel> listUsers();
    Optional<UserModel> findUserById(UUID id);
    UserModel upDateUser(UserModel userModel);
    void deleteUser(UUID id);
    UserModel createUser(UserModel userModel);
}
