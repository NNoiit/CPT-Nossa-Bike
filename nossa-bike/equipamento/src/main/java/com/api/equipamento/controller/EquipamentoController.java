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

    @PutMapping("/bicicleta/{id}/status/{bicicleta}")
    public Bicicleta putStatusBicicleta(@RequestBody String novoStatus, @PathVariable int id){

        Bicicleta bc = bicicleta.findById(id);

        bc.setStatus(novoStatus);
        return bicicleta.save(bc);
    }

    @GetMapping("/bicicleta/alugadaPor/{idCiclista}")
    public Bicicleta getBicicletaAlugada(@PathVariable int idCiclista){

        return bike;
    }

    //////////////////////////////////////////////////////

@PostMapping("/tranca")
    public Tranca postTranca(@RequestBody Tranca trc){
        return tranca.save(trc);
    }

    @GetMapping("/tranca")
    public List<Tranca> getTranca(){
        return tranca.findAll();
    }

    @GetMapping("/tranca/{id}")
    public Tranca getTranca(@PathVariable int id){

        return tranca.findById(id);
    }

    @PutMapping("/tranca/{id}")
    public Tranca putTranca(@RequestBody Tranca trc, @PathVariable int id){

        Tranca trcA = tranca.findById(id);

        trcA.setNumero(trc.getNumero());
        trcA.setLocalizacao(trc.getLocalizacao());
        trcA.setAnoDeFabricacao(trc.getAnoDeFrabricacao());
        trcA.setModelo(trc.getModelo());
        trcA.setStatus(trc.getStatus());

        return tranca.save(trcA);
    }

    @DeleteMapping("/tranca/{id}")
    public void deleteBicicletaId(@PathVariable int id){
        Tranca trc = tranca.findById(id);
        tranca.delete(bc);
    }

    @PutMapping("/bicicleta/{id}/status/{bicicleta}")
    public Bicicleta putStatusBicicleta(@RequestBody String novoStatus, @PathVariable int id){

        Bicicleta bc = bicicleta.findById(id);

        bc.setStatus(novoStatus);
        return bicicleta.save(bc);
    }

    @GetMapping("/bicicleta/alugadaPor/{idCiclista}")
    public Bicicleta getBicicletaAlugada(@PathVariable int idCiclista){

        return bike;
    }


}
