package com.produtos.api.services;

import com.produtos.api.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public void remover(Integer codigo) {

        Produto produtoPesquisa = buscaPorCodigo(codigo);
        if (produtoPesquisa != null) {
            produtos.remove(produtoPesquisa);
        }
    }

    public void adicionar(Produto novoProduto) {
        produtos.add(novoProduto);

    }

    public List<Produto> listarProduto(Integer codigo) {
        return produtos;
    }

    public void update(Integer codigo, Produto produto) {
        remover(codigo);
        adicionar(produto);
    }

    public  Produto buscaPorCodigo(Integer codigo) {
        return produtos.stream().filter(p -> codigo.equals(p.getCodigo())).findFirst().orElseThrow();
    }
}

