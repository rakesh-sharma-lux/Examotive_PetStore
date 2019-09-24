package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.PetstoreHomepage;
import baseUtils.StartUpConfig;

public class TC001_ValidateBanner {
	
	WebDriver driver;
	
	StartUpConfig sc = new StartUpConfig();
	PetstoreHomepage ptHome; 
	
		
	@Test
	public void validateBanner() {
		driver = sc.open();
		ptHome = new PetstoreHomepage(driver);		
		
		//To verify Banner text and Current date
		ptHome.validateBannerText();
		ptHome.validateBannerDate();
		
		driver.quit();
	}
	
	
}
