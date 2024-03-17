package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesTokenTest {

    @Test
    void testType() {
        ParenthesesToken parenthesesToken = new ParenthesesToken(TokenType.OPEN_BRACKET);
        assertEquals(TokenType.OPEN_BRACKET,parenthesesToken.type());
    }
}