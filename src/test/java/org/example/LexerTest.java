package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerTest {
    @Test
    public void testMethodThrowsException() {
        boolean exceptionThrown = false;
        Lexer lexer = new Lexer();
        try {
            lexer.getTokens("12 + 2 / 7 &");
        } catch (RuntimeException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}