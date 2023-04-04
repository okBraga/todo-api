package com.okBraga.todoList.service;

import com.okBraga.todoList.exception.TaskNotFoundException;
import com.okBraga.todoList.model.TaskEntity;
import com.okBraga.todoList.model.TaskStatus;
import com.okBraga.todoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity create(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public TaskEntity findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public TaskEntity update(Long id, String title, String description, TaskStatus status) {
        TaskEntity existingTask = findById(id);
        if (title != null) {
            existingTask.setTitle(title);
        }
        if (description != null) {
            existingTask.setDescription(description);
        }
        if (status != null) {
            existingTask.setStatus(status);
        }
        existingTask.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(existingTask);
    }

    public void deleteById(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.deleteById(id);
    }
}