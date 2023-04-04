package com.okBraga.todoList.controller;

import com.okBraga.todoList.model.SubTaskEntity;
import com.okBraga.todoList.service.SubTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-tasks")
@Slf4j
public class SubTaskController {

    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping
    public List<SubTaskEntity> getAllSubTasks() {
        log.info("Getting all subtasks");
        return subTaskService.findAll();
    }

    @PostMapping()
    SubTaskEntity createSubTask(@RequestBody SubTaskEntity subtask) {
        log.info("Creating subtask: {}", subtask);
        return subTaskService.create(subtask);
    }

    @PatchMapping("/{id}")
    public SubTaskEntity updateSubTask(@RequestBody SubTaskEntity newSubTask, @PathVariable Long id) {
        log.info("Updating subtask with id: {} to: {}", id, newSubTask);
        return subTaskService.update(id, newSubTask.getTitle(), newSubTask.getChecked());
    }

    @DeleteMapping("/{id}")
    void deleteSubTask(@PathVariable Long id) {
        log.info("Deleting subtask with id: {}", id);
        subTaskService.deleteById(id);
    }
}
