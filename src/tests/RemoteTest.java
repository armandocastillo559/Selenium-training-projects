package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTest {

	public static void main(String[] args) throws MalformedURLException {
		
		// Automated - chrome, firefox, ie, safari, edge
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.LINUX);
		//
		
		//WebDriver
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.190:4444/wd/hub"), dc);
		driver.get("http://google.com");
		
		
		 
		
	}
	
	
	
}
