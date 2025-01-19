package Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Prompt {

    WebDriver drive;

     @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
     @Test
    public void OpenURL() throws InterruptedException{
         drive.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
         Thread.sleep(7000);
    }

    @Test
    public void acceptAlert() throws InterruptedException {
       WebElement alert_element = drive.findElement(By.xpath("//button[@onclick='myPromp()']"));
        alert_element.click();
        Thread.sleep(5000);

        Alert alert = drive.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Razeen");
        Thread.sleep(5000);
        alert.accept();
        Thread.sleep(5000);

    }

    @AfterSuite
    public void CloseChromeBrowser(){
           drive.close();
    }
}
