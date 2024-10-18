package com.qa.iconautomatedpractice.Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilities {
    private final Workbook workbook;
    private final Sheet sheet;

    // Constructor to load the Excel file and sheet name
    public ExcelUtilities(String excelFilePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    // Method to get row count
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Method to get cell data as String
    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            // Convert numeric values to strings, remove .0 and scientific notation
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue().toString();  // If it's a date
            } else {
                // Convert numeric to plain string without scientific notation
                return String.valueOf((long) cell.getNumericCellValue());
            }
        } else {
            return "";  // Return an empty string for other types like BOOLEAN or FORMULA
        }
    }

    // Method to close workbook after reading
    public void close() throws IOException {
        workbook.close();
    }
}
