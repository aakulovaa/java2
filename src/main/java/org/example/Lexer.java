package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lexer {
    private final static String DELIMITERS = " +-*/()";
    Scanner scanner = new Scanner(System.in);

    /**
     * Метод разбиения строки на отдельные лексемы, используя определенный набор разделителей.
     * @param source - строка для обработки, состоящая из последовательности символов
     * @return - возвращает список токенов в порядке исходного выражения
     */
    public List<Token> getTokens(String source){
        StringTokenizer tokenizer = new StringTokenizer(source, DELIMITERS, true);
        List<Token> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.isBlank())
            {
                continue;
            }else if (isNumber(token)){
                tokens.add(new NumberToken(Integer.parseInt(token)));
                continue;
            }else if (isVariable(token)){
                System.out.println("Введите значение переменной " + token + ":");
                token = scanner.nextLine();
                tokens.add(new NumberToken(Integer.parseInt(token)));
                continue;
            }else {
                tokens.add(
                        switch (token) {
                            case "+" -> new BinaryOperationToken(OperationType.PLUS);
                            case "-" -> new BinaryOperationToken(OperationType.MINUS);
                            case "*" -> new BinaryOperationToken(OperationType.MULTIPLY);
                            case "/" -> new BinaryOperationToken(OperationType.DIVIDE);
                            case "(" -> new ParenthesesToken(TokenType.OPEN_BRACKET);
                            case ")" -> new ParenthesesToken(TokenType.CLOSE_BRACKET);
                            default -> throw new RuntimeException("Unexpected token: " + token);
                        }
                );
            }

        }
        return tokens;
    }

    /**
     * Метод для проверки тго, что токен является числом
     * @param token - строка, подаваемая для проверки
     * @return - возвращает false, если символ по текущему индуксу не является цифрой,
     * если полный проход по циклу не вернул false, значит все символы в токене являются цифрами,
     * тогда вернем true
     */
    private boolean isNumber(String token){
        for (int symbol=0;symbol<token.length();symbol++){
            if (!Character.isDigit(token.charAt(symbol))){
                return false;
            }
        }
        return true;
    }

    private boolean isVariable(String token){
        for (int symbol=0;symbol<token.length();symbol++){
            if (!Character.isLetter(token.charAt(symbol))){
                return false;
            }
        }
        return true;
    }
}
