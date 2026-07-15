package com.project.todolist.mapper;


import com.project.todolist.dto.TaskRequest;
import com.project.todolist.dto.TaskResponse;
import com.project.todolist.entity.TaskEntity;
import com.project.todolist.enums.StatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class TaskMapper {

    public TaskEntity toEntity(TaskRequest request){
        TaskEntity entity = new TaskEntity();

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setDeadline(request.getDeadline());
        entity.setFavorite(false);
        entity.setStatus(StatusEnum.PENDING);

        return entity;
    }

    public TaskResponse toResponse(TaskEntity entity){
        TaskResponse response = new TaskResponse();

        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setCreatedAt(entity.getCreatedAt());
        response.setDeadline(entity.getDeadline());
        response.setStatus(entity.getStatus());
        response.setFavorite(entity.isFavorite());

        return response;
    }

    public List<TaskResponse> toTaskResponseList(List<TaskEntity> entities){
        return entities.stream().map(this::toResponse).toList();

    }





}
