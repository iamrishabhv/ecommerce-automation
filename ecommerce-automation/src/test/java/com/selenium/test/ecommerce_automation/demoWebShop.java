package com.selenium.test.ecommerce_automation;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoWebShop {
	
	@Test
	public void getWebSite() {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		//Assert
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://demowebshop.tricentis.com/";
		if(actualURL.matches(expectedURL)) {
			System.out.println("Welcome to Demo Web Shop");
		}
		else {
			System.out.println("Incorrect Page");
		}
		driver.quit();
	}
	
	@Test
	public void productSearch() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Laptop");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();
		
		WebElement actualPath = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a"));
		String actualText = actualPath.getText();
		String expectedText = "14.1-inch Laptop";
		if(actualText.matches(expectedText)) {
			System.out.println("Product Search is Successful!");
		}
		else {
			System.out.println("Something Went Wrong!");
		}
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
