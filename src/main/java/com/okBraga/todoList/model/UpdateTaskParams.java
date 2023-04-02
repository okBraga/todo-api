package com.okBraga.todoList.model;

//Todo change the type of finished to a Enum
public record UpdateTaskParams(String title, String description, TaskStatus status) {
}
