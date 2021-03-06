package Academy.E2EProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;

public class HomePageTest extends BaseClass {
	
	WebDriver driver;
	
	@Test (dataProvider = "getData_Featured_Text")
	public void textValidationTest(String url, String featuredText) throws IOException {
		driver = initializeDriver();
		driver.get(p.getProperty("url"));
		HomePageObj hpobj = new HomePageObj(driver);
		Assert.assertEquals(hpobj.getfeaturedCourseTxt().getText(), featuredText);
	}
	
	@Test (dataProvider = "getData_HomePage_Links", groups = "Regression")
	public void linksValidationTest (String url, List<String> lst) throws IOException {
		driver = initializeDriver();
		driver.get(p.getProperty("url"));
		HomePageObj hpobj = new HomePageObj(driver);
		Assert.assertEquals(hpobj.gethomePageLinks(), lst);
	}

	@DataProvider
	public Object[][] getData_Featured_Text () {
		Object [][] data = new Object[1][2];
		data[0][0] = "https://www.qaclickacademy.com/";
		data[0][1] = "FEATURED COURSESS";
		return data;
	}
	
	@DataProvider
	public Object[][] getData_HomePage_Links () {
		List<String> links = Arrays.asList("HOME","COURSES","VIDEOS","INTERVIEW GUIDE","PRACTICE","BLOG","ABOUT","CONTACT");
		Object [][] data = new Object[1][2];
		data[0][0] = "https://www.qaclickacademy.com/";
		data[0][1] = links;
		return data;
	}
	
	@AfterMethod
	public void tearDownAfterTest() {
		driver.close();
	}
}
