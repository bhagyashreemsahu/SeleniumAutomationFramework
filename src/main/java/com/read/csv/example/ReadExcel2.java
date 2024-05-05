package com.read.csv.example;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	public static void main(String[] args) throws IOException {

		// Workbook
		// Sheet
		// Row
		// Cell

		XSSFWorkbook myWorkbook = new XSSFWorkbook(System.getProperty("user.dir") + "//testData//LoginExcel.xlsx");
		XSSFSheet mySheet = myWorkbook.getSheetAt(0);
		int lastIndexOfRow = mySheet.getLastRowNum();
		XSSFRow myHeader = mySheet.getRow(0);
		int totalNumberOfCols = myHeader.getLastCellNum();
		System.out.println("Last Index of Row is" + lastIndexOfRow);
		System.out.println("total Number of Cols is " + totalNumberOfCols);
	
		String myData[][] = new String[lastIndexOfRow+1][totalNumberOfCols];
			XSSFRow myRow;
			XSSFCell myCell;
		for(int rowIndex = 0; rowIndex<= lastIndexOfRow; rowIndex++) {
			for(int colIndex= 0; colIndex<totalNumberOfCols;colIndex++) {
				myRow = mySheet.getRow(rowIndex);
				myCell=myRow.getCell(colIndex);
				myData[rowIndex][colIndex] = myCell.getStringCellValue(); // You have read excel and stored it in a 2D
			}
			System.out.println("");
		}
	}
}
