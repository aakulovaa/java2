package org.example;

public class App
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        calculator.calculate("  2*5 -   36 / 6"); //4
        calculator.calculate("12 * 5 - 36 / 3"); //48
        calculator.calculate("  1 + 2*5 -   3+6 / 6");//9
    }
}
