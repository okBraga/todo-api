package com.okBraga.todoList.service;

import com.okBraga.todoList.exception.TaskNotFoundException;
import com.okBraga.todoList.model.SubTaskEntity;
import com.okBraga.todoList.repository.SubTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {

    SubTaskRepository subTaskRepository;

    public SubTaskService(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    public SubTaskEntity create(SubTaskEntity subTask) {
        subTask.setChecked(false);
        return subTaskRepository.save(subTask);
    }

    public List<SubTaskEntity> findAll() {
        return subTaskRepository.findAll();
    }

    public SubTaskEntity update(Long id, String title, Boolean isChecked) {
        SubTaskEntity existingSubTask = subTaskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        if (title != null) {
            existingSubTask.setTitle(title);
        }
        if (isChecked != null) {
            existingSubTask.setChecked(!existingSubTask.getChecked());
        }

        return subTaskRepository.save(existingSubTask);
    }

    public void deleteById(Long id) {
        subTaskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        subTaskRepository.deleteById(id);
    }
}
