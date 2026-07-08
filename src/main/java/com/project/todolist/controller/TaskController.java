package com.project.todolist.controller;


import com.project.todolist.entity.TaskEntity;
import com.project.todolist.dto.TaskRequest;
import com.project.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskEntity criarTask(@Valid @RequestBody TaskRequest request) {
        return service.criarTask(request);
    }

    @PatchMapping("/{id}/favorite/{favorite}")
    public TaskEntity alterarFavorito(@PathVariable Long id, @PathVariable boolean favorite){
        return  service.atualizarFavorito(id, favorite);
    }

    @PatchMapping("/{id}/concluir")
    public TaskEntity concluirTask(@PathVariable Long id){
        return service.concluirTask(id);
    }

    @PatchMapping("/{id}/cancelar")
    public TaskEntity cancelarTask(@PathVariable Long id){
        return service.cancelarTask(id);
    }

    @GetMapping
    public List<TaskEntity> listarTask() {
        return service.listarTudo();
    }

    @GetMapping("/{id}")
    public TaskEntity buscaTaskPorId(@PathVariable Long id){
        return service.obterTaskPorId(id);
    }

    @PutMapping("/{id}")
    public TaskEntity atualizarTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        return service.atualizarTask(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarTask(id);
        return ResponseEntity.noContent().build();
    }

}
