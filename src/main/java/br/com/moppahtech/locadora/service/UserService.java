package br.com.moppahtech.locadora.service;

import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.moppahtech.locadora.model.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserModel createUser(@NotNull UserModel userModel){
        UserModel model = repository.findByUsername(userModel.getUsername());
        if(Objects.nonNull(model)){
            throw new RuntimeException("Usuario ja cadastrado.");
        }
        userModel.setPassword(encriptPassWord(userModel.getPassword()));
        return repository.save(userModel);
    }

    @Contract("_ -> new")
    private @NotNull String encriptPassWord(@NotNull String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public List<UserModel> getUsers() {
        return repository.findAll();
    }
}
