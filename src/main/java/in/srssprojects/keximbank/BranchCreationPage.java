package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import  org.openqa.selenium.Alert;

public class BranchCreationPage {
	
	private WebDriver driver;
	
	// Branch name
		@FindBy(how = How.NAME, using = "txtbName")
		private WebElement branchName;
		
	// Branch Address1
		
		@FindBy(how = How.NAME, using = "txtAdd1")
		private WebElement branchAddress1;
		
	// Branch ZIP Code
		
		@FindBy(how = How.NAME, using = "txtZip")
		private WebElement branchZIP;
		
	//Branch Country
		@FindBy(how = How.NAME, using = "lst_counrtyU")
		private WebElement branchCountry;
	
	//Branch State
		@FindBy(how = How.NAME, using = "lst_stateI")
		private WebElement branchState;
		
	//Branch City
		@FindBy(how = How.NAME, using = "lst_cityI")
		private WebElement branchCity;
		
	//Branch submit
		@FindBy(how = How.ID, using = "btn_insert")
		private WebElement branchSubmit;
		
	//Branch Reset
		@FindBy(how = How.ID, using = "Btn_Reset")
		private WebElement branchReset;	
	
	//Branch Cancel
		@FindBy(how = How.ID, using = "Btn_cancel")
		private WebElement branchCancel;	
	
	//Constructor to initialize elements
	public BranchCreationPage(WebDriver driver)	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	//methods to performs actions
	
	// fill branch name
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}
	
	// fill branch Address1
	public void fillBranchAddress1(String branchAddress1) {
		this.branchAddress1.sendKeys(branchAddress1);
	}
	
	// fill branch ZIP
	public void fillBranchZIP(String branchZIP) {
		this.branchZIP.sendKeys(branchZIP);
	}

	// select branch Country
	public void selectBranchCountry(String branchCountry) {
		
			
		Select brCountry = new Select(this.branchCountry);
		brCountry.selectByVisibleText(branchCountry);
		
	}
	
	//select branch State
	
	public void selectBranchState(String branchState) {
		
		Select brState = new Select(this.branchState);
		brState.selectByVisibleText(branchState);
		
	}
	
	//Select branch city
	public void selectBranchCity(String branchCity) {
		
		Select brCity = new Select(this.branchCity);
		brCity.selectByVisibleText(branchCity);
	}
	
	//Click on Submit
	
	public Alert clickBranchSubmit() {
		
		this.branchSubmit.click();
		return driver.switchTo().alert();
		
	}
	
	// Click on Cancel
	
	public BranchDetailsPage clickBranchCancel() {
		
		this.branchCancel.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}
		
	//Click on Reset
	
	public void clickBranchReset() {
				this.branchReset.click();
	}
		
		

}
