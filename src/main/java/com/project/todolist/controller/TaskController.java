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
    public ResponseEntity<TaskResponse> criarTask(@Valid @RequestBody TaskRequest request) {
        TaskResponse response = mapper.toTaskResponse(service.criarTask(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response) ;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listarTask() {
        List<TaskResponse> responses = mapper.toTaskResponseList(service.listarTudo());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> buscaTaskPorId(@PathVariable Long id){
        TaskResponse response = mapper.toTaskResponse(service.obterTaskPorId(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> atualizarTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        TaskResponse response = mapper.toTaskResponse(service.atualizarTask(id, request));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/favorite/{favorite}")
    public ResponseEntity<TaskResponse> alterarFavorito(@PathVariable Long id, @PathVariable boolean favorite){
        TaskResponse response = mapper .toTaskResponse(service.atualizarFavorito(id, favorite));
        return  ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<TaskResponse> concluirTask(@PathVariable Long id){
        TaskResponse response = mapper.toTaskResponse(service.concluirTask(id));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<TaskResponse> cancelarTask(@PathVariable Long id){
        TaskResponse response = mapper.toTaskResponse(service.cancelarTask(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarTask(id);
        return ResponseEntity.noContent().build();
    }

}
