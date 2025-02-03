package utils;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExcelReader {

    public static List<Object[]> getTestData(String excelPath, String sheetName) throws IOException {
        List<Object[]> testData = new LinkedList<>();
        FileInputStream fis = new FileInputStream(new File(excelPath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rows = sheet.iterator();
        // Skip header row
        rows.next();
        while (rows.hasNext()) {
            Row row = rows.next();
            Object[] rowData = new Object[row.getPhysicalNumberOfCells()];
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                rowData[i] = row.getCell(i).toString();
            }
            testData.add(rowData);
        }
        workbook.close();
        return testData;
    }
}
