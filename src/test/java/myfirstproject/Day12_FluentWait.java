package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day12_FluentWait extends TestBase {
    //Go to https://the-internet.herokuapp.com/dynamic_loading/1
   // When user clicks on the Start button
   //Then verify the ‘Hello World!’ Shows up on the screen
    @Test
    public void fluentWait(){
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //    When user clicks on the Start button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        //Then verify the ‘Hello World!’ Shows up on the screen
        //We will use fluent wait
        //To create fluent wait:
        //1. Create Wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)//creating FluentWait object
                .withTimeout(Duration.ofSeconds(15))//maximum timeout
                .pollingEvery(Duration.ofSeconds(2))// how often the driver checks the element
                .withMessage("Ignoring NoSuchMethodException")//custom message
                .ignoring(NoSuchMethodException.class);//ignoring NoSuchMethodException
        //2. Use the object for specific issue(visibility, clickability)
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        assertEquals("Hello World!", helloWorld.getText());

} }
