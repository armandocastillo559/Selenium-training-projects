package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;

	
	public void changePassword() {
		driver.findElement(By.linkText("Change password")).click();
	}
	
	public void updateSubscription() {
		driver.findElement(By.linkText("Updated subscriptions")).click();
	}
	
	public void cancelAccount() {
		driver.findElement(By.linkText("Cancel account")).click();
	}
	
	public String getConfirmation() {
		return driver.findElement(By.id("conf_message")).getText();
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
}
