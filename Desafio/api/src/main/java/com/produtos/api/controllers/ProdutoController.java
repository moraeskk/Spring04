package com.produtos.api.controllers;

import com.produtos.api.models.Impostos;
import com.produtos.api.models.Produto;
import com.produtos.api.services.ImpostosService;
import com.produtos.api.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RequestMapping(value = "/produtos")
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @Autowired
    private ImpostosService impService;

    @PostMapping(value = "/cadastrar")
    @Operation(summary = "Cadastro de produtos", description = "Api para cadastragem de produtos.")
    public ResponseEntity novoProduto(@RequestBody Produto codigo) {
        try {
            service.adicionar(codigo);
            return new ResponseEntity("Produto cadastrado com sucesso! ", HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Produto não cadastrado!tente novamente.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Lista produtos", description = "Api para listagem de produtos.")
    public ResponseEntity listarProdutos(Produto codigo) {

        try {
            service.listarProduto(codigo.getCodigo());
            return new ResponseEntity(service.listarProduto(codigo.getCodigo()), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foram encontrados produtos cadastrados", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{codigo}")
    @Operation(summary = "Lista produtos via codigo", description = "Api para listagem de produtos especificos.")
    public ResponseEntity listarPorCodigo(@PathVariable Integer codigo) {

        try {
            service.buscaPorCodigo(codigo);

            return new ResponseEntity(service.buscaPorCodigo(codigo), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi encontrado nenhum produto cadastrado com o codigo enviado anteriormente,tente novamente!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{codigo}")
    @Operation(summary = "Altera produto", description = "Api para alterar algo no produto.")
    public ResponseEntity alterarProduto(@PathVariable Integer codigo, @RequestBody Produto produto) {
        try {
            service.update(codigo, produto);
            return new ResponseEntity("Produto alterado com sucesso! ", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel alterar o produto!Tente novamente.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{codigo}")
    @Operation(summary = "Remove produtos", description = "Api para remoção de produtos.")
    public ResponseEntity removerProduto(@PathVariable Integer codigo) {
        try {
            service.remover(codigo);

            return new ResponseEntity("Produto removido com sucesso! ", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel remover o produto!Tente novamente.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/associarimposto/{codigo}/{aliquota}")
    @Operation(summary = "Associar imposto a produto", description = "Api para associação de imposto a produto.")
    public ResponseEntity<Produto> associarImposto(@PathVariable Integer codigo, @PathVariable  Integer aliquota) {
        Produto produto = service.buscaPorCodigo(codigo);
        Impostos imposto = impService.buscarImposto(aliquota);

        try {

            if (produto != null && imposto != null) {
               produto.setValorImpostos(imposto);
                service.update(codigo, produto);
                return ResponseEntity.ok(produto);
            }
            return new ResponseEntity("imposto associado a produto com sucesso!", HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity("Não foi possivel associar o imposto ao produto!Tente novamente.",HttpStatus.BAD_REQUEST);
        }
    }
}
