package Academy.E2EProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports ext;

	public static ExtentReports getReporterObject() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\"
				+ "Automation Report_" + System.currentTimeMillis() + ".html");
		ext = new ExtentReports();
		ext.attachReporter(reporter);
		return ext;
	}

}
