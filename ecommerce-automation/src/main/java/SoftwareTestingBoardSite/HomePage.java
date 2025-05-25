package SoftwareTestingBoardSite;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Constants;
import SoftwareTestingBoardSite.BaseTest;

public class HomePage {
	
	private WebDriver driver;
	
	String browser = "chrome";
	Scanner ip = new Scanner(System.in);
	String firstName = ip.nextLine();
	String lastName = ip.nextLine();
	String emailAddress = ip.nextLine();
	String password = ip.nextLine();

	public void WomenPage() {
		driver.get(Constants.WomenPage);
	}
	
	public void MenPage() {
		driver.get(Constants.MenPage);
	}
	
	public void SignInPage() {
		driver.get(Constants.SignInPage);
	}

}
