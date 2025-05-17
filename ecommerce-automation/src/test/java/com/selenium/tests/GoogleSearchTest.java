package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	@Test
	public void testGoogleSearch() {
		WebDriverManager.chromiumdriver().setup();	//System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe"); This is another way of using the Chrome Driver in the code.
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Page Title is: " + driver.getTitle());
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
