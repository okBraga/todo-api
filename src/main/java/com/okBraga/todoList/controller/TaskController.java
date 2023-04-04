package com.okBraga.todoList.controller;

import com.okBraga.todoList.model.TaskEntity;
import com.okBraga.todoList.model.UpdateTaskParams;
import com.okBraga.todoList.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        log.info("Getting all tasks");
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable Long id) {
        log.info("Getting task with id: {}", id);
        return taskService.findById(id);
    }

    @PostMapping()
    TaskEntity createTask(@RequestBody TaskEntity task) {
        log.info("Creating task: {}", task);
        return taskService.create(task);
    }

    @PatchMapping("/{id}")
    public TaskEntity updateTask(@RequestBody UpdateTaskParams newTask, @PathVariable Long id) {
        log.info("Updating task with id: {} to: {}", id, newTask);
        return taskService.update(id, newTask.title(), newTask.description(), newTask.status());
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id) {
        log.info("Deleting task with id: {}", id);
        taskService.deleteById(id);
    }
}
