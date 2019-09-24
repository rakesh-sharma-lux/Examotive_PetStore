package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PetstoreHomepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[1]/nav/div")
	WebElement bannerText;
	
	@FindBy(xpath="//span[@class=\"banner-date\"]")
	WebElement bannerDate;
	
	
	public PetstoreHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    Date date = new Date();
	    return formatter.format(date);
	}
	
	public void validateBannerText() {
		String expectedText = "Hello stranger, today's date is :";
		Assert.assertEquals(bannerText.getText().substring(0, expectedText.length()),expectedText);
	}
	
	
	public void validateBannerDate() {
		Assert.assertEquals(bannerDate.getText(),getCurrentDate());
	}
	
	 

}
