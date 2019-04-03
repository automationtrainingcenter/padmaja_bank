package utilities;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgListener extends BrowserHelper implements ISuiteListener, ITestListener {

	@Override
	public void onStart(ISuite suite) {
		report = new ExtentReports(
				new File(getFilePath("reports", suite.getName() + getDate() + ".html")).getAbsolutePath());
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		report.close();
	}

	@Override
	public void onTestStart(ITestResult result) {
		Object[] parameters = result.getParameters();
		if (parameters.length > 0) {
			test = report.startTest(result.getName()+Arrays.toString(parameters));
			test.log(LogStatus.INFO, Arrays.toString(parameters));
		}else {
			test = report.startTest(result.getName());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver = ((BrowserHelper) currentClass).getDriver();
		test.log(LogStatus.FAIL, driver.getTitle());
		test.log(LogStatus.INFO, test.addScreenCapture(getScreenshot("screenshots", result.getName(), driver)));
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report.endTest(test);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
