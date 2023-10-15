package br.com.moppahtech.todolist.service;

import org.springframework.stereotype.Service;

import br.com.moppahtech.todolist.enums.Priority;
import br.com.moppahtech.todolist.model.TaskModel;
import br.com.moppahtech.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public TaskModel createTask(TaskModel taskModel) {
        
        taskModel.setPriority(getPriorityTask(taskModel.getPriority()));
        
        return repository.save(taskModel);
    }

    private String getPriorityTask(String priority) {
        if(priority.equals("0")){
            return Priority.NIVEL_0.getValue();
        }

        if(priority.equals("1")){
            return Priority.NIVEL_1.getValue();
        }

        if(priority.equals("2")){
            return Priority.NIVEL_2.getValue();
        }
        return "Not Priority";
    }
    
}
