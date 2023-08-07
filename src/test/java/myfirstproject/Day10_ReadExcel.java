package myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day10_ReadExcel {
     /*
    Create a new test method : readExcel()
    Store the path of the  file in a string
    Open the file
    Open the workbook using file input stream
    Open the first worksheet
    Go to first row
    Go to first cell on that first row and print
    Go to second cell on that first row and print
    Go to 2nd row first cell  and assert if the data equal to the USA
    Go to 3rd row 2nd cell-chain the row and cell
    Find the number of row
    Find the number of used row
     */
     @Test
     public void readExcel() throws IOException {
          String path = "resources/Capitals.xlsx";
          FileInputStream fileInputStream = new FileInputStream(path);
          Workbook workbook = WorkbookFactory.create(fileInputStream);
          Sheet sheet1 = workbook.getSheet("Sheet1");
          Row row1 = sheet1.getRow(0);
          Cell cell1 = row1.getCell(0);
          System.out.println("ROW1CELL1 = " + cell1);
          String cell1String = cell1.toString();
          System.out.println("ROW1CELL1 as STRING = " + cell1String);

          String cell2 = sheet1.getRow(0).getCell(1).toString();
          System.out.println("ROW1CELL2 as STRING = " + cell2);

          String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
          System.out.println("ROW2CELL1 as STRING = " + row2Cell1);
          assertEquals("USA", row2Cell1);

          String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
          System.out.println("ROW3CELL2 as STRING = " + row3Cell2);

          int numberOfRow = sheet1.getLastRowNum() + 1;
          System.out.println("TOTAL ROW NUMBER = " + numberOfRow);

          int usedRows = sheet1.getPhysicalNumberOfRows();
          System.out.println("USED ROWS = " + usedRows);
     }
}
