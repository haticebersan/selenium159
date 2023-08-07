package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Day08_FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException {
        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //When user selects an image from the desktop
        //Set the path of the file
        String pathOfTheFile = System.getProperty("user.home") + "\\Desktop\\tree-selenium.jpg";

        //Since the input type is "File" we can use sendKeys() method to upload the file
        //Alternatively we can use Java Robot class
        //Locate the input web element
        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        chooseFileInput.sendKeys(pathOfTheFile);
        Thread.sleep(2000);

        //And click on the upload button
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();

        // Then verify the File Uploaded! Message displayed
        String fileUploadedMessage = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("File Uploaded!", fileUploadedMessage);
    }
}