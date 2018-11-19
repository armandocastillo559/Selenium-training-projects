package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	String name, email, password;
	WebElement emailField, passwordField, submitButton;
	WebDriver driver;
	String browserType = "chrome";
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		submitButton.click();
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + name + message);
	}
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");		
		defineWebElements();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public void defineWebElements() {
		emailField = driver.findElement(By.name("ctl00$MainContent$txtUserName"));
		passwordField = driver.findElement(By.name("ctl00$MainContent$txtPassword"));
		submitButton = driver.findElement(By.name("ctl00$MainContent$btnLogin"));
	}
	@DataProvider
	public String[][] getData() {
		return utilities.Excel.get("C:\\Users\\EatLocal\\Google Drive\\Education\\JAVA\\files\\UserLogin.xls");
	}	
}