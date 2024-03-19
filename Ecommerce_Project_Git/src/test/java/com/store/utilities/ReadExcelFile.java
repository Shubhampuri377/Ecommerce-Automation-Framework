package com.store.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile{
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo)
	{
		try
		{
			fis =new FileInputStream(fileName);
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			cell= workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "";
		}
	}
	
	public static int getRowCount (String fileName,String sheetName)
	{
		try {
			fis=new FileInputStream(fileName);
			//create XSSFworkbook object for excel manipulation
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			
			//get total no of rows
			int trows= excelsheet.getLastRowNum()+1;
			
			workbook.close();
			return trows;
		}
		catch(Exception e)
		{
			return 0;
		}
			
	}
	
	public static int getColCount (String fileName,String sheetName)
	{
		try {
			fis=new FileInputStream(fileName);
			//create XSSFworkbook object for excel manipulation
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			
			//get total no of rows
			int tcells= excelsheet.getRow(0).getLastCellNum();
			
			workbook.close();
			return tcells;
		}
		catch(Exception e)
		{
			return 0;
		}
			
	}
	
	
	

}
