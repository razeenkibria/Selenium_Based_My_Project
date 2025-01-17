package Selector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SelectByVisible {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        Thread.sleep(7000);

        WebElement dropdown=drive.findElement(By.id("inputGroupSelect03"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Proof.");

        Thread.sleep(5000);


    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
