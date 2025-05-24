package com.selenium.test.ecommerce_automation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		WebElement countryDD = driver.findElement(By.xpath("//*[@id=\"CountryId\"]"));
		countryDD.sendKeys("India");
		countryDD.click();
		driver.findElement(By.xpath("//*[@id=\"ZipPostalCode\"]")).sendKeys("110074");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[4]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		Thread.sleep(3000);
		
		//Sign In Page Assert
		String actualSignInPageURL = driver.getCurrentUrl();
		String expectedSignInPageURL = "https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart";
		if(actualSignInPageURL.equalsIgnoreCase(expectedSignInPageURL)) {
			System.out.println("Welcome, Please Sign In!");
		}
		else {
			System.out.println("Something Went Wrong!!");
		}
		
		//Registering a New User
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("John");
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Doe");
		driver.findElement(By.cssSelector("#Email")).sendKeys("John.Doe@ymm.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("Ert@#$2104");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Ert@#$2104");
		driver.findElement(By.cssSelector("#register-button")).click();
		WebElement bodyText = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body"));
		String actualRegisterText = bodyText.getText();
		String expectedRegisterText = "Your registration completed";
		assertEquals(actualRegisterText, expectedRegisterText, "Something Went Wrong!!");
	}
	
	//Update Password for a Existing User
	@Test
	public void updatePW() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-title")));
		
		//Enter the Credentials
		driver.findElement(By.cssSelector("#Email")).sendKeys("John.Doe@reddif.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#Password")).sendKeys("John@#$1234");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input")).click();
		
		//Login Verification
		WebElement getUN = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
		String actualUN = getUN.getText();
		String expectedUN = "John.Doe@reddif.com";
		if(actualUN.equalsIgnoreCase(expectedUN)) {
			System.out.printf("Login Successful! Welcome %s", actualUN);
		}
		else {
			System.out.printf("Login Unsuccessful!!");
		}
		
		//Password Change
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.side-2 > div > div.listbox > ul > li:nth-child(7) > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#OldPassword")).sendKeys("John@#$1234");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#NewPassword")).sendKeys("John@#$2345");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ConfirmNewPassword")).sendKeys("John@#$2345");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > form > div > div.page-body > div.buttons > input")).click();
		Thread.sleep(2000);
		
		//PW Change Verification
		WebElement PWChngConfrm = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > form > div > div.page-body > div.result"));
		String actualPWChngText = PWChngConfrm.getText();
		String expectedPWChngText = "Password was changed";
		if(actualPWChngText.equalsIgnoreCase(expectedPWChngText)) {
			System.out.println("Password Change Successful!");
		}
		else {
			System.out.println("Password Change Unsuccessful!!");
		}
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
