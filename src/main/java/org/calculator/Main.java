package org.calculator;

public class Main {

    public static void main(String[] args) {
        System.out.println(Calculator.calculate(new Addition(), 5, 3));
        System.out.println(Calculator.calculate(new Subtraction(), 5, 3));
        System.out.println(Calculator.calculate(new Multiplication(), 5, 3));
        System.out.println(Calculator.calculate(new Division(), 5, 0));
    }
}