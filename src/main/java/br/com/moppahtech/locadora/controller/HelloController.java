package br.com.moppahtech.locadora.controller;

import br.com.moppahtech.locadora.model.UserModel;
import br.com.moppahtech.locadora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserModel> create (@RequestBody UserModel userModel){
        UserModel userCreated = userService.createUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
    @GetMapping()
    public ResponseEntity<String> testController(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello Norfan!!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getUsers(){
        List<UserModel> list = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
