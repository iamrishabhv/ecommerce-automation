package SoftwareTestingBoardSite;

import org.openqa.selenium.By;
import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Constants;
import SoftwareTestingBoardSite.HomePage;
import SoftwareTestingBoardSite.BaseTest;


public class CreateAccountPage {
	
	public void CreateAccPage() {
		driver.get(Constants.CreateAcc);
		driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email_address")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#form-validate > div > div.primary > button > span")).click();
	}

}
