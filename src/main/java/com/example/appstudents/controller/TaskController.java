package com.example.appstudents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getAllTasks(){
        return "tasks/tasks";
    }
    @GetMapping("/addTask")
    public String getAddTask(){
        return "tasks/addTask";
    }
}
