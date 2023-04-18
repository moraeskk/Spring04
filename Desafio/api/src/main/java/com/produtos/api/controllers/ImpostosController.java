package com.produtos.api.controllers;


import com.produtos.api.models.Impostos;

import com.produtos.api.services.ImpostosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RequestMapping(value = "/impostos",method = RequestMethod.GET)
@RestController
public class ImpostosController {

    @Autowired
    private ImpostosService service;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity novoImposto(@RequestBody Impostos impostos) {
        try {
            service.cadastrarImposto(impostos);
            return new ResponseEntity("Imposto cadastrado com sucesso! ", HttpStatus.CREATED);
        }catch(NoSuchElementException e){
            return new ResponseEntity("Não foi possivel cadastrar esse tipo de imposto.",HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/listar")
    public ResponseEntity listarImpostos(Impostos aliquota) {
        try {
            service.ListarImpostos(aliquota);
            return new ResponseEntity(service.ListarImpostos(aliquota), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity("Não foi possivel listar os impostos.",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{aliquota}")
    @Operation(summary = "Remove impostos", description = "Api para remoção de impostos.")
    public ResponseEntity removerImpostos(@PathVariable Integer aliquota) {
        try {
            service.removerImposto(aliquota);

            return new ResponseEntity("Imposto removido com sucesso! ", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel remover o imposto!Tente novamente.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{aliquota}")
    @Operation(summary = "Altera a aliquota", description = "Api para alterar o imposto.")
    public ResponseEntity alterarAliquota(@PathVariable Integer aliquota, @RequestBody Impostos nome) {
        try {
            service.update(aliquota, nome);
            return new ResponseEntity("Aliquota alterada com sucesso! ", HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel alterar a aliquota desejada!Tente novamente.", HttpStatus.BAD_REQUEST);
        }

    }
}
