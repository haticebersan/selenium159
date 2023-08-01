package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException {
        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //When user selects an image from the desktop
        //Set the path of the file
        String pathOfTheFile = System.getProperty("user.home") + "C:\\Users\\Laptop\\Desktop\\tree-selenium.jpg";

        //Since the input type is "File" we can use sendKeys() method to upload the file
        //Alternatively we can use Java Robot class
        //Locate the input web element
        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);





    }
}