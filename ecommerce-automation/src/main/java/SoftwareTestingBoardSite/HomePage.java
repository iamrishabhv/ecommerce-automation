package SoftwareTestingBoardSite;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import SoftwareTestingBoardSite.DriverConfiguration;
import SoftwareTestingBoardSite.Utils.*;
import SoftwareTestingBoardSite.BaseTest;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void HomePageElements() throws InterruptedException {
		driver.get(Constants.HomePage);
		Thread.sleep(10000);
		WebElement whatsNew = driver.findElement(By.cssSelector("#ui-id-3"));
		WebElement women = driver.findElement(By.cssSelector("#ui-id-4"));
		WebElement men = driver.findElement(By.cssSelector("#ui-id-5"));
		WebElement gear = driver.findElement(By.cssSelector("#ui-id-6"));
		WebElement training = driver.findElement(By.cssSelector("#ui-id-7"));
		WebElement sale = driver.findElement(By.cssSelector("#ui-id-8"));
		try {
			if(whatsNew.isDisplayed()) {
				System.out.println("What's New Element is Present");
			}
			if(women.isDisplayed()) {
				System.out.println("Women Element is Present");
			}
			if(men.isDisplayed()) {
				System.out.println("Men Element is Present");
			}
			if(gear.isDisplayed()) {
				System.out.println("Gear Element is Present");
			}
			if(training.isDisplayed()) {
				System.out.println("Training Element is Present");
			}
			if(sale.isDisplayed()) {
				System.out.println("Sale Element is Present");
			}	
		}catch(Exception e) {
			System.out.println("Element not found!!");
			e.printStackTrace();
		}
		
	}
	
	public void HomePageHeaderElements() throws InterruptedException {
		driver.get(Constants.HomePage);
		Thread.sleep(10000);
		WebElement searchBar = driver.findElement(By.cssSelector("#search"));
		WebElement signInLink = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a"));
		WebElement createAcPg = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a"));
		WebElement cart = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a"));
		WebElement logo = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > a > img"));
		try {
			if(searchBar.isDisplayed()) {
				System.out.println("Search Bar is Present.");
			}
			if(signInLink.isDisplayed()) {
				System.out.println("Sign In Link is Present.");
			}
			if(createAcPg.isDisplayed()) {
				System.out.println("Create Account Link is Present.");
			}
			if(cart.isDisplayed()) {
				System.out.println("Cart Link is Present.");
			}
			if(logo.isDisplayed()) {
				System.out.println("Logo is Present.");
			}
		}catch(Exception e) {
			System.out.println("Element not found");
			e.printStackTrace();
		}
	}

}
