package com.qa.iconautomatedpractice.Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        String excelFilePath = System.getProperty("user.dir") + "/src/test/java/com/qa/iconautomatedpractice/TestData/data_driven_test_data.xlsx";
        String sheetName = "Sheet1";  // Replace with your actual sheet name

        ExcelUtilities excelUtility = new ExcelUtilities(excelFilePath, sheetName);
        int rowCount = excelUtility.getRowCount();

        // Assuming that you have 2 columns in the Excel sheet
        Object[][] data = new Object[rowCount - 1][3];

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = excelUtility.getCellData(i, 0);  // Name
            data[i - 1][1] = excelUtility.getCellData(i, 1);  // Password
            data[i - 1][2] = excelUtility.getCellData(i, 2);  // Status (e.g., "successful" or "invalid credentials")
        }
        excelUtility.close();
        return data;
    }
}