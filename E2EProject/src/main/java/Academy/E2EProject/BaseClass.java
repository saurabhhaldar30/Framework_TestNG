package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass extends DBConnector {

	public WebDriver driver;
	public Properties p;

	public WebDriver initializeDriver() throws IOException {

		// Get Project Working Directory
		String workingProjectDir = System.getProperty("user.dir");

		// Read Properties File
		p = new Properties();
		FileInputStream fis = new FileInputStream(workingProjectDir + "\\src\\main\\java\\resources\\data.properties");
		p.load(fis);

		// Get Browser Name from Properties File
//		String browserName = p.getProperty("browser");

		// Get Browser Name as parameter from Maven
		String browserName = System.getProperty("browser");

		// Load Browser Driver based on the value read from the Properties file
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					workingProjectDir + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}

		if (p.getProperty("browser").contains("firefox")) {

		}

		if (p.getProperty("browser").contains("IE")) {
			System.setProperty("webdriver.edge.driver",
					workingProjectDir + "\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		return driver;

	}

	public String screenCapture(String tcName, WebDriver driver) throws IOException {

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetPath = System.getProperty("user.dir") + "\\reports\\Screenshots\\" + tcName + BaseClass.timestamp()
				+ ".png";
		FileUtils.copyFile(scr, new File(targetPath));
		return targetPath;
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
