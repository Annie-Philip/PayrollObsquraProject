package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static      XSSFWorkbook excelWBook; 
    private static      XSSFSheet    excelWSheet;
    public static String getCellData(int RowNum, int ColNum) throws IOException {
    	FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"+ "/Testdata.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheetAt(0); 
        return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    }
    public static String getNumericData(int RowNum, int ColNum) throws IOException {
    	FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"+ "/Testdata.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheetAt(0); 
        String data=String.valueOf((int)excelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue());
        return data;
    }
}
