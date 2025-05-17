package com.selenium.test.ecommerce_automation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommerce {
	
	@Test //Test to Verify Home Page Title
	public void homePage() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(actualTitle, expectedTitle, "Page Title does not match the expected value.");
		driver.quit();
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Laptop");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		//Assert 1
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.in : Laptop";
		assertEquals(actualTitle, expectedTitle, "Page Title Does Not Match");
		
		//Assert 2
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/s?k=Laptop&ref=nb_sb_noss";
		assertEquals(actualURL, expectedURL, "Incorrect URL");
		
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
