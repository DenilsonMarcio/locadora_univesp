package br.com.moppahtech.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.moppahtech.todolist.model.UserModel;
import br.com.moppahtech.todolist.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping()
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel){
        UserModel userCreated = service.createUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    } 
}
