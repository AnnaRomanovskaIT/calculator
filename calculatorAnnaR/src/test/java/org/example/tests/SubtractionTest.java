package org.example.tests;

import org.calculator.Calculator;
import org.calculator.Subtraction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractionTest extends BaseClass {

    @Test(priority = 2, groups={"subtraction"}, dataProvider = "data-provider-for-subtraction")
    public void testSubtraction(double a, double b, Double expected) {
        double result = Calculator.calculate(new Subtraction(), a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name="data-provider-for-subtraction")
    public Object[][] subtractionDataProvider(){
    return new Object[][]{
            {5.0, 10.0, -5.0}, // Larger number subtracted from smaller
            {-5.0, -3.0, -2.0}, // Subtracting negative
            {0.0, 1.0, -1.0}, // Subtracting from zero
            {0.0, 0.0, 0.0}, // Zero case
            {3.5, 2.5, 1.0}, // Normal case
            {Double.MIN_VALUE, -Double.MIN_VALUE, Double.MIN_VALUE + Double.MIN_VALUE} // Edge case
    };
}
}
