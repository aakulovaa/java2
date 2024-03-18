package org.example;
import java.util.Scanner;

/**
 * <a href="https://github.com/aakulovaa/calculator">...</a>
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Введите выражение:");
        String expression = scanner.nextLine();
        calculator.calculate(expression);
    }
}
