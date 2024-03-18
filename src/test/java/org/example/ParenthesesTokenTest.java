package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesTokenTest {

    /**
     * Тест метода получения типа "открытая скобка"
     */
    @Test
    void testType() {
        ParenthesesToken parenthesesToken = new ParenthesesToken(TokenType.OPEN_BRACKET);
        assertEquals(TokenType.OPEN_BRACKET,parenthesesToken.type());
    }

    /**
     * Тест метода получения типа "закрытая скобка"
     */
    @Test
    void testType2() {
        ParenthesesToken parenthesesToken = new ParenthesesToken(TokenType.CLOSE_BRACKET);
        assertEquals(TokenType.CLOSE_BRACKET,parenthesesToken.type());
    }
}