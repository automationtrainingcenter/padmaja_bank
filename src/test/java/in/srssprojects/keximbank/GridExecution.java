package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	@BeforeClass(groups = { "branch", "valid", "employee", "invalid", "role", "reset", "cancel" })
	@Parameters({ "url", "brName", "nodeURl" })
	public void browserLaunch(String u, String browser, String nodeURL) {
//		launchBrowser(readProperty("browser"), readProperty("url"));
		launchBrowser(browser, u, nodeURL);
		bankHomePage = new BankHomePage(driver);
	}

}
