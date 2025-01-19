package Scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollLocator {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("https://banglayielts.com/");
        Thread.sleep(7000);

        JavascriptExecutor js = (JavascriptExecutor) drive;

        WebElement element=drive.findElement(By.xpath("//a[contains(@href,'https://banglayielts.com/admission')]"));
        js.executeScript("arguments[0].scrollIntoView();",element);
        Thread.sleep(5000);
    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
