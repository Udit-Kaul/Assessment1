package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtility {

	static WebDriver driver=null;
	static String baseURL="http://www.expedia.com";
	public  static WebDriver getWebdriver() {
		
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver", Utility.getProjectDirectory()+"//src//test//resources//chromedriver.exe");

			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseURL);
			return driver;
		}
		else {
			return driver;
		}
	}
}
