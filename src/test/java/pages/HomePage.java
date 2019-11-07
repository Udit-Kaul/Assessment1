package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WebDriverUtility;

public class HomePage {

	WebDriver driver;
	
	WebDriverWait wait;
	
	@FindBy(id = "tab-flight-tab-hp")
	WebElement flightsButton;

	@FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
	WebElement departureAirportTextBox;

	@FindBy(xpath = "//*[@class='results-item'][2]")
	WebElement selectDepartureAirport;

	@FindBy(id = "flight-destination-hp-flight")
	WebElement arrivalAirportTextBox;

	@FindBy(xpath = "//*[@class=\"results-item\"][1]")
	WebElement selectArrivalAirport;

	@FindBy(id = "flight-departing-hp-flight")
	WebElement departingDate;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement returningDate;

	@FindBy(xpath = "//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/button")
	WebElement passengerDropDown;

	@FindBy(xpath = "//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/div/div/div/div[1]/div[4]/button")
	WebElement addAdultButton;

	@FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[7]/label/button")
	WebElement searchButton;

	public HomePage() {
		driver = WebDriverUtility.getWebdriver();
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,10);
	}

	public boolean isFlightsButtonEnabled() {
		return flightsButton.isEnabled();
	}

	public void clickFlightsButton() {
		flightsButton.click();
	}
	
	public void waitForVisibilityOfDepartureAirportTextBox() {
		wait.until(ExpectedConditions.visibilityOf(departureAirportTextBox));
	}
	public void enterTextInDepartureAirportTextBox(String text) {
		departureAirportTextBox.clear();
		departureAirportTextBox.sendKeys(text);
	}

	public void selectDepartureAirport() {
		selectDepartureAirport.click();
	}

	public void enterArrivalAirport(String arrivalAirport) {
		arrivalAirportTextBox.clear();
		arrivalAirportTextBox.sendKeys(arrivalAirport);
	}

	public void selectArrivalAirport() {
		selectArrivalAirport.click();
	}

	public void selectDepartingDate(String date) {
		departingDate.sendKeys(date);
	}

	public void selectReturningDate(String date) {
		returningDate.sendKeys(date);
	}

	public void clickPassengerDropDown() {
		passengerDropDown.click();
	}

	public void clickAddAdultButton() {
		addAdultButton.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

}
