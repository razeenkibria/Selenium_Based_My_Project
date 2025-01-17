package Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(7000);

        String expectedTitle="Selenium Practice - Student Registration ";
        String actualTitle=drive.getTitle();

        SoftAssert assertion=new SoftAssert();
        assertion.assertEquals(expectedTitle,actualTitle);


        WebElement element=drive.findElement(By.xpath("//input[@id='name']"));
        element.sendKeys("Razeen");

        assertion.assertAll();

    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
