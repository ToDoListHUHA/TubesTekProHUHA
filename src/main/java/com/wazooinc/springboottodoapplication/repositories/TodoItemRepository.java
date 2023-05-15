package com.wazooinc.springboottodoapplication.repositories;

import com.wazooinc.springboottodoapplication.models.TodoItem;
import org.springframework.data.repository.CrudRepository; // CrudRepository adalah interface yang memungkinkan operasi dasar CRUD

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {  // penggunaan interface
} // Class ini memiliki semua method yang dimiliki oleh "CrudRepository"
