package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper extends GenericHelper {

	Workbook book;
	Sheet sheet;

	// set excel file to read the data
	public void setExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath(folderName, fileName));
			if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook();
			}
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// count number of rows with data
	public int rowCount() {
		return sheet.getLastRowNum();
	}

	// count number of columns with data
	public int columnCount() {
		return sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
	}

	// read data from a cell
	public String readData(int rnum, int cnum) {
		String data;
		Cell cell = sheet.getRow(rnum).getCell(cnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			data = cell.getStringCellValue();
			break;
		case NUMERIC:
			int i = (int) cell.getNumericCellValue();
			data = Integer.toString(i);
		default:
			data = "";
			break;
		}
		return data;
	}

	public static void main(String[] args) {
		ExcelHelper excel = new ExcelHelper();
		excel.setExcel(".", "testdata.xls", "roleData");
		int nor = excel.rowCount();
		int noc = excel.columnCount();

		System.out.println("rows = " + nor + "cells =" + noc);
		for (int i = 1; i <= nor; i++) {
			System.out.print(excel.readData(i, 0)+"\t");
			System.out.print(excel.readData(i, 1)+"\t");
			System.out.print(excel.readData(i, 2)+"\n");
		}
	}

}
