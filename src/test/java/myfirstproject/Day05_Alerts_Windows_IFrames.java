package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Day05_Alerts_Windows_IFrames extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
    Then
        Assert that "Left List Item 29" is the last element in the "Left"
    And
        Assert that "Middle List Item 39" is the last element in the "Middle"
    When
        Navigate to https://testpages.herokuapp.com/styled/windows-test.html
    When
        Click on "Alerts In A New Window From JavaScript"
    And
        Switch to new window
    And
        Click on "Show alert box" button
    And
        Accept alert
    And
        Click on "Show confirm box" button
    And
        Cancel alert
    Then
        Assert that alert is canceled
    When
        Click on "Show prompt box" button
    And
        Send "techproeducation" to the alert
    Then
        Assert that "techproeducation" is sent
    */
    @Test
    public void alertsWindowsIFramesTest(){
        // Go to https://testpages.herokuapp.com/styled/frames/frames-test.html

        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");

        //        Assert that "Left List Item 29" is the last element in the "Left"
        /*
        "Left List Item 29" is inside an iFrame.
        We must move driver into this iFrame
        Otherwise driver can not find the element:
        To switch to iFrame-->
        1. index: driver.switchTo().frame(1)
        2. name: driver.switchTo().frame("left")
        3. id: driver.switchTo().frame("id")
        4. WebElement: driver.switchTo().frame( WebElement )
         */

        driver.switchTo().frame("left");//frame() method works with name, id or index
        List<WebElement> leftListItems = driver.findElements(By.xpath("//li"));
        for (WebElement w : leftListItems){
            System.out.println(w.getText());
        }

        assertEquals("'Last Element' does not match","Left List Item 29", leftListItems.get(leftListItems.size()-1).getText());

        //Assert that "Middle List Item 39" is the last element in the "Middle"
        System.out.println("=====================");
        //To switch "middle" iFrame we need to go back to parent frame. Because 'middle' iFrame does not exist inside the 'left' iFrame
        driver.switchTo().defaultContent();//first switch back to parentFrame or defaultContent
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='middle']")));

        List<WebElement> middleListItems = driver.findElements(By.xpath("//li"));
        for (WebElement w : middleListItems){
            System.out.println(w.getText());
        }
        assertEquals("'Last Element' does not match","Middle List Item 39", middleListItems.get(middleListItems.size()-1).getText());

    }
    @Test
    public void alertsWindowsIFramesTest2(){
        //        Navigate to https://testpages.herokuapp.com/styled/windows-test.html
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        //        Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.id("goalerts")).click();
        //        Switch to new window
        /*
        When we click on "Alerts In A New Window From JavaScript" link, a new tab opens:
        We need to switch to this tab(window)
            1. get window handles
                driver.getWindowHandle() --> returns the window handle of the current page as String
                driver.getWindowHandles() --> returns all the window handles as Set<String>
            2. driver.switchTo().window(windowHandle)
         */
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);//This is the window handle of the first page
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);

        for(String w : allWindowHandles){
            if(!w.equals(window1Handle)){
                System.out.println(w);
                driver.switchTo().window(w);
            }
        }

        //Click on "Show alert box" button
        driver.findElement(By.id("alertexamples")).click();

        //Accept alert
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        driver.switchTo().alert().accept();//If you do not handle the alert, you can not continue on the page
        //Click on "Show confirm box" button
        driver.findElement(By.id("confirmexample")).click();

        //Cancel alert
         driver.switchTo().alert().dismiss();
       //Assert that alert is canceled
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='confirmexplanation']")).isDisplayed());
      //Click on "Show prompt box" button
        driver.findElement(By.xpath("//input[@id='promptexample']")).click();
      // Send "techproeducation" to the alert
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();

    //  Assert that "techproeducation" is sent
        Assert.assertTrue(driver.findElement(By.cssSelector("#promptreturn")).getText().contains("Hello World!"));

    }
    }


