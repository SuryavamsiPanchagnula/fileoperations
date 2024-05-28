package task_13;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class write {

    public static void main(String args[]) throws IOException {
        FileInputStream fileInput = new FileInputStream("C:\\Users\\Dell\\Documents\\Book2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
        fileInput.close();

        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.createRow(6);

        XSSFCell A6 = row.createCell(0);
        XSSFCell B6 = row.createCell(1);
        XSSFCell C6 = row.createCell(2);

        A6.setCellValue("T5");
        B6.setCellValue("varma");
        C6.setCellValue(44);

        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Dell\\Documents\\Book2.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Data inserted successfully.");
    }
}