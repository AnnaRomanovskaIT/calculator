package org.example.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    @BeforeClass
    public void startOfTestingClass(){
        System.out.println("Start of class execution");
    }

    @AfterClass
    public void endOfTestingClass(){
        System.out.println("End of class execution");
    }

    // Addition
    @BeforeTest
    public void beforeMethodTests(){
        System.out.println("Start of method tests");
    }

    @AfterTest
    public void afterMethodTests(){
        System.out.println("End of method tests");
    }
}
