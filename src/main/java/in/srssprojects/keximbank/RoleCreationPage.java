package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	private WebDriver driver;

	// role name
	@FindBy(how = How.ID, using = "txtRname")
	private WebElement roleName;

	// role type
	@FindBy(how = How.ID, using = "lstRtypeN")
	private WebElement roleType;

	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill role name
	public void fillRoleName(String roleName) {
		this.roleName.sendKeys(roleName);
	}

	// select role type
	public void selectRoleType(String roleType) {
		new Select(this.roleType).selectByVisibleText(roleType);
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
	public RoleDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
	
	//verify  role name data is cleared or not
	public boolean isRoleNameEmpty() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return arguments[0].value", this.roleName).toString().isEmpty();
	}

}
