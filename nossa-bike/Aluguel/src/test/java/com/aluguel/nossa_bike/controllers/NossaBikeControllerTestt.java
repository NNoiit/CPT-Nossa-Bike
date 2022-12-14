package com.api.nossabike.controllers;



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