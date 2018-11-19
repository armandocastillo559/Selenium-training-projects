package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// This method returns a WebDriver object
	
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\EatLocal\\Google Drive\\Education\\resources\\Software\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\EatLocal\\Google Drive\\Education\\resources\\Software\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\EatLocal\\Google Drive\\Education\\resources\\Software\\MicrosoftWebDriver.exe");
			System.out.println("LAUNCHING EDGE");
			return new EdgeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\EatLocal\\Google Drive\\Education\\resources\\Software\\chromedriver.exe");
			return new ChromeDriver();
		}
	}

}
