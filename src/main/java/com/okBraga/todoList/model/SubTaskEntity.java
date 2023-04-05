package com.okBraga.todoList.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sub-tasks")
public class SubTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean isChecked;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    public SubTaskEntity(Long id, Boolean isChecked, String title) {
        this.id = id;
        this.isChecked = isChecked;
        this.title = title;
    }

    public SubTaskEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
