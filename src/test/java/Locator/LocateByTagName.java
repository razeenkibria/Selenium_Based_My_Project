package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class LocateByTagName {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("https://www.tutorialspoint.com/selenium/practice/links.php");
        Thread.sleep(7000);

        List<WebElement> elements=drive.findElements(By.tagName("a"));
        System.out.println(elements.size());
        for (WebElement element:elements){
            System.out.println(element.getText());
        }

        Thread.sleep(7000);
    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.quit();
    }
}
