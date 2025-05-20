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
		
		WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")));
		addToCartBtn.click();			//Worked with Full XPath only
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/div/div/h1")));
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/div/div/h1"));	//Worked with Full XPath
		
		System.out.println("Product Successfully Added to Cart.");
		
		driver.quit();
	}
	
	@Test	//Proceed to Checkout (up to login)
	public void checkoutPage() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Laptop");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Lenovo IdeaPad Slim 3, Intel Core i5-12450H')]")).click();
		Thread.sleep(5000);
		String originalWindow = driver.getWindowHandle();
		for(String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		WebElement addToCrtBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")));
		addToCrtBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/div/div/h1")));
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/div/div/h1"));
		System.out.println("Product Successfully Added to Cart.");
		WebElement prcdToChkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[3]/div/div[1]/form/span[1]/span/span/input")));
		prcdToChkOut.click();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fcheckout%2Fentry%2Fcart%3FisEligibilityLogicDisabled%3D1%26referrer%3Dcart%26ref_%3Dox_sw_proceed%26proceedToCheckout%3D1%26tangoWeblabStatus%3Dtango_enable_unrec_customer%26oldCustomerId%3D0%26pipelineType%3DChewbacca%26isUnrec%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=amazon_checkout_in&openid.mode=checkid_setup&language=en_IN&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
		assertEquals(actualURL, expectedURL, "Page is not correct");
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
