package com.myfirstproject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_AccountCreating {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void accountCreatingTest() throws InterruptedException {
        //        1. Launch browser - DONE IN setUp
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();
//        5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());
//        6. Enter name and email address


        //driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Walk");
        //driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testab154@gmail.com");

        //Using Fake Data
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        System.out.println(fullName);

        String emailAddress= faker.internet().emailAddress();


        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(fullName);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(emailAddress);




        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
//        7. Click 'Signup' button
        //N/A
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //N/A
//        9. Fill details: Title, Name, Email, Password, Date of birth
        //title
        driver.findElement(By.id("id_gender1")).click();
        //name,lastname,email, already filled
        //password

        String pass = faker.name()+faker.number().digits(3); // give me fake pass xxxx234

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        //date of birth
        //DAY
        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select daySelect = new Select(day);
        daySelect.selectByIndex(5); // using index select day 5
        //MONTH
        WebElement month = driver.findElement(By.cssSelector("select[data-qa='months']"));
        Select monthSelect = new Select(month);
        monthSelect.selectByValue("5"); // using value select month May
        //YEAR
        WebElement year = driver.findElement(By.xpath("//select[@data-qa='years']"));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("2000"); // using visible text - 2000

//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input#newsletter")).click();
//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("input#optin")).click();
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Walker");
        driver.findElement(By.id("company")).sendKeys("Amazon");
        driver.findElement(By.id("address1")).sendKeys("123 main st");
        WebElement country = driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");
        //state
        driver.findElement(By.id("state")).sendKeys("TX");
        //city
        driver.findElement(By.id("city")).sendKeys("Dallas");
        //zip
        driver.findElement(By.id("zipcode")).sendKeys("75001");
        //mobile
        driver.findElement(By.id("mobile_number")).sendKeys("+12141234567");

//        13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        //NOTE: A pop-up shows up and we must click close to continue
        // We must use try catch bcs the pup-up may not show up
        try {
            Thread.sleep(5000);
            driver.navigate().refresh();

//       14. Verify that 'ACCOUNT CREATED!' is visible
            Thread.sleep(5000);
            Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());

//        15. Click 'Continue' button
            driver.navigate().refresh();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        }catch (Exception e) {
            System.out.println("Pop up is not displayed ... just continue");
        }

        try {
            //15. Click 'Continue' button
            driver.navigate().refresh();
            //in the first click action continue button does not work it gives a pop-up, so we refresh
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
            driver.navigate().refresh();
        }catch (Exception e) {
            System.out.println("Pop up is not displayed ... just continue");
        }

//        16. Verify that 'Logged in as username' is visible
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains (text(),'Logged in as')]")).isDisplayed());
//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[contains (text(), 'Delete Account')]")).click();
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }
}