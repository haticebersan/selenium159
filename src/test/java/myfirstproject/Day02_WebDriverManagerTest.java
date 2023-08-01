package myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_WebDriverManagerTest {

    //    Create a test case that will navigate to amazon page
    public static void main(String[] args) {
        //    Use WebDriverManager class to set up chrome driver
        //So far we used local drivers
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.close();

//   ---WebDriverManager---
         /*
        WebDriverManager: This is an API that is used to set up the drivers
        From now on, we will use WebDriverManager to set up the drivers instead of System.setProperty() method.
         */

        //Testing on chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.quit();

        //Testing on firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.amazon.com");
        driver2.quit();

        //Testing on edge
        WebDriverManager.edgedriver().setup();
        WebDriver driver3 = new EdgeDriver();
        driver3.get("https://www.amazon.com");
        driver3.quit();

        //You can also use create() method to create driver object
        WebDriver driver5 = WebDriverManager.edgedriver().create();
        driver5.get("https://www.techproeducation.com");
    }
}