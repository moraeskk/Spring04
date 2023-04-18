package com.produtos.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Produto {

    private Integer codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Impostos valorImpostos;
    private LocalDate dataValidade;

}
