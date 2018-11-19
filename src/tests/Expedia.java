package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;

	String city = "New York, NY";
	String checkIn = "12/02/2018";
	String checkOut = "12/05/2018";
	String childAge = "1";
	String starRating = "star5";
	String searchResult = "1";
	
	


	 
	
	
	Dimension d = new Dimension(1920,1080);
	String browserType = "chrome";
	
	@Test
	public void hotelReservation() {
		// 1. Search
		 
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(Keys.chord(Keys.CONTROL, "a"),city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(Keys.chord(Keys.CONTROL, "a"),checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(Keys.chord(Keys.CONTROL, "a"), checkOut);
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();
		// add child by clicking a + on the UI; subsequent select is for the age
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button")).click();
		new Select(driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/select"))).selectByValue(childAge);
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		// print the name of the city
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println(actualCity);
		
		// 2. Modify Search with criteria
		driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();
				
		// 3. Analyze the results and make our selection
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		
			// Switch window to the 'new tab' 
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		String ratingNumber = driver.findElement(By.cssSelector("input[class='rating-scale']")).getText();
		System.out.println(hotelName + " has rating scale of: " + ratingNumber);
		
		// 4. Book the reservation
		
		
		
		
		// 5. Fill out contact information
		
		// 6. Get confirmation
		
		
	}
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().setSize(d);
		driver.get("https://www.expedia.com/");


	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
