package org.example;

import org.example.Token;
import org.example.TokenType;

public class NumberToken implements Token {
    public final int value;

    /**
     * Конструктор для токена "число"
     * @param value - целочисленное значение этого токена
     */
    public NumberToken(int value) {
        this.value = value;
    }

    /**
     * Переопределение метода type()
     * @return - возвращяет тип бинарной оперции - число
     */
    @Override
    public TokenType type() {return TokenType.NUMBER;}
}
