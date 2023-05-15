package com.wazooinc.springboottodoapplication.controllers;

import java.time.DayOfWeek;
// import java.time.Instant;
// import java.time.ZoneId;
import java.time.LocalDate;

import javax.validation.Valid;

import com.wazooinc.springboottodoapplication.models.TodoItem;
import com.wazooinc.springboottodoapplication.repositories.TodoItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // menangani permintaan pada http
public class TodoItemController {
    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class); // menyetak pesan log pada TodoItemController

    @Autowired // Sebagai perantara antara class dan database
    private TodoItemRepository todoItemRepository;

    @GetMapping("/") // GetMapping menampilkan alamat link
    public ModelAndView index() { // sebagai tampilan awal
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll()); // memanggil semua atribut todoItems
        modelAndView.addObject("today", DayOfWeek.from(LocalDate.now())); // diganti agar jadi hari ini atau tepat hari disaat dibukanya
        return modelAndView;
    }

    @PostMapping("/todo") // PostMapping tidak menampilkan alamat ke link
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) { //create
            return "add-todo-item";
        }

        todoItem.setCreatedDate(LocalDate.now()); // mengubah atribut setCreatedDate dengan LocalDate.now
        todoItem.setModifiedDate(LocalDate.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) { //update
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModifiedDate(LocalDate.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
    }
