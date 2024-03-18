package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTokenTest {

    /**
     * Тест метода получения типа "число"
     */
    @Test
    void testType() {
        NumberToken numberToken = new NumberToken(5);
        assertEquals(TokenType.NUMBER,numberToken.type());
    }
}