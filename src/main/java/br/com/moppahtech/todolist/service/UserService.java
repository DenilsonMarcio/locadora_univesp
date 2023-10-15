package br.com.moppahtech.todolist.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.moppahtech.todolist.model.UserModel;
import br.com.moppahtech.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public UserModel createUser(UserModel userModel){
        UserModel model = repository.findByUsername(userModel.getUsername());
        if(Objects.nonNull(model)){
            throw new RuntimeException("Usuario ja cadastrado.");
        }
        
        userModel.setPassword(encriptPassWord(userModel.getPassword()));

        return repository.save(userModel);
    }


    private String encriptPassWord(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
}
