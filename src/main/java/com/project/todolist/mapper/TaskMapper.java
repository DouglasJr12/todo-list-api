package com.project.todolist.mapper;


import com.project.todolist.dto.TaskRequest;
import com.project.todolist.dto.TaskResponse;
import com.project.todolist.entity.TaskEntity;
import com.project.todolist.enums.StatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class TaskMapper {

    public TaskEntity toTask(TaskRequest request){
        TaskEntity entity = new TaskEntity();

        entity.setTitle(request.getTitulo());
        entity.setDescription(request.getDescricao());
        entity.setDateCreate(LocalDateTime.now());
        entity.setDeadline(request.getDataLimite());
        entity.setStatus(StatusEnum.PENDENTE);

        return entity;
    }

    public TaskResponse toTaskResponse(TaskEntity entity){
        TaskResponse response = new TaskResponse();

        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDateCreate(entity.getDateCreate());
        response.setDeadLine(entity.getDeadline());
        response.setStatus(entity.getStatus());



        return response;
    }



}
