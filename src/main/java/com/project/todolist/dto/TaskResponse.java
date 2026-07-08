package com.project.todolist.dto;

import com.project.todolist.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    private Long id;

    private String title;

    private LocalDateTime dateCreate;

    private LocalDateTime deadLine;

    private StatusEnum status;



}
