package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;




public class NahlaPage {

	private WebDriver driver;
	
	// locators
		private By mouseoverONamaMenu = By.xpath("//*[@id=\"menu-item-22\"]/a"); //id looks dynamic * - //li[contains(.,'O NAMA')] 
		private By clickNahlinTim = By.xpath("//*[@id=\"menu-item-1464\"]/a"); 
	
	//constructor
	public NahlaPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
	//11 When on Nahla page click on "O NAMA" menu and click on "Nahlin tim"  
	public void clickONamaMenuSelectNahlinTim() {
		
		String SeleniumPage = driver.getWindowHandle();
		Set<String> allHandles= driver.getWindowHandles();
		for(String NahlaPage : allHandles){
		    driver.switchTo().window(NahlaPage);
			}
		// Verify that user is on "Nahla" page
		Assert.assertEquals(getCurrentUrl(),"https://nahla.ba/", "User is on correct page");
		
		Actions action = new Actions(driver);
		WebElement nahla = driver.findElement(mouseoverONamaMenu);
		action.moveToElement(nahla).perform();
		
			driver.findElement(clickNahlinTim).click();
			
		// Verify that user is on "Nahla tim" page
		Assert.assertEquals(getCurrentUrl(),"https://nahla.ba/o-nama/#tim", "User is on correct page");
		
		// Close nahla browser and continue to work on automation page
			driver.close(); 
		 	driver.switchTo().window(SeleniumPage);
			
	}
	
		public String getCurrentUrl() {
		
			return driver.getCurrentUrl();
		
		
			
		}

		}

