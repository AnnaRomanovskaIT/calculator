package org.calculator;

public class Division extends Operation {
    @Override
    public double execute(double a, double b) {
        if(b==0) return Double.NaN;
        return a / b;
    }
}
