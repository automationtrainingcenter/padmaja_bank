package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class EmployeeDetailsPage {
	private WebDriver driver;
	
	//new employee details

	//new Employee button
	@FindBy(how = How.ID, using="BtnNew")
	private WebElement newEmployee;
	
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click new role button
	public EmployeeCreationPage clickNewEmployeeButton() {
		this.newEmployee.click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}
	

}


