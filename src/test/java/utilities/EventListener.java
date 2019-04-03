package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import in.srssprojects.keximbank.TestExecution;

public class EventListener extends TestExecution implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("alert came " + driver.switchTo().alert().getText());
		test.log(LogStatus.INFO, "alert came " + driver.switchTo().alert().getText());
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("alert accepted");
		test.log(LogStatus.INFO, "alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("alert canceled");
		test.log(LogStatus.INFO, "alert canceled");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		Reporter.log("alert came " + driver.switchTo().alert().getText());
		test.log(LogStatus.INFO, "alert came " + driver.switchTo().alert().getText());
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
//		Reporter.log("navigating to " + url);
//		test.log(LogStatus.INFO, "navigating to " + url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
//		Reporter.log("navigated to " + url);
//		test.log(LogStatus.INFO, "navigated to " + url);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("locating an elemnt using " + by.toString());
//		test.log(LogStatus.INFO, "locating an elemnt using " + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("elemented located successfully with " + by.toString());
		test.log(LogStatus.INFO, "elemented located successfully with " + by.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicking on element");
		test.log(LogStatus.INFO, "clicking on element");
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicked on element");
		test.log(LogStatus.INFO, "clicked on element");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("clicked on element");
		test.log(LogStatus.INFO, "clicked on element");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("element value changed");
		test.log(LogStatus.INFO, "element value changed");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

	



}
