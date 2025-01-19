package Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class implicite {

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
         drive.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    @AfterSuite
    public void CloseChromeBrowser(){
           drive.close();
    }
}
