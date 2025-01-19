package Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Explicite {

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
         WebDriverWait wait= new WebDriverWait(drive, Duration.ofSeconds(40));
         WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(te(),'provides personalized online tutoring for all aspe')]")));
         System.out.println(element.getText());
    }

    @AfterSuite
    public void CloseChromeBrowser(){
           drive.close();
    }
}
