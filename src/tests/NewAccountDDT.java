package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, updatesEmail;
	WebElement nameField, emailField, phoneField, passwordField, passwordVerifyField, countryField, maleRadio, femaleRadio, weeklyCheckbox, monthlyCheckbox, updatesCheckbox, submitButton;
	WebDriver driver;
	String browserType = "chrome";
 
	@Test
	public void newAccountTest() {
		// 1. Print Record info into console
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + country + " " + gender + " " + password + " " + weeklyEmail + " " + monthlyEmail + " " + updatesEmail);
		// 2. Fill out the form
		nameField.sendKeys(name);		
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
		passwordField.sendKeys(password);
		passwordVerifyField.sendKeys(password);
		new Select(countryField).selectByVisibleText(country);
		// Radio Algorithm
		if (gender.equalsIgnoreCase("male")) { maleRadio.click(); }
		else { femaleRadio.click();	}
		// Checkbox Algorithm
		if (weeklyEmail) { if (!weeklyCheckbox.isSelected()) { weeklyCheckbox.click(); }}
		else { if (weeklyCheckbox.isSelected()) { weeklyCheckbox.click(); }}
		if (monthlyEmail) {	if (!monthlyCheckbox.isSelected()) { monthlyCheckbox.click(); }}
		else { if (monthlyCheckbox.isSelected()) { monthlyCheckbox.click(); }}
		if (updatesEmail) { if (!updatesCheckbox.isSelected()) { updatesCheckbox.click(); }}
		else { if (updatesCheckbox.isSelected()) { updatesCheckbox.click(); }}
		// Submit the form
		submitButton.click();
	}
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");		
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();  //works on chrome, firefox, edge, ie
		defineWebElements();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	public void defineWebElements() {
		nameField = driver.findElement(By.id("MainContent_txtFirstName"));
		emailField = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		phoneField = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordField = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		passwordVerifyField = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		countryField = driver.findElement(By.name("ctl00$MainContent$menuCountry"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		updatesCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
	
	// This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("C:\\Users\\EatLocal\\Google Drive\\Education\\JAVA\\files\\UserAccounts.csv");	
	}
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, 
			String weeklyEmail, String monthlyEmail, String updatesEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		this.weeklyEmail = Boolean.parseBoolean(weeklyEmail);
		this.monthlyEmail = Boolean.parseBoolean(monthlyEmail);
		this.updatesEmail = Boolean.parseBoolean(updatesEmail);	
	}
}
