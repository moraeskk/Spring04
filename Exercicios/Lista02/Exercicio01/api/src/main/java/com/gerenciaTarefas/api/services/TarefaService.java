package com.gerenciaTarefas.api.services;

import com.gerenciaTarefas.api.models.Tarefas;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private List<Tarefas> tarefa = new ArrayList<>();

    public void adicionar(Tarefas tarefaQueSeraSalva){

        tarefa.add(tarefaQueSeraSalva);
    }



}
