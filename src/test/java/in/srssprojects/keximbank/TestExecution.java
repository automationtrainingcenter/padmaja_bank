package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {

	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeCreationPage employeeCreationPage;

	Alert alert;

	@Test(priority = 0)
	public void browserLaunch() {
		launchBrowser(readProperty("browser"), readProperty("url"));
		bankHomePage = new BankHomePage(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
	}

	@Test(priority = 2)
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 3)
	public void roleCreationWithDuplicateData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 4)
	public void roleCreationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		alert = roleCreationPage.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 5)
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickReset();
	}

	@Test(priority = 6)
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.clickCancel();
	}
		
	@Test(priority = 19)
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		adminHomePage.clickLogout();
	}

	@Test(priority = 20)
	public void close() {
		closeBrowser();
	}

}
