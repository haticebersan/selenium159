package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void downloadTest() throws InterruptedException {
        //Go to  https://testcenter.techproeducation.com/index.php?page=filedownload
        //C:\Users\Laptop\Downloads
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //Download b10 all test cases, code.docx file
        driver.findElement(By.partialLinkText("b10 all")).click();
        Thread.sleep(1000);//Wait 1 sec to save the file to local
        //Then verify if the file downloaded successfully
        String pathOfTheFile = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean isFileExist = Files.exists(Path.of(pathOfTheFile));
        assertTrue(isFileExist);

    }
}
