package SoftwareTestingBoardSite.Pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SoftwareTestingBoardSite.Utils.Constants;
import SoftwareTestingBoardSite.Utils.DriverConfiguration;
//import software.Testing.Board.Site.BaseTest;

public class HomePage {
	
	private WebDriver driver;
	
	String browser = "chrome";

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
