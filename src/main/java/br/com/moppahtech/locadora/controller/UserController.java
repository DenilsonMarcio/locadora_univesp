package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.dto.UserDTO;
import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> listaUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<UserDTO>> buscaUsuarioPorId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }

    @PutMapping("/user")
    public  ResponseEntity<UserDTO> alteraUsuario(@RequestBody UserModel userModel){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.upDateUser(userModel));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> excluiUsuario(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> cadastraUsuario(@RequestBody UserModel userModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userModel));
    }





}
