package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/user")
    public ResponseEntity<?> listaUsuarios(){
        return userServiceImpl.listUsers();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> buscaUsuarioPorId(@PathVariable UUID id){
        return userServiceImpl.findUserById(id);
    }

    @PutMapping("/user")
    public  ResponseEntity<?> alteraUsuario(@RequestBody UserModel userModel){
        return userServiceImpl.updateUser(userModel);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> excluiUsuario(@PathVariable UUID id){

        return userServiceImpl.deleteUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<?> cadastraUsuario(@RequestBody UserModel userModel){
        return userServiceImpl.createUser(userModel);
    }





}
