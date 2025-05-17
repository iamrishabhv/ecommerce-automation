package com.selenium.test.ecommerce_automation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommerce {
	
	@Test //Test Case 1: Open Homepage
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
	
	@Test	//Test Case 2: Search for a Product
	public void searchProduct() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Laptop");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(5000);
		
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
	
	@Test	//Test Case 3: Add a Product to Cart
	public void addToCart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Laptop");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Lenovo IdeaPad Slim 3, Intel Core i5-12450H')]")).click();
		Thread.sleep(5000);
		String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		
		WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
		addToCartBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Added to Cart')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Added to cart')]"));
		
		System.out.println("Product Successfully Added to Cart.");
		
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
