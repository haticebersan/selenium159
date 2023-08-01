package myfirstproject.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    //This class is used to run @Before and @After methods automatically in the child class
    protected static WebDriver driver;

    @Before//This will run before @Test methods
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After//This will run after @Test methods
    public void tearDown(){
        driver.quit();
    }
    public void captureScreenShotEntirePage() throws IOException {
        //1.step
        File image =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2.step
        String time = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
        String nanoTime = String.valueOf(System.nanoTime());
        String path =System.getProperty("user.dir")+"/test-output/Screenshots"+time+nanoTime+".png";


        //3.step
        FileUtils.copyFile(image, new File(path));
    } }
