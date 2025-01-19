package Frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameLocateById {

    WebDriver drive;

     @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
     @Test
    public void OpenURL() throws InterruptedException{
         drive.get("https://www.hyrtutorials.com/p/frames-practice.html");
         Thread.sleep(7000);

         drive.switchTo().frame("frm2");
         WebElement element=drive.findElement(By.xpath("//input[@id='firstName']"));
         element.sendKeys("Md.Razeen Kibria");
         Thread.sleep(7000);
    }

    @AfterSuite
    public void CloseChromeBrowser(){
           drive.close();
    }
}
