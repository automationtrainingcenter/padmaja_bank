package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution{
	@BeforeClass(groups = {"datadriven", "branch", "valid", "employee", "invalid", "role", "reset", "cancel" })
	@Parameters({ "url", "brName" })
	public void browserLaunch(String u, String browser) {
//		launchBrowser(readProperty("browser"), readProperty("url"));
		launchBrowser(browser, u);
		bankHomePage = new BankHomePage(driver);
	}

}
