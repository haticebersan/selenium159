package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Day09_ExtentReports extends TestBase {
     @Test
    public void extentReportsTest(){

         extentTest.info("info log");
         extentTest.pass("pass log");
         extentTest.fail("fail log");
         extentTest.skip("skip log");
         extentTest.warning("warning log");

         String title = "TechPro";

         if (title.equals("TechPro")) {
             extentTest.pass("PASS! Title is correct");
         } else {
             extentTest.fail("FAIL! Title is NOT correct");
         }
     }

     @Test
    public void extentReportsTest2() throws InterruptedException, IOException {

         extentTest
                 .info("Navigating to the application homepage")
                 .addScreenCaptureFromPath(captureScreenshotEntirePageAsString())
                 .assignAuthor("Ali", "Ayşe", "John", "Mary", "Harry", "Terry")
                 .assignCategory("Smoke", "Regression")
                 .assignDevice("Adroid", "Windows", "MAC");

         //given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
         driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
         Thread.sleep(2000);
         extentTest.pass(" User is on the application homepage")
                 .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


         // When user type “uni” in the search box
         driver.findElement(By.id("myCountry")).sendKeys("uni");
         Thread.sleep(2000);
         extentTest
                 .pass("Typing “uni” in the search box")
                 .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


         //And select the ‘United Kingdom’ from the suggestions
         driver.findElement(By.xpath("//div[.='United Kingdom']")).click();
         Thread.sleep(2000);
         extentTest
                 .pass("Selecting the ‘United Kingdom’ from the suggestions")
                 .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


         //And click on submit button
         driver.findElement(By.cssSelector("input[type='button']")).click();
         Thread.sleep(2000);
         extentTest
                 .pass("Clicking on submit button")
                 .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


         //Then verify the result contains ‘United Kingdom’
         String resultText = driver.findElement(By.cssSelector("#result")).getText();
         assertTrue(resultText.contains("United Kingdom"));
         extentTest.pass("Verifying the result contains ‘United Kingdom’");


     }
}
