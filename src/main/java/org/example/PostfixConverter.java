package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Класс, формурующий выражение, которое можно вычислить за один проход
 */
public class PostfixConverter {
    /**
     * Метод, реализующий алгоритм сортировочной станции.
     * Формарует выражение, которое можно вычислить за один проход.
     * @param source - исходное выражение, разбитое на токены (список токенов)
     * @return - возвращает выражение в том виде, в котором оно должно быть представлено
     * по алгоритму сортировочной станции
     */
    public List<Token> convertToPostfix(List<Token> source){
        List<Token> postfixExpression = new ArrayList<>();
        Deque<Token> operationStack = new LinkedList<>();
        for(Token token : source)
        {
            switch (token.type()){
                case NUMBER -> postfixExpression.add(token);
                case OPEN_BRACKET -> operationStack.push(token);
                case CLOSE_BRACKET -> {
                    while (!operationStack.isEmpty() && operationStack.peek().type() != TokenType.OPEN_BRACKET){
                        postfixExpression.add(operationStack.pop());
                    }
                    operationStack.pop();
                }
                case BINARY_OPERATION -> {
                    while (!operationStack.isEmpty() && getPriority(operationStack.peek()) >= getPriority(token)){
                        postfixExpression.add(operationStack.pop());
                    }
                    operationStack.push(token);
                }
            }
        }
        while (!operationStack.isEmpty()){
            postfixExpression.add(operationStack.pop());
        }
        return postfixExpression;
    }

    /**
     * Метод для проверки приоритета операции.
     * @param token - токен, чей приоритет нужно получить
     * @return - возвращает для PLUS,MINUS тип опреации 1, для MULTIPLY,DIVIDE - 2,
     * для открывающей стобки - ноль.
     * Чем больше тип опреции, тем она приоритетнее.
     */
    private int getPriority(Token token){
        if (token instanceof BinaryOperationToken operationToken){
            return switch (operationToken.getOperationType()){
                case PLUS,MINUS -> 1;
                case MULTIPLY,DIVIDE -> 2;
            };
        }
        return 0;
    }
}
