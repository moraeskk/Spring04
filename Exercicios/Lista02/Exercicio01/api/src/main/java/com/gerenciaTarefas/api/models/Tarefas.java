package com.gerenciaTarefas.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Tarefas {

    private String titulo;
    private String descricao;
    private LocalDate dataVencimento;

}

