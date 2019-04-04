package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.BrowserHelper;
import utilities.ExcelHelper;
import utilities.TestNgListener;


@Listeners(TestNgListener.class)
public class TestExecution extends BrowserHelper {

	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeCreationPage employeeCreationPage;
	ExcelHelper excel = new ExcelHelper();
	
	Alert alert;

	@Test(priority = 1, enabled = true, groups = {"datadriven", "branch", "valid", "employee", "invalid", "role", "reset",
			"cancel" })
	public void loginTest() {
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isUrlCotainsExpectedText());

	}

	@Test(priority = 2, groups = { "role", "valid" })
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}

	@Test(priority = 3, dependsOnMethods = { "roleCreationWithValidData" }, groups = { "role", "invalid" })
	public void roleCreationWithDuplicateData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 4, groups = { "role", "blank" })
	public void roleCreationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}

	@Test(priority = 5, groups = { "role", "reset" })
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isRoleNameEmpty());
	}

	@Test(priority = 6, groups = { "role", "cancel" })
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleButtonDisplayed());
	}

	@Test(priority = 7, groups = { "branch", "valid" })
	public void branchCreationWithValidData() {

		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillAddress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectCountry("INDIA");
		branchCreationPage.selectState("Andhra Pradesh");
		branchCreationPage.selectCity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));

	}

	@Test(priority = 8, groups = { "branch", "invalid" })
	public void branchCreationDuplicateDate() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillAddress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectCountry("INDIA");
		branchCreationPage.selectState("Andhra Pradesh");
		branchCreationPage.selectCity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 9, groups = { "branch", "blank" })
	public void branchCreationBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}

	@Test(priority = 10, groups = { "branch", "reset" })
	public void branchCreationResetData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillAddress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectCountry("INDIA");
		branchCreationPage.selectState("Andhra Pradesh");
		branchCreationPage.selectCity("Hyderabad");
		branchCreationPage.clickReset();
		Assert.assertTrue(branchCreationPage.isBranchNameEmpty());

	}

	@Test(priority = 11, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchDetailsPage = branchCreationPage.clickCancel();
		Assert.assertTrue(branchDetailsPage.isNewBranchButtonDisplayed());

	}

	@Test(priority = 12, groups = { "employee", "valid" })
	public void employeeCreationWithValidData() {

		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeName("sunshine");
		employeeCreationPage.fillEmployeePassword("12345");
		employeeCreationPage.selectEmployeeRole("Manager");
		employeeCreationPage.selectEmployeeBranch("Hyderabad");
		alert = employeeCreationPage.clickOnSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}

	@Test(priority = 13, groups = { "employee", "invalid" })
	public void employeeCreationWithDuplicateData() {

		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeName("sunshine");
		employeeCreationPage.fillEmployeePassword("12345");
		employeeCreationPage.selectEmployeeRole("Manager");
		employeeCreationPage.selectEmployeeBranch("Hyderabad");
		alert = employeeCreationPage.clickOnSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 14, groups = { "employee", "blank" })
	public void employeeCreationBlankData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		alert = employeeCreationPage.clickOnSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following fields"));
	}

	@Test(priority = 15, groups = { "employee", "reset" })
	public void employeeCreationWithRestData() {

		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeName("sunshine");
		employeeCreationPage.fillEmployeePassword("12345");
		employeeCreationPage.selectEmployeeRole("manager");
		employeeCreationPage.selectEmployeeBranch("change");
		employeeCreationPage.clickOnReset();
		Assert.assertTrue(employeeCreationPage.isEmployeeNameEmpty());

	}

	@Test(priority = 16, groups = { "employee", "cancel" })
	public void employeeCreationCancel() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeDetailsPage = employeeCreationPage.clickOnCancel();
		Assert.assertTrue(employeeDetailsPage.isNewEmployeeButtonDisplayed());

	}

	@Test(priority = 19, groups = { "branch", "valid", "employee", "invalid", "role", "reset", "cancel" })
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		bankHomePage = adminHomePage.clickLogout();
		Assert.assertTrue(bankHomePage.isLoginButtonDisplayed());

	}

	@Test(priority = 20, groups = { "role", "datadriven1" })
	public void roleCreationWithMultipleData() {
		excel.setExcel(".", "testdata.xls", "roleData");
		int nor = excel.rowCount();
		int noc = excel.columnCount();
		for (int i = 1; i <= nor; i++) {
			String roleName = excel.readData(i, 0);
			String roleType = excel.readData(i, 2);
			roleDetailsPage = adminHomePage.clickRoles();
			roleCreationPage = roleDetailsPage.clickNewRoleButton();
			roleCreationPage.fillRoleName(roleName);
			roleCreationPage.selectRoleType(roleType);
			alert = roleCreationPage.clickSubmit();
			String alertText = alert.getText();
			System.out.println(alertText);
			alert.accept();
			Assert.assertTrue(alertText.contains("Created Sucessfully"));
		}
	}
	
	@Test(priority = 21, groups= {"employee", "datadriven"}, dataProvider = "empData", dataProviderClass = TestData.class)
	public void employeeCreationWithMultipleDataUsingDP(String empName, String password, String role, String branch) {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeName(empName);
		employeeCreationPage.fillEmployeePassword(password);
		employeeCreationPage.selectEmployeeRole(role);
		employeeCreationPage.selectEmployeeBranch(branch);
		alert = employeeCreationPage.clickOnSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Sucessfully"));
	}

	@AfterClass(groups = { "branch", "datadriven","valid", "employee", "invalid", "role", "reset", "cancel" })
	public void close() {
		closeBrowser();
	}

}
