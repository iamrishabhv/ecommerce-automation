package SoftwareTestingBoardSite;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverConfiguration.initializeDriver("chrome");
	}
	
	@AfterMethod
	public void teardown() {
		DriverConfiguration.quitDriver();
	}

}
