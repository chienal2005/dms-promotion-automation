package test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<int[]> getStepPackageData(String filePath, String sheetName) {
        List<int[]> dataList = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Không tìm thấy sheet: " + sheetName);
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int quantityCondition = (int) row.getCell(0).getNumericCellValue();
                int quantityAction = (int) row.getCell(1).getNumericCellValue();
                int slot = (int) row.getCell(2).getNumericCellValue();

                dataList.add(new int[]{quantityCondition, quantityAction, slot});
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi đọc file Excel: " + e.getMessage());
        }
        return dataList;
    }
}
