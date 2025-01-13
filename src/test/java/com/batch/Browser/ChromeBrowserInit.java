package com.batch.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeBrowserInit {

    WebDriver drive;

     @BeforeSuite
    public  void StartChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        drive= new ChromeDriver();
        drive.manage().window().maximize();
    }
     @Test
    public void OpenURL() throws InterruptedException{
         drive.get("https://chatgpt.com/");
         Thread.sleep(7000);
    }

    @AfterSuite
    public void CloseChromeBrowser(){
           drive.close();
    }
}
