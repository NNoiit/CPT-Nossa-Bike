package com.api.nossabike;

import static org.junit.Assert.assertEquals;

import com.api.nossabike.controllers.NossaBikeController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;




@SpringBootApplication
public class NossaBikeApplicationTests{
    
  @Autowired
    NossaBikeController controller;

  @Test
    public void olaTest() {
    NossaBikeController c = new NossaBikeController();
    assertEquals("Olá, mundo", c.ola());
  }
    
  @Test
    public void olaTestIT(){
            
    RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/").build();
            
    ResponseEntity<String> response = restTemplate
                .exchange("/OlaMundo", HttpMethod.GET, null, String.class);
            
    assertEquals(response.getBody(), "Olá, mundo");
  }
}
