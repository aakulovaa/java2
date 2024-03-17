package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryOperationTokenTest {

    /**
     * Тест метода получения типа "бинарная операция"
     */
    @Test
    void testType() {
        BinaryOperationToken binaryOperationToken = new BinaryOperationToken(OperationType.PLUS);
        assertEquals(TokenType.BINARY_OPERATION,binaryOperationToken.type());
    }

    /**
     * Тест метода получения типа бинарной операции (+,-,*,/)
     */
    @Test
    void testGetOperationType() {
        BinaryOperationToken binaryOperationToken = new BinaryOperationToken(OperationType.PLUS);
        assertEquals(OperationType.PLUS,binaryOperationToken.getOperationType());
    }
}