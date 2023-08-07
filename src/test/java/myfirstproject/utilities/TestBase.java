package myfirstproject.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    //This class is used to run @Before and @After methods automatically in the child class

    //Create these 3 Extent Reports Objects
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp(){
        //These steps must be executed before each class so report generating happens

        // Type a dynamic name for report --> The report will be saved in Reports folder
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/Reports/extent-reprst" + now + ".html";
        //the html report will be saved in this path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //create extent reports object so the report template can be generated
        extentReports = new ExtentReports();

        // *** Optionally Add Custom System Information ***
        extentReports.setSystemInfo("Project Name","Techpro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Environment","Regression");
        extentReports.setSystemInfo("Team Name","TechPro");
        extentReports.setSystemInfo("SQA","John");

        // *** Optionally Add Document Information ***
        extentHtmlReporter.config().setDocumentTitle("My Extent Report");
        extentHtmlReporter.config().setReportName("My Regression Report");

        //Attach the extentHtmlReporter
        extentReports.attachReporter(extentHtmlReporter);

        //Create extentTest
        extentTest = extentReports.createTest("TechPro Education Regression Report","TechPro team report");

    }
    @AfterClass
    public static void tearDownReport(){
        //flush() method is required for generating the report
        extentReports.flush();
    }


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
        //The method to take screenshot entire page

            //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
            File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //2. Step: Type a dynamic name for screenshots images
            String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
            String path = System.getProperty("user.dir") + "/test-output/Screenshot" + now + ".png";

            //3. Step: Save the image in the path
            FileUtils.copyFile(image, new File(path));
    }
    //The method to take screenshot entire page
    public void captureScreenshotElement(WebElement webElement) throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        //This step is the only difference between captureScreenshotEntirePage and captureScreenshotElement methods
        File image = webElement.getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/ElementScreenshot/Screenshot" + now + ".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));
    }

    //This method to take screenshot of entire page and return the path of the screenshot as String. So we can add the path of the screenshot into the extent report
    public String captureScreenshotEntirePageAsString() throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/Screenshot" + now + ".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));

        //4. Step: return the path of the screenshot
        return path;


}
       //JS EXECUTOR METHODS
    /*
    click with JS
    param : WebElement
    action : clicks on the given element
     */
       public static void clickByJS(WebElement element){
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", element);
       }

    /*
    scroll into specific elements
    param : WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
     */
    public static void scrollAllDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static void scrollAllUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /*
     locating elements by javascript executor-normally we may not need this at all
    param : id of the element
    return WebElement
     */
    public WebElement locateElementByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementById('"+id+"')"));
    }
    /*
    getting the VALUE of elements-useful to get the values of input elements where getText() doesn't work
    param : id of the element
    locating the element and returning the value of the element
    return document.getElementById('"+id+"') -> RETURNS THE ELEMENT BY ID
    return document.getElementById('"+id+"').value -> RETURNS THE VALUE ATTRIBUTE OF THE ELEMENT
    toString() -> RETURN THE VALUE AS STRING
     */
    public static String getValueByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.getElementById('"+id+"').value").toString();
    }

    /*
   @param1 WebElement, @param2 String
   type the string in that input element
    */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }

    /*   HARD WAIT:
   @param : second
 */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    SELENIUM WAIT REUSABLE METHODS
     */
    //    DYNAMIC SELENIUM WAITS:
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static String getTextWithTimeout(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
        return null;
    }

    /*
    Custom method to wait to type in an input
     */
    public static void sendKeysWithTimeout(WebElement element,String text,int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }

    }


    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath ...
}

