package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseUtils.StartUpConfig;
import pages.PetCreation;


public class TC003_ValidatePetCreation {

	WebDriver driver;
	StartUpConfig sc = new StartUpConfig();
	PetCreation pc;
	
	@Test
	public void validatePetCreation() {
		
		driver = sc.open();
		pc = new PetCreation(driver);
		
		pc.createPet("Mojo", "Available");
				
	}
}
