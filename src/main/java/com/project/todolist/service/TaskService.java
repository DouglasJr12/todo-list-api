package com.project.todolist.service;

import com.project.todolist.dto.TaskRequest;
import com.project.todolist.entity.TaskEntity;
import com.project.todolist.enums.StatusEnum;
import com.project.todolist.exceptions.TaskAlreadyCancelledException;
import com.project.todolist.exceptions.TaskAlreadyCompletedException;
import com.project.todolist.exceptions.TaskNotFoundException;
import com.project.todolist.mapper.TaskMapper;
import com.project.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    private TaskEntity buscarTaskPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException());
    }

    public TaskEntity obterTaskPorId(Long id) {
        return buscarTaskPorId(id);
    }

    public TaskEntity criarTask(TaskRequest request) {
        TaskEntity task = taskMapper.toTask(request);
        return repository.save(task);
    }

    public List<TaskEntity> listarTudo() {
        List<TaskEntity> tasks = repository.findAll();
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException();
        }
        return tasks;
    }

    public TaskEntity atualizarTask(long id, TaskRequest dto) {
        TaskEntity task = buscarTaskPorId(id);
        task.setTitle(dto.getTitulo());
        task.setDescription(dto.getDescricao());
        task.setDeadline(dto.getDataLimite());
        return repository.save(task);
    }

    public void deletarTask(Long id) {
        TaskEntity task = buscarTaskPorId(id);
        repository.delete(task);
    }

    public TaskEntity atualizarFavorito(Long taskID, boolean favorito) {
        TaskEntity task = buscarTaskPorId(taskID);
        task.setFavorite(favorito);
        return repository.save(task);
    }

    public TaskEntity concluirTask(Long id) {
        TaskEntity task = buscarTaskPorId(id);
        StatusEnum status = task.getStatus();
        if (status == StatusEnum.CANCELADO) {
            throw new TaskAlreadyCancelledException();
        } else if (status == StatusEnum.CONCLUIDA) {
            throw new TaskAlreadyCompletedException();
        }
        task.setStatus(StatusEnum.CONCLUIDA);
        return repository.save(task);
    }

    public TaskEntity cancelarTask(Long id) {
        TaskEntity task = buscarTaskPorId(id);
        StatusEnum status = task.getStatus();
        if (status == StatusEnum.CONCLUIDA) {
            throw new TaskAlreadyCompletedException();
        } else if (status == StatusEnum.CANCELADO) {
            throw new TaskAlreadyCancelledException();
        }
        task.setStatus(StatusEnum.CANCELADO);
        return repository.save(task);
    }
}