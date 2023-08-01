package myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {

        //Set up the driver
        WebDriverManager.chromedriver().setup();
        //Create driver object
        WebDriver driver = new ChromeDriver();

//        Navigate to  techproeducation  homepage
        driver.get("https://techproeducation.com/");

//        Verify if page title is  “Techpro Education |  Online It Courses &  Bootcamps”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED!!");
            System.out.println("Actual Title : "+actualTitle);
            System.out.println("Expected Title : "+expectedTitle);
            System.out.println("Actual Title does not match");
        }


    }
}