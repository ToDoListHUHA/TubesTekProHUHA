package com.wazooinc.springboottodoapplication.controllers;

import com.wazooinc.springboottodoapplication.models.TodoItem;
import com.wazooinc.springboottodoapplication.repositories.TodoItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // sebuah class yang berfungsi add, delete, dkk
public class TodoFormController {
    
    @Autowired // menghubungkan TodoItemRepository dengan database
    private TodoItemRepository todoItemRepository;

    @GetMapping("/create-todo") // sebagai perantara ketika user ingin melakukan create-todo pada html
    public String showCreateForm(TodoItem todoItem){
        return "add-todo-item"; // file html
    }
    // GetMapping berfungsi untuk mengakses link pada localhost.
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found")); // Exception yang akan dikeluarkan jika TodoItem tidak ditemukan.
    
        model.addAttribute("todo", todoItem);
        return "update-todo-item"; // file html
    }

    @GetMapping("/delete/{id}") // link localhost
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    
        todoItemRepository.delete(todoItem); // proses delete TodoItem
        return "redirect:/"; // Kembali ke link sebelumnya
    }

    
}
