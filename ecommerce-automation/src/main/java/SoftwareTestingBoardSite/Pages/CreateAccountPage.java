package SoftwareTestingBoardSite.Pages;

import org.openqa.selenium.*;

import SoftwareTestingBoardSite.Pages.HomePage;
import SoftwareTestingBoardSite.Utils.Constants;
import SoftwareTestingBoardSite.Utils.DriverConfiguration;
//import software.Testing.Board.Site.BaseTest;


public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void CreateAccPage(String firstName, String lastName, String emailAddress, String password) {
		driver.get(Constants.CreateAcc);
		driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email_address")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#password-confirmation")).sendKeys(password);
		driver.findElement(By.cssSelector("#form-validate > div > div.primary > button > span")).click();
		WebElement RegTxt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
		String accRegTxt = RegTxt.getText();
		String expRegTxt = "Thank you for registering with Main Website Store.";
		try {
			accRegTxt.equalsIgnoreCase(expRegTxt);
			System.out.println("Registration Successful!");
		}
		catch(Exception e) {
			System.out.println("Something Went Wrong!");
			e.getStackTrace();
		}
	}

}
