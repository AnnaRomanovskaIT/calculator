package org.example.tests;

import org.calculator.Calculator;
import org.calculator.Multiplication;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest extends BaseClass {
    @Test(priority = 2, groups={"multiplication"}, dataProvider = "data-provider-for-multiplication")
    public void testMultiplication(double a, double b, Double expected) {
        double result = Calculator.calculate(new Multiplication(), a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name="data-provider-for-multiplication")
    public Object[][] multiplicationDataProvider(){
        return new Object[][]{
                {Double.MAX_VALUE, 2.0, Double.POSITIVE_INFINITY}, // Overflow case
                {0.0, 5.0, 0.0}, // Multiplying by zero
                {-3.0, 2.0, -6.0}, // Positive and negative
                {-3.2, -7.1, 22.72}, // Negative and negative
                {1.5, 2.0, 3.0} // Normal case
        };
    }
}
