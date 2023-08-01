package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Day08_AutoSuggestion extends TestBase {
    @Test
    public void autoSuggestion(){
        //given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        // When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        //And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[.='United Kingdom']")).click();
        //And click on submit button
        driver.findElement(By.cssSelector("input[type='button']")).click();
        //Then verify the result contains ‘United Kingdom’
        String resultText = driver.findElement(By.cssSelector("#result")).getText();
        assertTrue(resultText.contains("United Kingdom"));
    }
}
