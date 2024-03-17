package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackMachineTest {

    /**
     * Тест метода вычисления на стековой машине
     */
    @Test
    void testEvaluate() {
        Lexer lexer = new Lexer();
        PostfixConverter converter = new PostfixConverter();
        StackMachine stackMachine = new StackMachine();
        List<Token> tokens = lexer.getTokens("1 + (2+3)  - 5");
        List<Token> tokens1 = converter.convertToPostfix(tokens);
        Integer result = stackMachine.evaluate(tokens1);
        assertEquals(1,result);
    }

    /**
     * Тест метода вычисления на стековой машине
     * Проверка на обработку исключения "Деление на ноль"
     */
    @Test
    public void testMethodThrowsException() {
        boolean exceptionThrown = false;
        Lexer lexer = new Lexer();
        PostfixConverter converter = new PostfixConverter();
        StackMachine stackMachine = new StackMachine();
        List<Token> tokens = lexer.getTokens("1 + (2+3)  - 5 /0");
        List<Token> tokens1 = converter.convertToPostfix(tokens);
        try {
            stackMachine.evaluate(tokens1);
        } catch (RuntimeException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}