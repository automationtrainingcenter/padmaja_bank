package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {

	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;

	Alert alert;

	@BeforeClass
	public void browserLaunch() {
		launchBrowser(readProperty("browser"), readProperty("url"));
		bankHomePage = new BankHomePage(driver);
	}

	@Test(priority = 1, enabled = true)
	public void loginTest() {
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isUrlCotainsExpectedText());

	}

	@Test(priority = 2)
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

	@Test(priority = 3, dependsOnMethods= {"roleCreationWithValidData"})
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

	@Test(priority = 7)
	public void branchCreationValidData() {

		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillBranchAddress1("Addressbranch1");
		branchCreationPage.fillBranchZIP("56467");
		branchCreationPage.selectBranchCountry("INDIA");
		branchCreationPage.selectBranchState("Andhra Pradesh");
		branchCreationPage.selectBranchCity("Hyderabad");
		alert = branchCreationPage.clickBranchSubmit();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(priority = 8)
	public void branchCreationDuplicateDate() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillBranchAddress1("Addressbranch1");
		branchCreationPage.fillBranchZIP("56467");
		branchCreationPage.selectBranchCountry("INDIA");
		branchCreationPage.selectBranchState("Andhra Pradesh");
		branchCreationPage.selectBranchCity("Hyderabad");
		alert = branchCreationPage.clickBranchSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 9)
	public void branchCreationBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		alert = branchCreationPage.clickBranchSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 10)
	public void branchCreationResetData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchName("newBranchN");
		branchCreationPage.fillBranchAddress1("Addressbranch1");
		branchCreationPage.fillBranchZIP("56467");
		branchCreationPage.selectBranchCountry("INDIA");
		branchCreationPage.selectBranchState("Andhra Pradesh");
		branchCreationPage.selectBranchCity("Hyderabad");
		branchCreationPage.clickBranchReset();

	}

	@Test(priority = 11)
	public void breanchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.clickBranchCancel();
	}

	@Test(priority = 19)
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		adminHomePage.clickLogout();
	}

	@AfterClass
	public void close() {
		closeBrowser();
	}

}
