package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.util.Util;
import pages.HomePage;
import pages.SearchResultPage;
import utilities.Utility;
import utilities.WebDriverUtility;

public class KBCTest {
	
WebDriver driver=null;
HomePage homePage=null;
SearchResultPage searchPage=null;
WebDriverWait wait=null;
@BeforeSuite
public void beforeClass() {
	driver =WebDriverUtility.getWebdriver();
	homePage=new HomePage();
	searchPage=new SearchResultPage();
	wait=new WebDriverWait(driver,10);
	}

@BeforeTest(alwaysRun = false)
public void BeforeTest() {
	
	if(homePage.isFlightsButtonEnabled()) {
		homePage.clickFlightsButton();
	}
	
	homePage.waitForVisibilityOfDepartureAirportTextBox();
	
	homePage.enterTextInDepartureAirportTextBox("London");
	  
	Utility.sleepforTime(8000);
	
	homePage.selectDepartureAirport();
		
		 homePage.enterArrivalAirport("Dublin");
		 
		 
		  homePage.selectArrivalAirport();
		  
		  homePage.selectDepartingDate("11/08/2019");
		  
		  homePage.selectReturningDate("11/13/2019");
		  
		  homePage.clickPassengerDropDown();
		  
		  Utility.sleepforTime(5);
		  homePage.clickAddAdultButton();
		  homePage.clickSearchButton();
	
}

@Test(priority = 1, testName = "Check if the price is $441")
public void doesPriceMatch() {
	Assert.assertEquals(searchPage.getPriceTag(), "$441");
	
}

@Test(priority = 2, testName = "Check if price is not $22.33")
public void doesPriceNotMatch() {
	Assert.assertNotEquals(searchPage.getPriceTag(), "$22.33","Price in the first row is not $22.33");
}

@Test(priority = 3, testName = "Is left panel visible")
public void isLeftPanelListIncluded(){
	Assert.assertTrue(searchPage.isAirlinesPanelIncluded(),"Airlines included panel is displayed");
}

@Test(priority = 4, testName = "Is the Copywright present at the botton of the page")
public void isCopywrightFooterPresent() {
	searchPage.scrollToCopywrightFooter();
	Assert.assertTrue(searchPage.isCopywrightFooterVisible(),"Copywright Footer is Displayed");
}
  
  @AfterSuite
  public void afterSuite() {
	  driver.quit();
}
}
