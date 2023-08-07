package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day10_WebTables  extends TestBase {
   /*
    https://the-internet.herokuapp.com/tables
    Task 1 : Print the entire table
    Task 2 : Print All Rows
    Task 3 : Print Last row data only
    Task 4 : Print column 5 data in the table body

    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
    Parameter 1 = row number
    Parameter 2 = column number
    printData(2,3);  => prints data in 2nd row 3rd column
     */
   @Test
   public void printTable(){
      //TASK 1
      driver.get("https://the-internet.herokuapp.com/tables");
      String table = driver.findElement(By.xpath("//table[@id='table1']")).getText();
      System.out.println(table);
      System.out.println(" ");
      List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
      for (WebElement w : tableElements){
         System.out.println(w.getText());
      }
   }
   @Test
   public void printRows(){
      //TASK 2
      driver.get("https://the-internet.herokuapp.com/tables");
      List < WebElement> rowElements = driver.findElements(By.xpath("//table[@id='table1']//tr"));
      for (WebElement w : rowElements){
         System.out.println(w.getText());
      }
      //TASK 3
      System.out.println(rowElements.get(rowElements.size()-1).getText());
   }
   @Test
   public void printColumns(){
      //TASK 4
      driver.get("https://the-internet.herokuapp.com/tables");
      List<WebElement> column5Data=driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
      for (WebElement w : column5Data){
         System.out.println(w.getText());
      }
   }
}
