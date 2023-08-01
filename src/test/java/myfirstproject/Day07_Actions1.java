package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Day07_Actions1 extends TestBase {

    @Test
    public void actions1Test() throws InterruptedException {
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
       // When use click on “Account” link
      // 1. locate account & list element
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
     // 2. hover over (move over) to that element
         /*
        hover over is an Actions class functionality in selenium
        -create Actions object
        -use that object to perform mouse or keyboard events
        -make sure to use perform() to execute the action
         */
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        Thread.sleep(1000);
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        // accountLink.click(); //WORKS JUST FINE
        // BUT ALTERNATIVELY I CAN USE ACTIONS CLICK METHOD
        actions.click(accountLink).perform();
        //Then verify the page title contains “Your Account”
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
        //Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//td[@class='navFooterDescItem']//*[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).perform();
        Thread.sleep(3000);
        // And click on it
        //amazonMusic.click(); ALTERNATIVELY
        actions.click(amazonMusic).perform();
       //Then verify Amazon Music page is displayed
        Assert.assertTrue(driver.getCurrentUrl().contains("music"));
         /*
        We can scroll the pages up or down using PAGE_UP or ARROW_UP
        The difference between PAGE and ARROW is ARROW scroll less
         */
        //moving the page down actions
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(3000);
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(3000);
        actions
                .sendKeys(Keys.ARROW_DOWN)
                .perform();
        Thread.sleep(3000);
        actions
                .sendKeys(Keys.PAGE_UP)
                .perform();
        Thread.sleep(3000);
        actions
                .sendKeys(Keys.ARROW_UP)
                .perform();


    }
}
