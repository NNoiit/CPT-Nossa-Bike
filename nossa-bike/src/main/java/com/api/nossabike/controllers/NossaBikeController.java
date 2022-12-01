package com.api.nossabike.controllers;


import com.api.nossabike.services.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
@Api(value="Spring Boot REST API")
public class NossaBikeController {

    @Autowired
    private SwapiClient swapi;

    @GetMapping("/{palavra}")
    @ApiOperation(value = "Retorna repetição da palavra informada")
    public String getEcho(@PathVariable(value = "palavra") String palavra) {
        return palavra + " " + palavra + " " + palavra;
    }

    @GetMapping("/")
    @ApiOperation(value = "Retorna Uma String")
    public String getRoot() {
        return "Olá mundo.";
    }

}
