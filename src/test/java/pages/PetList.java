package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class PetList {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class=\"pet-list\"]")
	WebElement petList;
	
	@FindBy(xpath = "//div[@class=\"pet-list\"]//h3")
	WebElement listTitle;
	
	@FindBy(xpath = "//table//tr/th")
	List<WebElement> tableHeaders;
	
	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/span")
	List<WebElement> tableData;
	
	
	public PetList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPetList() {
		Assert.assertTrue(petList.isDisplayed());
		Assert.assertEquals(listTitle.getText(),"List of Pets");
	}
	
	public void verifyNumberOfCol(int num) {
		Assert.assertEquals(tableHeaders.size(), num);
	}
	
	public void verifyColumnNames(String c1,String c2,String c3) {
		Assert.assertEquals(tableHeaders.get(0).getText(), c1);
		Assert.assertEquals(tableHeaders.get(1).getText(), c2);
		Assert.assertEquals(tableHeaders.get(2).getText(), c3);
	}
	
	
	 public int locatePetIndex(String name) { 
		  List<String> petName = new ArrayList<String>(); 
		/*
		 * for(int i=1;i<=tableRows.size();i++) petName.add(tableData.get(i).getText());
		 */
		  System.out.println(tableData.size());
		  for(WebElement e: tableData) {
			  System.out.println(e.getText());
			  petName.add(e.getText());
		  }
			  
//		  Optional<String> findAny = tableData.stream().map(e -> e.getText()).filter(td -> td.equals(name)).findAny();
//		  return findAny.isPresent();

		  return petName.indexOf(name);
		  
	}
	 
	
	
}
