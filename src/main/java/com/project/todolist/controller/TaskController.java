package com.project.todolist.controller;


import com.project.todolist.dto.TaskRequest;
import com.project.todolist.dto.TaskResponse;
import com.project.todolist.mapper.TaskMapper;
import com.project.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final TaskMapper mapper;

    public TaskController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest request) {
        TaskResponse response = mapper.toResponse(service.createTask(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response) ;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTask() {
        List<TaskResponse> responses = mapper.toTaskResponseList(service.findAll());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id){
        TaskResponse response = mapper.toResponse(service.getTaskById(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        TaskResponse response = mapper.toResponse(service.updateTask(id, request));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/favorite/{favorite}")
    public ResponseEntity<TaskResponse> updateFavoriteStatus(@PathVariable Long id, @PathVariable boolean favorite){
        TaskResponse response = mapper .toResponse(service.updateFavoriteStatus(id, favorite));
        return  ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> completeTask(@PathVariable Long id){
        TaskResponse response = mapper.toResponse(service.completeTask(id));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<TaskResponse> cancelTask(@PathVariable Long id){
        TaskResponse response = mapper.toResponse(service.cancelTask(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
