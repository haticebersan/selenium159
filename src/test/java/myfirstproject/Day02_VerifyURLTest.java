package myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Navigate to TechProEducation homepage
        driver.get("https://techproeducation.com");

        //Verify if TechProEducation homepage url is “https://techproeducation.com/”
        String expectedUrl = "https://techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED!!");
            System.out.println("Actual Url : "+actualUrl);
            System.out.println("Expected Url : "+expectedUrl);
            System.out.println("Actual Url does not match");
        }

        /*
        Test case fails because:
        Actual Url: https://techproeducation.com/
        Expected Url: https://www.techproeducation.com/

        Since the test case fails, testers try to figure out if this is a real bug or a documentation issue.
        Maybe BA forgot to remove www statement in the expected url
        We should first check it with dev and then talk to BA if this is a real bug or not.
         */

    }
}