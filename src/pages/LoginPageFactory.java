package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	// Define web elements at Class level
	WebDriver driver;
	@FindBy(name="ctl00$MainContent$txtUserName")
	WebElement userNameBox;
	@FindBy(name="ctl00$MainContent$txtPassword")
	WebElement passwordBox;
	@FindBy(name="ctl00$MainContent$btnLogin")
	WebElement loginButton;
	
	// Steps
	public void  setUserName(String username) {
		userNameBox.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	public void clickSubmit() {
		loginButton.click();
	}
	// Actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}
	
	// Constructor initalizes the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		// Initialize Web Elements
		PageFactory.initElements(driver, this);
	}
}
