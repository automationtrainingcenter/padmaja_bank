package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	private WebDriver driver;

	// employer name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement empName;
	// login password
		@FindBy(how = How.ID, using = "txtLpwd")
		private WebElement loginPassword;

	// roleName
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement roleName;
	// branchName
		@FindBy(how = How.ID, using = "lst_Branch")
		private WebElement branchName;


	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill emp name
	public void fillEmpName(String empName) {
		this.empName.sendKeys(empName);
	}
	// fill login password
		public void fillLoginPassword(String loginPassword) {
			this.loginPassword.sendKeys(loginPassword);
		}

	// select role name
	public void selectRoleName(String roleName) {
		new Select(this.roleName).selectByVisibleText(roleName);
	}
	// select branch name
		public void selectBranchName(String branchName) {
			new Select(this.branchName).selectByVisibleText(branchName);
		}


	// click submit
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}

	// click reset
	public void clickReset() {
		this.reset.click();
	}

	// click cancel
	public void clickCancel() {
		this.cancel.click();
	}

}


