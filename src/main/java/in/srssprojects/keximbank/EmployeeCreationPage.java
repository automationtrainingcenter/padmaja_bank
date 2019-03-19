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

	// Employee name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement empName;
	
	// Employee login Password
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement empPassword;
	
	// Employee Role
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement empRole;
	
	
	// Employee branch
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement empBranch;

	// Employee Submit
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement empSubmit;
	
	// Employee Reset
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement empReset;
	
	// Employee Cancel
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement empCancel;
	
	//Constructor
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// methods to write on above properties
	
	// fill employee name
	public void fillEmployeeName(String empName) {
			this.empName.sendKeys(empName);
	}
	
	// fill employee password
	public void fillEmployeePassword(String empPassword) {
		this.empPassword.sendKeys(empPassword);
	}
	
	// select employee role
	public void selectEmployeeRole(String empRole) {
		Select role = new Select(this.empRole);
		role.selectByVisibleText(empRole);
	}
	
	// select employee Branch
	
	public void selectEmployeeBranch(String empBranch) {
		
		Select branch = new Select(this.empBranch);
		branch.selectByVisibleText(empBranch);
		
	}
	
	// click on submit button
	
	public Alert clickOnSubmit() {
		
		this.empSubmit.click();
		return driver.switchTo().alert();
		
	}
	
	// click on cancel button
	
	public void clickOnCancel() {
		
		this.empCancel.click();
	    
	}
	
	//click on Reset button
	public void clickOnReset() {
		this.empReset.click();
	}

}
