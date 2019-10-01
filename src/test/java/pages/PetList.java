package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.yaml.snakeyaml.scanner.Constant;

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
	List<WebElement> tableDataName;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/input")
	List<WebElement> tableDataNameInput;
	
	
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> tableDataStatus;
	
	
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
		  System.out.println(tableDataName.size());
		  for(WebElement e: tableDataName) {
			  //System.out.println(e.getText());
			  petName.add(e.getText());
			  //System.out.println(petName.size());
		  }
			  
//		  Optional<String> findAny = tableData.stream().map(e -> e.getText()).filter(td -> td.equals(name)).findAny();
//		  return findAny.isPresent();

		  return petName.indexOf(name);
		  
	}
	 
	 public void updatePetList(String name, String newName, String newstatus) {
		 int index = locatePetIndex(name);
		 if(index != -1) {
			 System.out.println("index is : " + index);
			 WebElement e = tableDataName.get(index);
			 			 
			 //..findElement(By.tagName("input"));
				//	 tableRows.
			 //System.out.println(e);
			 
			 //e.getTagName()
			 e.click();
			 e = tableDataNameInput.get(index);
			 e.click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 e.clear();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 //e.getCssValue(arg0)
			 System.out.println(newName);
			 e.sendKeys(newName);
			 System.out.println("exiting");
			 
			 /*WebElement e2 = tableRows.get(index).findElement(By.xpath("//td[2]/span"));
			 e2.click();
			 e2.sendKeys(newstatus);
			 e.click();*/
		 }
	 }
	 
	 
	 
	
	
}
