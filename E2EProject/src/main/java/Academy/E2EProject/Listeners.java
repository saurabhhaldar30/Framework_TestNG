package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {

	String tcName;
	public ExtentTest test;
	ExtentReports extReporter = ExtentReporter.getReporterObject();
	ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
		tcName = result.getMethod().getMethodName();
		test = extReporter.createTest(tcName);
		extTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			screenCapture(tcName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extTest.get().log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extTest.get().addScreenCaptureFromPath(screenCapture(tcName, driver), tcName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extTest.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extReporter.flush();
		System.out.println("All Tests Completed");
	}

}
