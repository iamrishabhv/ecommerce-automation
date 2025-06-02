package software.Testing.Board.Site;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SoftwareTestingBoardSite.Utils.Constants;
import SoftwareTestingBoardSite.Utils.DriverConfiguration;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverConfiguration.initializeDriver("chrome");
		driver.get(Constants.HomePage);
	}
	
	@AfterMethod
	public void teardown() {
		DriverConfiguration.quitDriver();
	}

}
