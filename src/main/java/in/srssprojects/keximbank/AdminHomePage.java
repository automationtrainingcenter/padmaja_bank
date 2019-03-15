package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	WebDriver driver;

	// home button
	@FindBy(xpath = "//a[@href='adminflow.aspx']")
	private WebElement home;

	// logout button
	@FindBy(how = How.XPATH, using = "//a[@href='home.aspx']")
	private WebElement logout;

	// branches button
	@FindBy(how = How.XPATH, using = "//a[@href='admin_banker_master.aspx']")
	private WebElement branches;

	// roles button
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Roles_details.aspx']")
	private WebElement roles;

	// employee button
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Emp_details.aspx']")
	private WebElement employee;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		/*
		 * initElemnets method locate all the elements inside this page using driver
		 * object and stores located element in specified variable name
		 */
		PageFactory.initElements(driver, this);
	}

	// click on home button
	public void clickHome() {
		this.home.click();
	}

	// click on logout button
	public void clickLogout() {
		this.logout.click();
	}

	// click on branches button
	public RoleDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click on roles button
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click on employee button
	public EmployeeDetailsPage clickEmployee() {
		this.employee.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}

	
}
