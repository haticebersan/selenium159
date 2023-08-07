package myfirstproject;

import myfirstproject.utilities.LoggerUtils;
import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;;

public class Day12_StaleElementReferenceException extends TestBase {
    /*
      Given go to https://techproeducation.com/
      When hover over opportunities
      And click on career coaching
      And come back to homepage
      And hover over opportunities
     */

    @Test
    public void saleElementReferenceException() {
        LoggerUtils.info("Go to homepage");
//        Given go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");

//        When hover over opportunities
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        new Actions(driver).moveToElement(opportunities).perform();
        LoggerUtils.info("hover over opportunities");

//        And click on career coaching
        WebElement careerCoaching = driver.findElement(By.xpath("//a[.='Career Coaching']"));
        careerCoaching.click();
        LoggerUtils.info("click on career coaching");
        assertEquals("TechPro Education | Career Coaching", driver.getTitle());

//        And come back to homepage
        driver.navigate().back();//going back to home page. page elements are no longer fresh.
        LoggerUtils.error("come back to homepage");
        // to not have StaleElementReferenceException, we need to relocate the elements after navigate back, forward and refresh

//        And hover over opportunities
        opportunities = driver.findElement(By.linkText("Opportunities"));//opportunities web element reference was stale. because of that we relocate the element to refresh it.
        new Actions(driver).moveToElement(opportunities).perform();
        LoggerUtils.info("hover over opportunities");
        assertEquals("TechPro Education", driver.getTitle());





} }
