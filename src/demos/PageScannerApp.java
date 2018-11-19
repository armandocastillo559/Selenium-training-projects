package demos;

import org.openqa.selenium.WebDriver;

import utilities.ParseLinks;

public class PageScannerApp {

	public static void main(String[] args) {
		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("https://en.wikipedia.org/wiki/Main_Page");

		
		// Parse the links on the page
		ParseLinks.scan(driver, 3, true);

	}

}
