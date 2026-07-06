package com.project.todolist.entity;

import com.project.todolist.entity.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime dateCreate;

    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private boolean favorite;


}