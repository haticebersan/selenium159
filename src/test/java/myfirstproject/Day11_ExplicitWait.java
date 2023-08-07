package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day11_ExplicitWait extends TestBase {
   /*
    Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When user clicks on the Start button
    Then verify the 'Hello World!' Shows up on the screen
    */
   @Test
   public void explicitWaitTest(){

      driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
      WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
      startButton.click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
      WebElement helloWorld= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4"))));
      Assert.assertEquals("Hello World!",helloWorld.getText());

   }
}
