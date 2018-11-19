package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\EatLocal\\Google Drive\\Education\\resources\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// 2. Navigate to Account Management page >> Click on Create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		// 3. Fill out the form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Mary Smith");
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("ms@testemail.com");
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("3335553434");
		driver.findElement(By.cssSelector("input[id=\'MainContent_txtPassword\']")).sendKeys("mspass");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("mspass");
		
			// How to interact with other HTML elements
		driver.findElement(By.id("MainContent_Female")).click();
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByVisibleText("Canada");
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		//driver.findElement(By.id("MainContent_checkCheckUpdates")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
				
		// 4. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Confirmation: " + conf);
				
		// 5 Close the Browser
		driver.close();
	}

}
