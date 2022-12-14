package com.aluguel.nossa_bike.controllers;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NossaBikeControllerTest {

    @Autowired
    NossaBikeController controller;

  @Test
    public void olaTest() {
    NossaBikeController c = new NossaBikeController();
    assertEquals(c.ola(), "Olá, mundo.");
  }
  @Test
    public void olaTestIT(){
            
    RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/").build();
            
    ResponseEntity<String> response = restTemplate
                .exchange("/OlaMundo", HttpMethod.GET, null, String.class);
            
    assertEquals("Olá, mundo.", response.getBody());
  }
}