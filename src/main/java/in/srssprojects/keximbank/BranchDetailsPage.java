package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BranchDetailsPage {

	private WebDriver driver;

	@FindBy(how = How.ID, using = "BtnNewBR")
	private WebElement newBranch;

	public BranchDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click new role button
	public BranchCreationPage clickNewBranchButton() {
		this.newBranch.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}

	// is new branch button displayed
	public boolean isNewBranchButtonDisplayed() {
		return this.newBranch.isDisplayed();
	}

}
