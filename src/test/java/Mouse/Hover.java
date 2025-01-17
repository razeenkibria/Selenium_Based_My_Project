package Mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;

public class Hover {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(7000);

        WebElement element=drive.findElement(By.xpath("//a[@title='Women']"));
        Actions action=new Actions(drive);
        action.moveToElement(element).perform();
        Thread.sleep(7000);

        WebElement dress=drive.findElement(By.xpath("//li[@class='sfHover']//a[@title='Dresses'][normalize-space()='Dresses']"));
        dress.click();
        Thread.sleep(7000);


    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
