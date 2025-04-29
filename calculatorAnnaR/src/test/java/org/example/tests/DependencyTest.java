package org.example.tests;
import org.calculator.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest extends BaseClass {
    private double result;

    @Test
    public void alwaysFails(){
        Assert.fail();
    }

    @Test(dependsOnMethods={"alwaysFails"}, alwaysRun = true)
    public void testAddition() {
        result = Calculator.calculate(new Addition(), 5, 3);
        Assert.assertEquals(result, 8.0);
    }

    @Test(dependsOnMethods = {"testAddition"})
    public void testSubtraction() {
        result = Calculator.calculate(new Subtraction(), result, 2);
        Assert.assertEquals(result, 6.0);
    }

    @Test(dependsOnMethods = {"testSubtraction"})
    public void testMultiplication() {
        result = Calculator.calculate(new Multiplication(), result, 3);
        Assert.assertEquals(result, 18.0);
    }

    @Test(dependsOnMethods = {"testMultiplication"})
    public void testDivision() {
        result = Calculator.calculate(new Division(), result, 2);
        Assert.assertEquals(result, 9.0);
    }
}
