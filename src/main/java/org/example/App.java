package org.example;
import java.util.Scanner;

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
