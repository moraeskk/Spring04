package com.gerenciaTarefas.api.controller;

import com.gerenciaTarefas.api.models.Tarefas;
import com.gerenciaTarefas.api.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RequestMapping(value = "/tarefas")
@RestController
public class TaskController {

    @Autowired
    private TarefaService service;
    Tarefas tarefas;

    @RequestMapping(value = "/nova")
    public ResponseEntity novaTarefa(@RequestBody Tarefas tarefa) {

        service.adicionar(tarefa);
        return new ResponseEntity(tarefas, HttpStatus.CREATED);


    }

}
