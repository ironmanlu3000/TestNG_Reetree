package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider1 {
	
	public File f = new File("C:\\Users\\SANDESH\\Desktop\\AUTOMATION TESTING\\Selenium\\Project_Retree\\TestAutomationProject\\src\\test\\resources\\TestData\\TestData.xls");
	@DataProvider
	public Object[][] dataset_navigation() throws BiffException, IOException
	{	
    	//File f = new File("C:\\Users\\SANDESH\\Desktop\\AUTOMATION TESTING\\Selenium\\Project_Retree\\TestAutomationProject\\src\\test\\resources\\TestData\\TestData.xls");
    	FileInputStream fis = new FileInputStream(f);
    	Workbook wb = Workbook.getWorkbook(fis);
    	Sheet Sheet = wb.getSheet("Navigation");
    	int rows = Sheet.getRows();
    	int col = Sheet.getColumns();
    	int count=0;
		String[][] testdata = new String[rows-1][col] ;
		for(int i=1;i<rows;i++){
			for(int j=0;j<col;j++) {
				Cell cell = Sheet.getCell(j,i);
				testdata[count][j] = cell.getContents();
			}
			count++;
		}
		return testdata;
	}
	
	
	@DataProvider
	public Object[][] dataset_login() throws BiffException, IOException
	{	
    	FileInputStream fis = new FileInputStream(f);
    	Workbook wb = Workbook.getWorkbook(fis);
    	Sheet Sheet = wb.getSheet("Login");
    	int rows = Sheet.getRows();
    	int col = Sheet.getColumns();
    	int count=0;
		String[][] testdata = new String[rows-1][col] ;
		for(int i=1;i<rows;i++){
			for(int j=0;j<col;j++) {
				Cell cell = Sheet.getCell(j,i);
				testdata[count][j] = cell.getContents();
			}
			count++;
		}
		return testdata;
	}
}
   
