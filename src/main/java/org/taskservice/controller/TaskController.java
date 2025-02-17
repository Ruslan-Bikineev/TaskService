package org.taskservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taskservice.entity.Task;
import org.taskservice.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/id")
    public Task getById(@PathVariable("id") Long id) {
        return taskService.getById(id);
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/id")
    public Task put(@PathVariable("id") Long id,
                    @RequestBody Task task) {
        return taskService.put(task);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}