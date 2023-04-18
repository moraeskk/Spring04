package com.jae.api.services;

import com.jae.api.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produtoQueSeraSalvo) {
        produtos.add(produtoQueSeraSalvo);


    }

    public List<Produto> ListarTudo() {
        return produtos;
    }

    public Produto buscaPorCodigo(Integer codigo) {
        return produtos.stream().filter(p -> codigo.equals(p.getCodigo())).findFirst().orElseThrow();
    }

    public void update(Integer codigo, Produto produto) {
        remover(codigo);
            adicionar(produto);
    }

    public void remover(Integer codigo) {
        Produto produtoPesquisa = buscaPorCodigo(codigo);
        if (produtoPesquisa != null) {
            produtos.remove(produtoPesquisa);
        }
    }
}
