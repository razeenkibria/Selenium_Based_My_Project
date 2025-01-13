package BrowserCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserCommandExample {
    WebDriver drive;
    String url="https://www.tutorialspoint.com/index.htm";

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }

    @Test

    public void getCurrentUrl() throws InterruptedException {
        drive.get(url);
        Thread.sleep(500);
        String currentURL= drive.getCurrentUrl();
        System.out.println(currentURL);
        if (url.equals(currentURL)){
            System.out.println("Same URL");
        }
        else {
            System.out.println("Not Same URL");
        }
    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.quit();
    }
}
