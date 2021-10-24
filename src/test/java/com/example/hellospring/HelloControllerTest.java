package com.example.hellospring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloControllerTest {
    @Test
    void HelloTest() {
        //given
        String expected = "Hello, World!";
        HelloController helloController = new HelloController();

        //when, then
        assertEquals(helloController.hello(), expected);
    }

}