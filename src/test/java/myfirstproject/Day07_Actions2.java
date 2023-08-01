package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions2 extends TestBase {

    @Test
    public void dragAndDropTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        /*
        elements are inside an iframe so switch first
         */
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElement);
        WebElement target = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(target,destination).perform();
    }
    @Test
    public void dragAndDropTest2(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
       //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        /*
        elements are inside an iframe so switch first
         */
       //driver.switchTo().frame(0);
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElement);
        WebElement target = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(target).moveToElement(destination).build().perform();
    }
}
