package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObj {

	WebDriver driver;

	@FindBy(xpath = "//*[@class='pull-right'] //span[text() = 'Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@class='pull-right'] //span[text() = 'Register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//div[@class='text-center']/h2")
	private WebElement featuredCourseTxt;
	
	@FindBy(xpath = "//*[@class='nav navbar-nav navbar-right'] //a")
	private List<WebElement> homePageLinks;

	public HomePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getloginLink() {
		return loginLink;
	}

	public WebElement getregisterLink() {
		return registerLink;
	}
	
	public WebElement getfeaturedCourseTxt() {
		return featuredCourseTxt;
	}
	
	public ArrayList<String> gethomePageLinks() {
		ArrayList <String> hpLinks = new ArrayList <String>();
		for (WebElement link : homePageLinks) {
			hpLinks.add(link.getText());
		}
		return hpLinks;
	}

}
