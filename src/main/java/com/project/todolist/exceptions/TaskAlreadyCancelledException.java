package com.project.todolist.exceptions;

public class TaskAlreadyCancelledException extends RuntimeException {


    public TaskAlreadyCancelledException(){
        super("Operação inválida: Tarefa já cancelada");
    }
}
