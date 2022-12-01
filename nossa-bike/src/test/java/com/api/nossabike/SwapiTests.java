package com.api.nossabike;

import com.api.nossabike.services.Swapi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapiTests {
    @Test
    public void ReturnTruegetName() {
        Swapi swapi = new Swapi();
        String resul = swapi.getName();

        Assertions.assertEquals("Pedro melhor monitor", resul);
    }
}
