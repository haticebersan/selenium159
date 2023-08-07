package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Day11_JSExecutor extends TestBase {
    @Test
    public void jsExecutorTest1() throws InterruptedException {
        //Given user is on the https://www.amazon.com/"
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement accountList =locateElementByJS("nav-link-accountList");
        actions.moveToElement(accountList).perform();
        Thread.sleep(3000);

        WebElement accountLink = driver.findElement(By.linkText("Account"));
        clickByJS(accountLink); // or we can use accountLink.click();
        Thread.sleep(3000);

        assertTrue(driver.getTitle().contains("Account"));
        WebElement amazonMusic = driver.findElement(By.xpath("//*[text()='Amazon Music']"));
        scrollIntoViewJS(amazonMusic); //or we can use actions.moveToElement(amazonMusic).perform();
        Thread.sleep(3000);

        clickByJS(amazonMusic); // or we can use amazonMusic.click();

        assertTrue(driver.getCurrentUrl().contains("music"));

        scrollAllDownJS();
        Thread.sleep(3000);
        scrollAllUpJS();
        Thread.sleep(3000);

        WebElement searchBox = locateElementByJS("navbarSearchInput");
        setValueByJS(searchBox,"Pop");

        Thread.sleep(3000);
        System.out.println(getValueByJS("navbarSearchInput"));
    }
}
