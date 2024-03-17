package org.example;

public class ParenthesesToken implements Token{
    private final TokenType type;

    /**
     * Конструктор для токена "Круглая скобка"
     * @param type - тип токена - открывающая или закрывающая скобка
     */
    public ParenthesesToken(TokenType type) {
        this.type = type;
    }

    /**
     * Переопределение метода type()
     * @return - возвращает тип круглой скобки
     */
    @Override
    public TokenType type() {
        if (type == TokenType.OPEN_BRACKET)
            return TokenType.OPEN_BRACKET;
        else
            return TokenType.CLOSE_BRACKET;
    }
}
