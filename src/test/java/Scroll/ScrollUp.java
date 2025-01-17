package Scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollUp {
    WebDriver drive;

    @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException{
        drive.get("http://www.automationpractice.pl/index.php?id_category=3&controller=category");
        Thread.sleep(7000);

        JavascriptExecutor js = (JavascriptExecutor) drive;

        //This is Used for Down :

        String script = "window.scrollTo(0,document.body.scrollHeight)";
        js.executeScript(script);
        Thread.sleep(7000);

         //This is Used For up :

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(5000);

    }

    @AfterSuite
    public void CloseChromeBrowser(){
        drive.close();
    }
}
