package SoftwareTestingBoardSite;

import org.openqa.selenium.*;
import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Constants;
import SoftwareTestingBoardSite.HomePage;
import SoftwareTestingBoardSite.BaseTest;


public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void CreateAccPage(String firstName, String lastName, String email, String password) {
		driver.get(Constants.CreateAcc);
		driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#password-confirmation")).sendKeys(password);
		driver.findElement(By.cssSelector("#form-validate > div > div.primary > button > span")).click();
		try {
			if(firstName == null || firstName.isEmpty() || !firstName.matches("^[A-Z][a-zA-Z]{1,29}$")) {
				System.out.println("Please Enter a Valid First Name");
			}
			if(lastName == null || lastName.isEmpty() || !lastName.matches("^[A-Z][a-zA-Z]{1,29}$")) {
				System.out.println("Please Enter a Valid Last Name");
			}
			if(email == null || email.isEmpty() || !email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
				System.out.println("Please Enter a Valid Email Address");
			}
			if(password == null || password.isEmpty() || !password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) 		{
				System.out.println("Please Enter a Valid Password");
			}		
			String accRegTxt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
			String expRegTxt = "Thank you for registering with Main Website Store.";
				if(accRegTxt.equalsIgnoreCase(expRegTxt)) {
					System.out.println("Registration Successful!");
				}else {
					System.out.println("Registration Unsuccessful!");
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
}
}
