package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {

    //Create a new class under : BasicNavigations
    //Create main method
    public static void main(String[] args) {
        //Set Path
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //Create chrome driver
        WebDriver driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");
        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //Navigate back to google
        driver.navigate().back();//back method here takes driver previous page
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //Close/Quit the browser
        driver.close();
        //driver.quit();> quit = close all pages
        //close = close just the current one
        /*
      What is the difference between get() and navigate().to() methods?
      -Similarities: Both is used for go to URL
      -get() is shorter and easier.
      -get() accepts only URL as String
      -navigate().to() accepts URL as String and URL object
      -navigate() method has more functions such as to(), back(), forward(), refresh()

      What is the difference between close() and quit() methods?
      -close() method closes the last window used by driver
      -quit() method closes all windows used by current driver.
      Prefer quit, because it closes all windows and it is stronger.
       */

    }
}
