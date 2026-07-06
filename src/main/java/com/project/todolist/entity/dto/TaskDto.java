package com.project.todolist.entity.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter

public class TaskDto {

    @NotBlank(message = "Titulo da tarefa é obrigatório")
    @Size(min = 6, max = 40)
    private String titulo;

    @Size(max = 500)
    private String descricao;


    @FutureOrPresent(message = "Data limite deve ser hoje ou no futuro.")
    private LocalDateTime dataLimite;

}
