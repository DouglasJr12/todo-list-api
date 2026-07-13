package com.project.todolist.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter

public class TaskRequest {

    @NotBlank(message = "Titulo da tarefa é obrigatório")
    @Size(min = 6, max = 40)
    private String titulo;

    @NotBlank(message = "Descrição obrigatória")
    @Size(max = 500)
    private String descricao;


    private LocalDateTime dataCreate;

    @NotNull
    @FutureOrPresent(message = "Data limite deve ser hoje ou no futuro.")
    private LocalDateTime deadline;




}
