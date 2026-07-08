package com.project.todolist.controller;


import com.project.todolist.dto.TaskResponse;
import com.project.todolist.entity.TaskEntity;
import com.project.todolist.dto.TaskRequest;
import com.project.todolist.mapper.TaskMapper;
import com.project.todolist.service.TaskService;
import jakarta.validation.Valid;
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
    public TaskResponse criarTask(@Valid @RequestBody TaskRequest request) {
        return mapper.toTaskResponse(service.criarTask(request));
    }

    @PatchMapping("/{id}/favorite/{favorite}")
    public TaskResponse alterarFavorito(@PathVariable Long id, @PathVariable boolean favorite){
        return  mapper .toTaskResponse(service.atualizarFavorito(id, favorite));
    }

    @PatchMapping("/{id}/concluir")
    public TaskResponse concluirTask(@PathVariable Long id){
        return mapper.toTaskResponse(service.concluirTask(id));
    }

    @PatchMapping("/{id}/cancelar")
    public TaskResponse cancelarTask(@PathVariable Long id){
        return mapper.toTaskResponse(service.cancelarTask(id));
    }

    @GetMapping
    public List<TaskEntity> listarTask() {
        return service.listarTudo();
    }

    @GetMapping("/{id}")
    public TaskResponse buscaTaskPorId(@PathVariable Long id){
        return mapper.toTaskResponse(service.obterTaskPorId(id));
    }

    @PutMapping("/{id}")
    public TaskResponse atualizarTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        return mapper.toTaskResponse(service.atualizarTask(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarTask(id);
        return ResponseEntity.noContent().build();
    }

}
