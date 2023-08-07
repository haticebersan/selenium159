package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Day09_CaptureScreenshotElement extends TestBase {

    @Test
    public void captureScreenshotElement() throws IOException {
        //When user goes to the application home page (techproeducation)

        driver.get("https://techproeducation.com/");
        captureScreenShotEntirePage();//Taking screenshot of entire page

        //Then verify the logo of techpro education is displayed
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='TechPro Education'])[1]"));
        assertTrue(logo.isDisplayed());
        captureScreenshotElement(logo);//Taking screenshot of specific web element

    }

}
