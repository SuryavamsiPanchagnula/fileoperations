package task_13;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read {
    
    public static void main(String args[]) throws IOException {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Dell\\Documents\\Book2.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            int columnIndex = 0;

            for (Row row : sheet) {
                XSSFCell cell = (XSSFCell) row.getCell(columnIndex);

                if (cell != null) {
                    String cellValue = cell.getStringCellValue();
                    System.out.println(cellValue);
                }
            }
            file.close();
        } catch (IOException | EncryptedDocumentException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}