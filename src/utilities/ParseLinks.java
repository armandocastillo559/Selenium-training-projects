package utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParseLinks {

	// This method takes a WebDriver object and validates click-through of all a tag links on it
	public static void scan(WebDriver driver, int batchSize, boolean debug) {
		
		// INITIALIZE
		int totalLinksProcessed = 0;
		int totalSize;
		int batchCounter = 1;
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		String parentWindow;
		
		// DEBUG CONDITON
		if (debug == true) {
			System.out.println("DEBUG MODE " + driver.findElements(By.tagName("a")).size());
			totalSize = 8; 
		} else { totalSize = driver.findElements(By.tagName("a")).size(); }
		
		// BUILD LIST OF LINK ELEMENTS
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("DEBUG SIZE: " + totalSize + "  ACTUAL SIZE: " + links.size());	

		// PROCESS LIST
		while (totalLinksProcessed < totalSize) {
			System.out.println("Working on Batch: " + batchCounter);
			
		// PROCESS A BATCH
			for (int i = 0;i<batchSize;i++) {
				System.out.println("INSIDE");
				links.get(i).sendKeys(clickOnLink);
				System.out.println("Removing: " + links.get(i).toString());
				System.out.println("LINK COUNT: " + links.size());
				links.remove(0);
				System.out.println("LINK COUNT: " + links.size());
				totalLinksProcessed++;
				System.out.println("Total Links Prcessed: " + totalLinksProcessed);
			}
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> it=tabs.iterator();
			parentWindow = it.next();
//			driver.switchTo().window(it.next());
			while (it.hasNext()) {
				System.out.println("Switching to the next Tab");
				driver.switchTo().window(it.next());
				System.out.println("Tab title is: " + driver.getTitle());
				System.out.println("Closing Tab");
				driver.close();	
			}
			System.out.println("Done with Batch: " + batchCounter + " RESETTING DRIVER LOC");
			driver.switchTo().window(parentWindow);
			batchCounter++;
		}
	}
}

	
	
	

