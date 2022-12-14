package com.api.equipamento.controller;


import com.api.equipamento.model.Bicicleta;
import com.api.equipamento.repositori.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipamentoController {

    @Autowired
    private Repository bicicleta;

    @Autowired
    private RepTranca tranca;

    @Autowired
    private Service service;

    @GetMapping("/")
    public String getBicicletas(){
        return "Tudo normal por enquanto";
    }

    @PostMapping("/bicicleta")
    public ResponseEntity<?> postBicicleta(@RequestBody Bicicleta bike){
        return service.cadastrar(bike);
    }

    @GetMapping("/bicicleta")
    public ResponseEntity<?> getBicicleta(){
        return Service.listarBicicletas();
    }

    @GetMapping("/bicicleta/{id}")
    public ResponseEntity<?> getBicicleta(@PathVariable int id){

        return service.bicicletaFindId(id);
    }

    @PutMapping("/bicicleta/{id}")
    public ResponseEntity<?> putBicicleta(@RequestBody Bicicleta bike, @PathVariable int id){
        return service.alterarBicicleta(id);
    }

    @DeleteMapping("/bicicleta/{id}")
    public void deleteBicicletaId(@PathVariable int id){
        service.excluirBicicleta(id);
    }

    @PutMapping("/bicicleta/{id}/status/{acao}")
    public Bicicleta putStatusBicicleta(@RequestBody String novoStatus, @PathVariable int id. @PathVariable String acao){

        Bicicleta bc = bicicleta.findById(id);

        bc.setStatus(novoStatus);
        return bicicleta.save(bc);
    }

    //////////////////////////////////////////////////////

    @PostMapping("/tranca")
    public ResponseEntity<?> postTranca(@RequestBody Tranca trc){
        return service.cadastrarTranca(trc);
    }

    @GetMapping("/tranca")
    public ResponseEntity<?> getTranca(){
        return service.listarTrancas();
    }

    @GetMapping("/tranca/{id}")
    public ResponseEntity<?> getTranca(@PathVariable int id){
        return service.trancaFindId(id);
    }

    @PutMapping("/tranca/{id}")
    public ResponseEntity<?> putTranca(@RequestBody Tranca trc, @PathVariable int id){
        return service.alterarTranca(id);
    }

    @DeleteMapping("/tranca/{id}")
    public void deleteTrancaId(@PathVariable int id){
        service.excluirTranca(id);
    }


}
