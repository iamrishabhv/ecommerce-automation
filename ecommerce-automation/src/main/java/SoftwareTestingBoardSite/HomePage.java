package SoftwareTestingBoardSite;

import org.openqa.selenium.By;

import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Constants;

public class HomePage extends DriverConfiguration{
	
	String browser = "chrome";

	public void WomenPage() {
		driver.get(Constants.WomenPage);
	}
	
	public void MenPage() {
		driver.get(Constants.MenPage);
	}

}
