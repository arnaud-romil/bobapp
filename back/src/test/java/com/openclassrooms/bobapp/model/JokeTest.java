package com.openclassrooms.bobapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JokeTest {

    @Test
    void testJoke() {
        Joke joke = new Joke("Why did the chicken cross the road?", "To get to the other side!");
        assertEquals("Why did the chicken cross the road?", joke.getJoke());
        assertEquals("To get to the other side!", joke.getResponse());
    }

}
