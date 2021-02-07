package openLink;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.NahlaPage;
import pages.HomePage;


public class SeleniumTest extends BaseTest  {

		//1 Click on Hide button & assert text before and after 			
		@Test(priority = 1) 
		public void clickHideBtn() {
			HomePage selenium = getDriver();
					
			Assert.assertEquals(selenium.hideText(), "Tekst koji treba biti sakriven", "Expected message is not displayed");
			selenium.clickHideBtn();
			Assert.assertEquals(selenium.hideText(), "", "Text is displayed but it should be hidden");
								
	}
		//2 Check that Emu checkbox is disabled 		
		@Test(priority = 2)
		public void isEmuCheckBoxDisabled() {
			HomePage selenium = getDriver();
					
			Assert.assertFalse(selenium.isEmuCheckBoxDisabled(), "<Emu> checkbox is not disabled");	
			
	}
		//3 Verify that total number of checkboxes is 6		
		@Test(priority = 3)
		public void checkNumberOfCheckboxes() {
			HomePage selenium = getDriver();
					
			int number = selenium.checkNumberOfCheckboxes("checkbox");
			Assert.assertEquals(number, 6, "Total number of checkboxes is not 6"); 
	
	}
		//4 Select Radio button Jezeva kucica
		@Test(priority = 4)
		public void selectRadioBtnJezevaKucica() {
			HomePage selenium = getDriver();
						
			Assert.assertTrue(selenium.selectRadioBtnJezevaKucica(), "<Jezeva kucica> is not selected");
			System.out.println("<Jezeva kucica> is selected: " + selenium.selectRadioBtnJezevaKucica());
			
			
	}
		//5 From Nahla Courses select Turski 				
		@Test(priority = 5)
		public void selectTurskiFromDropdownNahlaCourses() {
			HomePage selenium = getDriver();
			
			Assert.assertEquals(selenium.selectTurskiFromDropdownNahlaCourses(), "Turski", "<Turski> is not selected Course");
			
	}
		//6 Click on "Prompt box!" button and dismis alert, check that under button following text: "User cancelled the prompt." is displayed 
		@Test(priority = 6)
		public void clickPromptBoxGetTextAfterCancel() {
			HomePage selenium = getDriver();
					
			Assert.assertEquals(selenium.clickPromptBoxGetTextAfterCancel(), "User cancelled the prompt.", "Expected message is not displayed");
			System.out.println("Message is displayed: " + selenium.clickPromptBoxGetTextAfterCancel());
			
	}
		//7 Click on "Prompt box!" button, enter your name and click on OK, Check that under button following text: "Hello <name>" is displayed
		@Test(priority = 7)
		public void checkPromptBoxAndText() {
			HomePage selenium = getDriver();
						
			Assert.assertEquals(selenium.checkPromptBoxAndText(), "Hello Ade", "Expected name is not displayed");
			System.out.println("Text in promt box is " + selenium.checkPromptBoxAndText());
			
	}
		//8 Get total number of rows and columns for table "Podaci o studentima". Note: include title row
		@Test(priority = 8)
		public void getTableNumberRowsCols() {
			HomePage selenium = getDriver();
					
			selenium.getTableNumberRowsCols();
	
	}
		//9 Get total number of rows for table "Podaci o studentima". Note: exclude title row
		@Test(priority = 9)
		public void getTableNumberRowsExcludeTitle() {
			HomePage selenium = getDriver();
			
			selenium.getTableNumberRowsExcludeTitle();
		
	}
		//10 Get First and Last Name for students who are attending English course from the table
		@Test(priority = 10)
		public void getNamesForStudentsInEnglishCourse() {
			HomePage selenium = getDriver();
			
			selenium.getNamesForStudentsInEnglishCourse();
			
	}
		//11 Click on "Click to open a new browser window!" button, *Nahla page, click on menu, select Nahlin tim, Close Nahla browser and 
		//continue to work on automation page 
		@Test(priority = 11)
		public void openNewWindowNahlaPage() throws Exception {
			HomePage selenium = getDriver();
			
			NahlaPage nahla = selenium.clickNewBrowserButton();
			nahla.clickONamaMenuSelectNahlinTim();	
			
	}	
		//12 List of elements before change
		@Test(priority = 12)
		public void listOfDragAndDropElements() throws Exception {
			HomePage selenium = getDriver();
			
			Assert.assertEquals(selenium.listOfDragAndDropElements(), "click()\n" + "sendKeys()\n" + "findElement()\n" + 
					"clickAndHold()", "Order of elements doesn't match ");
		//	System.out.println("List of elements: " + selenium.listOfDragAndDropElements());
			
	}	
		
		//13 Take a screenshot before Drag And Hover and save it in folder
		//13 Re-order elements by using drag and drop - "Click and hold" move to the top of list
		@Test(priority = 13)
		public void dragAndDrop() throws Exception {
			HomePage selenium = getDriver();
		
			selenium.dragAndDrop();
			
			// List of elements after change
			Assert.assertEquals(selenium.listOfDragAndDropElements(), "clickAndHold()\n" + "click()\n" + "sendKeys()\n" + 
					"findElement()", "Order of elements doesn't match ");
					
	}	
		//14 Move mouse over "Mouse over me"
		//14 Take a screenshot after Mouse over and save it in folder
		@Test(priority = 14)
		public void mouseOver() throws Exception {
			HomePage selenium = getDriver();
			
			selenium.mouseOver();
			selenium.screenshot("2afterDragAndHover");
			
	}				
		//15 Click on "Volontiraj" link in footer, inside the frame and verify that user is on Volontiraj page
		@Test(priority = 15)
		public void clickOnVolontirajLink() {
			HomePage selenium = getDriver();
			
			Assert.assertEquals(selenium.clickOnVolontirajLink(), "Volontiraj", "User is not on <Volontiraj> page");
					
	}		
		//16 Verify that user is on: "https://amina-pez.github.io/automation/"
		@Test(priority = 16)
		public void getCurrentUrl() {
			HomePage selenium = getDriver();
			
			Assert.assertEquals(selenium.getCurrentUrl(), "https://amina-pez.github.io/automation/", "User is not on the correct page");
					
	}
	
}		
				