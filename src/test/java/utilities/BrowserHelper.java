package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserHelper extends GenericHelper {

	protected WebDriver driver;

	public void launchBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}
		driver.get(url);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//browser launch method which is used for Grid	
	public void launchBrowser(String browserName, String url, String nodeUrl) {
		DesiredCapabilities caps = new DesiredCapabilities();
		String os = "windows";
		if (os.contains("win")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (os.contains("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		if (os.contains("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}

		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get(url);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void closeBrowser() {
		driver.close();
	}

}
