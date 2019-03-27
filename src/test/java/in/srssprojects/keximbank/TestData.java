package in.srssprojects.keximbank;

import org.testng.annotations.DataProvider;

import utilities.ExcelHelper;

public class TestData {
	
	ExcelHelper excel;

	@DataProvider(name = "empData")
	public Object[][] getEmployeeData() {
		excel = new ExcelHelper();
		return excel.getSheetData(".", "testdata.xls", "employeeData");
	}

}
