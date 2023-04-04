package com.okBraga.todoList.repository;

import com.okBraga.todoList.model.SubTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTaskEntity, Long> {
}
