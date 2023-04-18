package com.jae.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class Produto {

    private Integer codigo;
    private String descricao;
    private BigDecimal precoVenda;
    private LocalDate dataValidade;

}
