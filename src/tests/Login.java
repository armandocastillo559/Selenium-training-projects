package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM() {
		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		
		// 2. Enter login information (login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("ep@testemail.com");
		loginPage.setPassword("ep1password");
		loginPage.clickSubmit(); 
		
		// 3. Get Confirmation (dashboard page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.getConfirmation();
		String title = dashboardPage.title();
		
		// 4. Assertions
		
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(title.contains("Account"));
		  
		// 5. Close the driver
		driver.quit();
		
	}
}
