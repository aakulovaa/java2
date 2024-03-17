package org.example;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class StackMachine {
    /**
     * Метод вычисления на стековой машине.
     * @param postfixExpression - выражение, записанное в обратной польской нотации
     * @return - возвращает результат вычисления заданного выражения
     */
    public int evaluate(List<Token> postfixExpression){
        Deque<Integer> valueStack = new LinkedList<>();
        for (Token token : postfixExpression) {
            if (token instanceof  NumberToken number) {
                valueStack.push(number.value);
            }else if (token instanceof BinaryOperationToken operationToken){
                Integer right = valueStack.pop();
                Integer left = valueStack.pop();
                Integer result = switch (operationToken.getOperationType()){
                    case PLUS -> left + right;
                    case MINUS -> left - right;
                    case MULTIPLY -> left * right;
                    case DIVIDE -> {
                        if (right.equals(0)){
                            throw new RuntimeException("Divide by zero");
                        }
                        else{
                            yield left/right;
                        }
                    }
                };
                valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
}
