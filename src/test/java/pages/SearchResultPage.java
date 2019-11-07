package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.WebDriverUtility;

public class SearchResultPage {

	WebDriver driver;
	public SearchResultPage() {
		driver = WebDriverUtility.getWebdriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@id=\"flightModuleList\"]/li[1]/div/div/div[2]/div/div/div/span")
	WebElement priceTag;
	
	@FindBy(id="airlines-included-legend")
	WebElement airlinesIncludedPanel;
	
	@FindBy(xpath = "//*[@id=\"site-footer-wrap\"]/div[contains(text(),\"2019 Expedia, Inc\")]")
	 WebElement copyrightFooter;
	
	public String getPriceTag() {
		return priceTag.getText();
	}
	
	public boolean isAirlinesPanelIncluded() {
		return airlinesIncludedPanel.isDisplayed();
	}
	
	public void scrollToCopywrightFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView();", copyrightFooter);
	}
	
	public boolean isCopywrightFooterVisible() {
		return copyrightFooter.isDisplayed();
	}
	
}
