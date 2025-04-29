package org.example.tests;

import org.calculator.Calculator;
import org.calculator.Division;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest extends BaseClass {
    @Test(priority = 2, groups={"division"}, dataProvider = "data-provider-for-division")
    public void testDivision(double a, double b, Double expected) {
        double result = Calculator.calculate(new Division(), a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name="data-provider-for-division")
    public Object[][] divisionDataProvider(){
        return new Object[][]{
                {10.0, 0.0, Double.NaN}, // Division by zero
                {0.0, 0.0, Double.NaN}, // Zero case
                {-10.0, 2.0, -5.0}, // Negative divided by positive
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE}, // Normal case
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY}, // Large result
                {0.0, 1.0, 0.0} // Dividing zero
        };
    }
}
