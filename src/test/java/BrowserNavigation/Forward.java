package BrowserNavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Forward {
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

        drive.navigate().to("https://banglayielts.com/");
        Thread.sleep(5000);

        drive.navigate().back();
        Thread.sleep(5000);

        drive.navigate().forward();
        Thread.sleep(5000);
    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
