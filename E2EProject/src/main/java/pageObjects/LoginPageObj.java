package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObj {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='user_email']")
	private WebElement emailTxtBox;

	@FindBy(xpath = "//input[@id='user_password']")
	private WebElement pwdTxtBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;

	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getemailTxtBox () {
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtBox));
		return emailTxtBox;
	}
	
	public WebElement getpwdTxtBox () {
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(pwdTxtBox));
		return pwdTxtBox;
	}
	
	public WebElement getloginBtn () {
		return loginBtn;
	}

}
