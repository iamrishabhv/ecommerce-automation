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
	
	@Test
	public void addToCart() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Laptop");
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.search-box > form > input.button-1.search-box-button")).click();
		Thread.sleep(1000);
		
		//Assert 1
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://demowebshop.tricentis.com/search?q=Laptop";
		if(actualURL.equals(expectedURL)) {
			System.out.println("Product Search Successful!");
		}
		else {
			System.out.println("URL does not match!!");
		}
		
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[1]/a/img")).click();
		Thread.sleep(2000);
		WebElement actualTextStore = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[1]/ul/li[4]/strong"));
		
		
		//Assert 2
		String actualText = actualTextStore.getText();
		String expectedText = "14.1-inch Laptop";
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Correct Product Selected!");
		}
		else {
			System.out.println("Incorrect Product!!");
		}
		
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-31\"]")).click();
		Thread.sleep(1000);
		WebElement addToCrtBtn = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p"));
		
		//Assert 3
		String PrdctAddToCrt = addToCrtBtn.getText();
		String expectedTextPrdct = "The product has been added to your shopping cart";
		if(PrdctAddToCrt.equalsIgnoreCase(expectedTextPrdct)) {
			System.out.println("Product Added to Cart Successfully!");
		}
		else {
			System.out.println("Something Went Wrong!!");
		}
		
		driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p/a")).click();
		String actualCartURL = driver.getCurrentUrl();
		String expectedCartURL = "https://demowebshop.tricentis.com/cart";
		if(actualCartURL.matches(expectedCartURL)) {
			System.out.println("Welcome to Checkout Page!");
		}
		else {
			System.out.println("Something Went Wrong!!");
		}
		
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
