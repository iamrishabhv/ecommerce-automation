package SoftwareTestingBoardSite;

import org.openqa.selenium.*;
import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Constants;
import SoftwareTestingBoardSite.HomePage;
import SoftwareTestingBoardSite.BaseTest;

public class SignInPage {
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SignInPage(String email, String password, String fullName) throws InterruptedException {
		driver.get(Constants.SignInPage);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#send2 > span")).click();
		Thread.sleep(2000);
		WebElement accName = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome > span"));
		String acAccName = accName.getText();
		System.out.println(acAccName);
		String exAccName = "Welcome, " + fullName;
		try {
			acAccName.equalsIgnoreCase(exAccName);
			System.out.println("Sign In Successful!");
		} catch(Exception e) {
			System.out.println("Sign In Unsuccessful!");
			e.getStackTrace();
		}
		
	}
}