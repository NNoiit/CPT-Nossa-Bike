package com.api.nossabike.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OlaMundo")
public class NossaBikeController {

  @GetMapping
    public String ola(){
    return "Olá, mundo";
  }
}
