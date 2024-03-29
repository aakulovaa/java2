package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LexerTest {
    /**
     * Тест метода разбиения строки на отдельные лексемы
     * Проверка на обработку исключения "Unexpected token"
     */
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