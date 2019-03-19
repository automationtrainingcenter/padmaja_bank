package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {
	private WebDriver driver;
	
	//new role button
	@FindBy(how = How.ID, using="btnRoles")
	private WebElement newRole;
	
	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click new role button
	public RoleCreationPage clickNewRoleButton() {
		this.newRole.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}
	
	// verify is new role button is displayed
	public boolean isNewRoleButtonDisplayed() {
		return this.newRole.isDisplayed();
	}
	

}
