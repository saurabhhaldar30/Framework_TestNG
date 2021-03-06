package Academy.E2EProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;

public class LoginPageTest extends BaseClass {
	
	WebDriver driver;
	
	@Test (dataProvider = "getData", groups = "Regression")
	public void validLoginTest (String userName, String pwd, String url) throws IOException {
		driver = initializeDriver();
		driver.get(p.getProperty("url"));
		HomePageObj hpobj = new HomePageObj(driver);
		hpobj.getloginLink().click();
		LoginPageObj lpobj = new LoginPageObj(driver);
		lpobj.getemailTxtBox().sendKeys(userName);
		lpobj.getpwdTxtBox().sendKeys(pwd);
		lpobj.getloginBtn().click();
	}
	
	@DataProvider
	public Object[][] getData () throws SQLException {
		ArrayList<String> empNames = dbConnectionTest();
		Object [][] data = new Object[2][3];
		data[0][0] = empNames.get(0);
		data[0][1] = "Password";
		data[0][2] = "https://www.qaclickacademy.com/";
		data[1][0] = empNames.get(1);
		data[1][1] = "Password";
		data[1][2] = "https://www.qaclickacademy.com/";
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
