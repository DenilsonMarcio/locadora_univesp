package br.com.moppahtech.locadora.service.impl;

import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> listUsers(){
      return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findUserById(UUID id){
        return new ResponseEntity<>(userRepository.findById(id),HttpStatus.FOUND);
    }

    public ResponseEntity<?> updateUser(UserModel userModel){
                return new ResponseEntity<>(userRepository.save(userModel),HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUser(UUID id){
      userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    public ResponseEntity<?> createUser(UserModel userModel){
        return new ResponseEntity<>(userRepository.save(userModel), HttpStatus.CREATED);
    }

}
