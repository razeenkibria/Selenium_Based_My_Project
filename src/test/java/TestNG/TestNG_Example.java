package TestNG;

import org.testng.annotations.*;

public class TestNG_Example {

    @AfterSuite
    public void AfterSuitExample(){
        System.out.println("After Suit");
    }

    @Test(priority = 1)
    public void example(){
        System.out.println("Example1 ");
    }

    @Test(priority = 0)
    public void example1(){
        System.out.println("Example2");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test ");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("After Class");
    }

    @BeforeSuite
    public void BeforeSuitExample(){
        System.out.println("Before Suit");
    }
}
