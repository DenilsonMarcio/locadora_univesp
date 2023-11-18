package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import br.com.moppahtech.locadora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> listUsers(){
      return userRepository.findAll();
    }


    public Optional<UserModel> findUserById(UUID id){
        return userRepository.findById(id);
    }



    public UserModel upDateUser(UserModel userModel){
                return userRepository.save(userModel);
    }

    public void deleteUser(UUID id){
      userRepository.deleteById(id);
    }

    public UserModel createUser(UserModel userModel){
        return userRepository.save(userModel);
    }

}
