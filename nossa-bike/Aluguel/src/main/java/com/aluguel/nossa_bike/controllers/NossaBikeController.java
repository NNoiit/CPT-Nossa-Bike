package com.aluguel.nossa_bike.controllers;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
@Api(value="Spring Boot REST API")
public class NossaBikeController {

    @GetMapping("/OlaMundo")
    @ApiOperation(value = "Retorna Uma String")
    public String ola() {
        return "Olá, mundo.";
    }

}
