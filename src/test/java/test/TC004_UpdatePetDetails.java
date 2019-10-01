package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseUtils.StartUpConfig;
import pages.PetCreation;
import pages.PetList;

public class TC004_UpdatePetDetails {
	
	WebDriver driver;
	StartUpConfig sc = new StartUpConfig();
	PetList pl;
	
	@Test
	public void updatePet() {
		driver = sc.open();
		pl = new PetList(driver);
		
		pl.updatePetList("Pluto", "Jacky", "Sold");
		
	}
	

}
