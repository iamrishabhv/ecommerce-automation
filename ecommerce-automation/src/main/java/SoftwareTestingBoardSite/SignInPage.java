package SoftwareTestingBoardSite;

import org.openqa.selenium.*;
//import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Utils.*;
import SoftwareTestingBoardSite.HomePage;
import SoftwareTestingBoardSite.BaseTest;

public class SignInPage {
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signIn(String email, String password, String fullName) throws InterruptedException {
		driver.get(Constants.SignInPage);
		try {
			driver.findElement(By.cssSelector("#email")).sendKeys(email);
			driver.findElement(By.cssSelector("#pass")).sendKeys(password);
			driver.findElement(By.cssSelector("#send2 > span")).click();
			Thread.sleep(2000);
			if(email == null || email.isEmpty() || !email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
				System.out.println("Please Enter a Valid Email Address!");
				return;
			}
			if(password == null || password.isEmpty() || !password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
				System.out.println("Please Enter a Valid Password!");
				return;
			}
			if(email.isEmpty() && password.isEmpty()) {
				System.out.println("Please Enter the Email & Password!");
			}
			
			WebElement accName = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome > span"));
			String acAccName = accName.getText();
			String exAccName = "Welcome, " + fullName;
			if (acAccName.equalsIgnoreCase(exAccName)) {
				System.out.println("Sign In Successful!");
	            } else {
	                System.out.println("Sign In Unsuccessful!");
	            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

//Please enter a valid email address (Ex: johndoe@domain.com).