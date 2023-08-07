package myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_WriteExcel {

     /*
    Store the path of the file as string and open the file
    Open the workbook
    Open the first worksheet
    Go to the first row
    Create a cell on the 3rd column (2nd index) on the first row
    Write "POPULATION" on that cell
    Create a cell on the 2nd row 3rd cell(index2), and write 150000
    Create a cell on the 3rd row 3rd cell(index2), and write 250000
    Create a cell on the 4th row 3rd cell(index2), and write 54000
    Write and save the workbook
    Close the file
    Close the workbook
     */

    @Test
    public void writeExcel() throws  IOException {

        String path = "resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workbook.getSheet("Sheet1");

        Row row1 = sheet1.getRow(0);

        Cell row1Cell3 = row1.createCell(2);
        row1Cell3.setCellValue("POPULATION");

        sheet1.getRow(1).createCell(2).setCellValue("150000");

        sheet1.getRow(2).createCell(2).setCellValue("250000");

        sheet1.getRow(3).createCell(2).setCellValue("54000");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }
}
