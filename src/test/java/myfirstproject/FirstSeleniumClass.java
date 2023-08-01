package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        //Introduce this class the path of driver and type of driver
        //System.setProperty("type of the driver","path of the driver");

        //1. set the path of the driver
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); --> for mac

        //2. create driver object
        WebDriver driver = new ChromeDriver();

        //3. go to application
        driver.get("https://techproeducation.com/");


    }
}
