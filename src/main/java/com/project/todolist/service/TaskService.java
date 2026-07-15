package com.project.todolist.service;

import com.project.todolist.dto.TaskRequest;
import com.project.todolist.entity.TaskEntity;
import com.project.todolist.enums.StatusEnum;
import com.project.todolist.exceptions.*;
import com.project.todolist.mapper.TaskMapper;
import com.project.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private void validateDeadline(LocalDateTime deadline) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limit = now.plusYears(1);

        if (deadline.isAfter(limit) || deadline.isBefore(now)) {
            throw new InvalidDeadlineException();
        }

    }

    private TaskEntity findTaskById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException());
    }

    public TaskEntity getTaskById(Long id) {
        return findTaskById(id);
    }

    public TaskEntity createTask(TaskRequest request) {

        TaskEntity task = mapper.toEntity(request);
        validateDeadline(task.getDeadline());

        return repository.save(task);
    }

    public List<TaskEntity> findAll() {
        List<TaskEntity> tasks = repository.findAll();
        if (tasks.isEmpty()) {
            return repository.findAll();
        }
        return tasks;
    }

    public TaskEntity updateTask(long id, TaskRequest request) {
        TaskEntity task = findTaskById(id);
        StatusEnum status = task.getStatus();

        if (status != StatusEnum.PENDING) {
            throw new TaskCannotBeUpdatedException();
        }

        validateDeadline(request.getDeadline());

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDeadline(request.getDeadline());

        return repository.save(task);
    }

    public void deleteTask(Long id) {
        TaskEntity task = findTaskById(id);
        repository.delete(task);
    }

    public TaskEntity updateFavoriteStatus(Long taskId, boolean favorito) {
        TaskEntity task = findTaskById(taskId);
        task.setFavorite(favorito);
        return repository.save(task);
    }

    public TaskEntity completeTask(Long id) {
        TaskEntity task = findTaskById(id);
        StatusEnum status = task.getStatus();
        if (status == StatusEnum.CANCELED) {
            throw new TaskAlreadyCancelledException();
        } else if (status == StatusEnum.COMPLETED) {
            throw new TaskAlreadyCompletedException();
        }
        task.setStatus(StatusEnum.COMPLETED);
        return repository.save(task);
    }

    public TaskEntity cancelTask(Long id) {
        TaskEntity task = findTaskById(id);
        StatusEnum status = task.getStatus();
        if (status == StatusEnum.COMPLETED) {
            throw new TaskAlreadyCompletedException();
        } else if (status == StatusEnum.CANCELED) {
            throw new TaskAlreadyCancelledException();
        }
        task.setStatus(StatusEnum.CANCELED);
        return repository.save(task);
    }
}