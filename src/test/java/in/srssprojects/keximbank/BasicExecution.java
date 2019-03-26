package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	
	@BeforeClass(groups = {"datadriven","branch", "valid", "employee", "invalid", "role", "reset", "cancel"})
	public void browserLaunch() {
		launchBrowser(readProperty("browser"), readProperty("url"));
		bankHomePage = new BankHomePage(driver);
	}

}
