package com.wazooinc.springboottodoapplication.models;

// import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private LocalDate createdDate; //ubah

    @Getter
    @Setter
    private LocalDate modifiedDate;

    public TodoItem() {}

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = LocalDate.now(); //localdate
        this.modifiedDate = LocalDate.now();
    }
    
    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
        id, description, complete, createdDate, modifiedDate);
    }

    
}