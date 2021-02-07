package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	
	// locators
	private By hideBtn = By.id("hide-textbox");
	private By hideText = By.id("displayed-text");
	private By disabledCheckBoxEmu = By.id("emu-checkbox");
	private By selectRadioBtnJezevaKucica = By.xpath("//input[@value=\"Jezeva kucica\"]");
	private By selectTurskiFromDropdownNahlaCourses = By.id("Nahla Course");
	private By clickPromptBtn = By.id("promptBox");
	private By getPromptText = By.id("demo");
	//table locators
	private By getTableNumberRowsExcludeTitle = By.xpath("//*[@id=\"studentTable\"]/tbody/tr[position()>1]");
	private By getTableNumberRows = By.cssSelector("#studentTable > tbody > tr");
	private By getTableNumberColumns = By.cssSelector("#studentTable > tbody > tr > th");
	private By course = By.xpath("//th[contains(.,'Course')]");
	private By getNamesEnglish = By.xpath("//td[contains(.,'English')]/preceding-sibling::*");
	//new browser window locator
	private By clickNewBrowserButton  = By.id("win1");
	//drag drop & mouse over
	private By listOfDragAndDropElements = By.id("sortable");
	private By clickAndHold = By.id("clickAndHold");
	private By click = By.id("click");
	private By mouseOver = By.id("demo2");
	//frame locators
	private By iframe = By.xpath("//div[@class='row']//iframe");
	private By clickOnVolontirajLink = By.xpath("//a[@href=\"https://nahla.ba/volontiraj/\"]");
	private By getVonlotirajTitle = By.xpath("//*[@id=\"post-2340\"]");

	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
				
		
	}
	//1. Click on Hide button
	public void clickHideBtn() {
		
		driver.findElement(hideBtn).click();
		
	}
	//1 Verify that "Tekst koji treba biti sakriven" is hidden
	public String hideText() {
		
		return driver.findElement(hideText).getText();

	}
	//2 Check that Emu checkbox is disabled 
	public boolean isEmuCheckBoxDisabled() {
		
		return driver.findElement(disabledCheckBoxEmu).isEnabled();
				
	}
	//3 Verify that total number of checkboxes is 6
	public int checkNumberOfCheckboxes(String checkbox) {
		
		List<WebElement> checkBoxList = driver.findElements(By.cssSelector("[type=\"" + checkbox + "\"]"));
		System.out.println("Number of checkboxes is: " + checkBoxList.size());	
		return checkBoxList.size();
		
	}
	//4 Select Radio button Jezeva kucica
	public boolean selectRadioBtnJezevaKucica() {
		driver.findElement(selectRadioBtnJezevaKucica).click();
		return driver.findElement(selectRadioBtnJezevaKucica).isSelected();
				
	}
	//5 From Nahla Courses select Turski 
	public String selectTurskiFromDropdownNahlaCourses() {
	
		Select selectDropdown = new Select(driver.findElement(selectTurskiFromDropdownNahlaCourses));
		selectDropdown.selectByVisibleText("Turski");
		WebElement course = selectDropdown.getFirstSelectedOption();
		return course.getText(); 
		
	}
	//6 Click on "Prompt box!" button and dismiss alert, check that under button following text: "User cancelled the prompt." is displayed 
	public String clickPromptBoxGetTextAfterCancel() {
		
		driver.findElement(clickPromptBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		return driver.findElement(getPromptText).getText();
		
	}
	//7 Click on "Prompt box!" button, enter name and click on OK, Check that under button following text: "Hello <name>" is displayed
	public String checkPromptBoxAndText() {
		
		driver.findElement(clickPromptBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Ade");
		driver.switchTo().alert().accept();
		return driver.findElement(getPromptText).getText();
		
	}
	//8 Get total number of rows and columns for table "Podaci o studentima"
	public void getTableNumberRowsCols() {
		
		List<WebElement> row = driver.findElements(getTableNumberRows);
		List<WebElement> column = driver.findElements(getTableNumberColumns);
		System.out.println("The number of rows is " + row.size() + ", The number of columns is " + column.size());
		
		
	}
	//9 Get total number of rows for table "Podaci o studentima". Note: exclude title row
	public void getTableNumberRowsExcludeTitle() {
		
		List<WebElement> row = driver.findElements(getTableNumberRowsExcludeTitle);
		System.out.println("Total Number of Rows (ExcludeTitle) is " + row.size());
		
	}
	//10 Get First and Last Name for students which are in English course from the table
	public void getNamesForStudentsInEnglishCourse() {
		
		WebElement table = driver.findElement(getTableNumberRows);
	    List<WebElement> courses = table.findElements(course);
	     
	    for (WebElement row : courses) {
	    	 List<WebElement> cols = row.findElements(getNamesEnglish);
	        for (WebElement FirstLastName : cols) {
	      
	       System.out.print(FirstLastName.getText() + " ");
	       if 	(cols.isEmpty()) System.out.println("No student is taking English course");
	        }
	    }
	   	  	   
	}
	//11 Click on "Click to open a new browser window!" button, click on menu, select Nahlin tim, Close Nahla browser and 
	//continue to work on automation page 
	public NahlaPage clickNewBrowserButton() {
		
		driver.findElement(clickNewBrowserButton).click();
		return new NahlaPage(driver);
			
	}	
	//12 List of elements before change
	public String listOfDragAndDropElements() {
		
		return driver.findElement(listOfDragAndDropElements).getText();
		
	}
	//13 Take a screenshot before Drag And Hover and save it in folder. Title of screenshot is "1beforeDragAndHover.png"
	//13 Re-order elements by using drag and drop - "Click and hold" move to the top of list
	public void dragAndDrop() throws Exception {
		scrollToElement(clickNewBrowserButton);	
		screenshot("1beforeDragAndHover");
		
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(clickAndHold); 
		WebElement targetElement = driver.findElement(click); 
		action.dragAndDrop(sourceElement, targetElement).perform();
				
	}
	//14 Move mouse over "Mouse over me"
	//14 Take a screenshot after Drag And Hover and save it in folder. Title of screenshot is "2afterDragAndHover.png"
	public void mouseOver() throws Exception {
		scrollToElement(clickNewBrowserButton);	
		Actions action = new Actions(driver);
		WebElement selenium = driver.findElement(mouseOver);
		action.moveToElement(selenium).perform();
			
	}
	//15 Click on "Volontiraj" link, in footer, inside the frame and verify that user is on Volontiraj page
	public String clickOnVolontirajLink()   {
		
		driver.switchTo().frame(driver.findElement(iframe));				
		driver.findElement(clickOnVolontirajLink).click();	
		String title = driver.findElement(getVonlotirajTitle).getText();
		driver.switchTo().defaultContent();
		return title;
		
	}
	//16 Verify that user is on: "https://amina-pez.github.io/automation/"
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
			
	}
	
	public void screenshot(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	
	}
		
	private void scrollToElement(By item) {
		WebElement element = driver.findElement(item);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

}	 		
