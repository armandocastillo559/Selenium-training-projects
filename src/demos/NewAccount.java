package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		// 1. Define DATA, WEBDRIVER and ELEMENTS
		// Define DATA
		String name = "Mary Smith";
		String email = "ms@testemail.com";
		String password = "mspass";
		String phoneNumber = "3335553434";
		String country = "Canada";
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean updatesEmail = false;
		
		String browserType = "ie";
		
		// Define WEBDRIVER	and load testPage to activate WebElements	
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");		
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();  //works on chrome, firefox, edge, ie
		
		// Define WEB ELEMENTS
		WebElement nameField = driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailField = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordField = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement passwordVerifyField = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement countryField = driver.findElement(By.name("ctl00$MainContent$menuCountry"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement updatesCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// 2. Fill out the form
		nameField.sendKeys(name);		
		emailField.sendKeys(email);
		phoneField.sendKeys(phoneNumber);
		passwordField.sendKeys(password);
		passwordVerifyField.sendKeys(password);
		new Select(countryField).selectByVisibleText(country);
		
		// Radio Algorithm
		if (gender.equalsIgnoreCase("male")) { maleRadio.click(); }
		else { femaleRadio.click();	}
 
		// Checkbox Algorithm
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}

		if (monthlyEmail) {
			if (!monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		else {
			if (monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		if (updatesEmail) {
			if (!updatesCheckbox.isSelected()) {
				updatesCheckbox.click();
			}
		}
		else {
			if (updatesCheckbox.isSelected()) {
				updatesCheckbox.click();
			}
		}

		submitButton.click();
		
		// 3. Get confirmation and close browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) {
			System.out.println("CONFIRMATION: " + conf);
		}
		else {
			System.out.println("TEST FAILED: ");
		}
		//driver.close();
		
	}

}
