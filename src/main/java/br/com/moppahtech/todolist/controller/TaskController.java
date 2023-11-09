package br.com.moppahtech.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.moppahtech.todolist.model.TaskModel;
import br.com.moppahtech.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskModel> create (@RequestBody TaskModel taskModel){
        TaskModel taskCreated = service.createTask(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping()
    public ResponseEntity<String> testController(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello Univesp Path Task!!!");
    }
    
}
