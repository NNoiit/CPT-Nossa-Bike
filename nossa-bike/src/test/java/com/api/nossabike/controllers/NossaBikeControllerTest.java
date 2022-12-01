package com.api.nossabike.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class NossaBikeControllerTest {

    @InjectMocks
    private NossaBikeController bikeController;

    private String palavra;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startNossaBikeController();
        startPalavra();
    }

    @Test
    void getEcho() {

        String entrada = bikeController.getEcho(palavra);
        assertEquals(palavra + " " + palavra + " " + palavra, entrada);
    }

    @Test
    void Ola() {
        assertEquals("Olá mundo.", bikeController.ola());
    }

    //iniciando
    private void startNossaBikeController(){
        bikeController = new NossaBikeController();
    }
    private void startPalavra(){
        palavra = new String("test");
    }
}