package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxBrowserTest {
    public static void main(String[] args) {
        //Set Path
        System.setProperty("webdriver.firefox.driver","drivers/geckodriver.exe");
        //Create gecko driver
        WebDriver driver = new FirefoxDriver();
        //After this step rest is same for all browsers
        //Open Amazon home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");//get() only uses inside string
        // Maximize the window
        driver.manage().window().maximize();
        //Close/Quit the browser
        driver.quit();
    }
}