package br.com.moppahtech.todolist.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.moppahtech.todolist.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID>{
    
}
