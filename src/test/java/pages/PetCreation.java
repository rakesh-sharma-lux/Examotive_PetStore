package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PetList;

public class PetCreation {
	
	WebDriver driver;
	PetList pl;
	
	@FindBy(xpath = "//input[@placeholder=\"Pet Name\"]")
	WebElement petName;
	
	@FindBy(xpath = "//input[@placeholder=\"Pet Status\"]")
	WebElement petStatus;
	
	@FindBy(xpath = "//*[@id=\"btn-create\"]")
	WebElement btnCreate;
	
	

	public PetCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pl = new PetList(driver);
	}
	
	public void createPet(String name, String status) {
		//int rowsBeforeCreation = pl.tableRows.size();
		petName.sendKeys(name);
		petStatus.sendKeys(status);
		btnCreate.click();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(pl.tableData.get(index)))
		
		
		//try{driver.wait(2000);}catch(Exception e) {System.out.println(e);}
		Assert.assertNotEquals(pl.locatePetIndex(name), -1);
		//verifyPetCreation(name);
		//Assert.assertEquals(pl.tableRows.size(), rowsBeforeCreation + 1);
	}
	
	public void verifyPetCreation(String name) {
		Assert.assertNotEquals(pl.locatePetIndex(name), -1);
	}
	
	public void modifyPet(String name, String newName, String newstatus) {
		//int index = pl.locatePetIndex(name);
		//if(index != -1) {}
			
				
		
	}
	

}
