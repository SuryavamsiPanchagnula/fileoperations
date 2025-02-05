package task_13;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class excel_read {
	
public static void main(String args[]) throws IOException {
	
	XSSFWorkbook workbook = new XSSFWorkbook();
	
	XSSFSheet sheet = workbook.createSheet("sheet1");
	
	String[] headers = {"Name", "Age", "Email"};
    XSSFRow headerRow = sheet.createRow(0);
    XSSFCellStyle headerStyle = workbook.createCellStyle();
    XSSFFont headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerStyle.setFont(headerFont);
    for (int i = 0; i < headers.length; i++) {
        XSSFCell cell = headerRow.createCell(i);
        cell.setCellValue(headers[i]);
        cell.setCellStyle(headerStyle);
    }
    
    String[][] data = {
            {"John Doe", "30", "john@test.com"},
            {"Jane Doe", "28", "jane@test.com"},
            {"Bob Smith", "35", "bob@example.com"},
            {"Swapnil", "37", "swapnil@example.com"}
        };
    
    for (int i = 0; i < data.length; i++) {
        XSSFRow row = sheet.createRow(i + 1); // Skip header row
        for (int j = 0; j < data[i].length; j++) {
            XSSFCell cell = row.createCell(j);
            cell.setCellValue(data[i][j]);
        }
    }
	FileOutputStream fileOut;
    try {
        fileOut = new FileOutputStream("C:\\Users\\Dell\\Documents\\NewWorkbookWithData.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("New Excel workbook created with data inserted successfully.");
    } catch (IOException e) {
        System.out.println("Error occurred while creating the Excel workbook: " + e.getMessage());
        e.printStackTrace();
    }
    
    
	}

}
