package org.example;

import org.example.OperationType;
import org.example.Token;
import org.example.TokenType;

/**
 * Класс для токена "Бинарная операция" со свойством <b>operationType</b>
 */
public class BinaryOperationToken implements Token {
    private final OperationType operationType;

    /**
     * Конструктор для токена "Бинарная операция"
     * @param operationType - дополнительная метаинформация о типе бинарной операции
     */
    public BinaryOperationToken(OperationType operationType) {
        this.operationType = operationType;
    }

    /**
     * Переопределение метода type()
     * @return - возвращвет тип - бинарная операция
     */
    @Override
    public TokenType type() {return TokenType.BINARY_OPERATION;}

    /**
     * Метод для получения типа бинарной операции
     * @return - возвращает тип бинарной операции
     */
    public OperationType getOperationType() {
        return operationType;
    }
}
