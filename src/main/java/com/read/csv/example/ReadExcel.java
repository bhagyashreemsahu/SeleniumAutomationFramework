package com.read.csv.example;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {

		// Workbook
		// Sheet
		// Row
		// Cell

		XSSFWorkbook myWorkbook = new XSSFWorkbook(System.getProperty("user.dir") + "//testData//LoginExcel.xlsx");
		XSSFSheet mySheet = myWorkbook.getSheetAt(0);
		XSSFRow myRow = mySheet.getRow(4);
		XSSFCell myCell = myRow.getCell(0);
		System.out.println(myCell.getStringCellValue());

	}
}
