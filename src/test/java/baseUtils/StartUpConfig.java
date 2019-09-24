package baseUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartUpConfig {
	
	WebDriver driver;
	
	public WebDriver open() {
		System.setProperty("webdriver.chrome.driver", "C:\\software\\Selenium Browser Drivers\\chromedriver_win32_77\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qa-petstore.herokuapp.com/");
		return driver;
	}
	
	

}
