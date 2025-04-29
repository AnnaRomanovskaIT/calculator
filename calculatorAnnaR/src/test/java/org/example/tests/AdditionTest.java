package org.example.tests;
import org.calculator.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdditionTest extends BaseClass {
    @Parameters({"name"})
    @Test(priority = 1, groups={"addition"})
    public void testAddition(String name) {
        System.out.println(name);
    }

    @Test(priority = 2, groups={"addition"}, dataProvider = "data-provider-for-addition")
    public void testAddition(double a, double b, Double expected) {
        double result = Calculator.calculate(new Addition(), a, b);
        Assert.assertEquals(result, expected);
    }


    // Data Providers
    @DataProvider(name="data-provider-for-addition")
    public Object[][] additionDataProvider(){
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY}, // Overflow case
                {1.0, -1.0, 0.0}, // Positive and negative
                {0.0, 5.0, 5.0}, // Adding zero
                {0.0, 0.0, 0.0}, // Zero case
                {-5.0, -3.0, -8.0}, // Adding two negative numbers
                {3.5, 2.5, 6.0} // Normal case
        };
    }
}
