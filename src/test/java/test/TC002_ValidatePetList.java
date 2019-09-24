package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseUtils.StartUpConfig;
import pages.PetList;

public class TC002_ValidatePetList {
	
	WebDriver driver;
	StartUpConfig sc = new StartUpConfig();
	PetList pl;
	
	
	@Test
	public void validatePetList() {
		
		driver = sc.open();
		pl = new PetList(driver);
		
		//To verify list is visible
		//pl.verifyPetList();
		
		//To verify the number of columns in the table
		//pl.verifyNumberOfCol(3);
		
		//To verify the Names of the columns
		//pl.verifyColumnNames("Name", "Status", "Action");
		
		System.out.println(pl.locatePetIndex("Pluto"));
		
		driver.quit();
	}

}
