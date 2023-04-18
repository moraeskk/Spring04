package com.jae.api.controllers;

import com.jae.api.models.Produto;
import com.jae.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/produtos")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/novo")
    public ResponseEntity novoProduto(@RequestBody Produto produto) {

        service.adicionar(produto);
        return new ResponseEntity(produto, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity listarTodos() {

        return new ResponseEntity(service.ListarTudo(), HttpStatus.OK);

    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity listarPorCodigo(@PathVariable Integer codigo) {

        return new ResponseEntity(service.buscaPorCodigo(codigo), HttpStatus.OK);
    }

    @PutMapping(value = "/{codigo}")
    public ResponseEntity alterar(@PathVariable Integer codigo,@RequestBody Produto produto) {
        service.update(codigo,produto);
            return new ResponseEntity (produto,HttpStatus.OK);

    }
@DeleteMapping(value = "/{codigo}")
    public ResponseEntity remover(@PathVariable Integer codigo){
        service.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);

    }
}
