package org.example;

import java.util.List;

/**
 * Класс Калькулятор для вычисления выражения
 */
public class Calculator {
    private final Lexer lexer = new Lexer();
    private final PostfixConverter converter = new PostfixConverter();
    private final StackMachine stackMachine = new StackMachine();

    /**
     *  Метод вычисления заданного выражения
     * @param expression - исходное выражение
     * @return - возвращает вычисленное значение
     */
    public int calculate(String expression){
        List<Token> tokens = lexer.getTokens(expression);
        List<Token> postfixExpression = converter.convertToPostfix(tokens);
        int result = stackMachine.evaluate(postfixExpression);
        System.out.println(result);
        return result;
    }
}
