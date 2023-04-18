package com.produtos.api.services;

import com.produtos.api.models.Impostos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ImpostosService {

    private List<Impostos> impostos = new ArrayList<>();

    public List<Impostos> ListarImpostos(Impostos aliquota) {
        return impostos;
    }

    public Impostos buscarImposto(Integer aliquota) {
        return impostos.stream().filter(p -> aliquota.equals(p.getAliquota())).findFirst().orElseThrow();
    }

    public void cadastrarImposto(Impostos novoImposto) {
        impostos.add(novoImposto);
    }

    public void update(Integer aliquota, Impostos imposto) {
        removerImposto(aliquota);
        cadastrarImposto(imposto);
    }

    public void removerImposto(Integer aliquota) {
        Impostos impostoPesquisa = buscarImposto(aliquota);
        if (impostoPesquisa != null) {
            impostos.remove(impostoPesquisa);
        }
    }

}


