package com.selenium.test.ecommerce_automation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkInSync {
	
	@Test
	public void WIS() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		LocalDate today = LocalDate.now();
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plusWeeks(0);
		LocalDate nextFriday = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusWeeks(4);
		LocalDate nextWednesday = today.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).plusWeeks(2);
		
		String Mon = nextMonday.toString();
		String Fri = nextFriday.toString();
		String Wed = nextWednesday.toString();
		
//		Calendar now = Calendar.getInstance();
//		int Day1 = now.get(Calendar.MONDAY);
//		int Day2 = now.get(Calendar.FRIDAY);
		
		//Get URL & Login
		driver.get("https://landisgyr.moveinsync.com/NOIDA/employee.jsp#WorkInSyncDashboard");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")).sendKeys("rishabh.verma@landisgyr.com");
		driver.findElement(By.cssSelector("#idSIButton9")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#i0118")).sendKeys("Montana@#$2106");
		driver.findElement(By.cssSelector("#idSIButton9")).click();
		Thread.sleep(3000);
		
		//Microsoft Authentication
		driver.findElement(By.cssSelector("#idDiv_SAOTCS_Proofs > div:nth-child(1) > div > div > div.table-cell.text-left.content")).click();
		Thread.sleep(20000);
		driver.findElement(By.cssSelector("#idSIButton9")).click();
		Thread.sleep(30000);
		
		//Create Booking
		WebElement bookBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div.body > div > div.bodyContent > mis-employee-web-exp-home > div.emp-web-wrapper > div.exp-head.ng-star-inserted > mis-employee-web-exp-header > div > div.action-wrapper > div > button")));
		bookBtn.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#cdk-overlay-4 > mis-employee-web-exp-quick-actions > div.quick-act-menu > button:nth-child(1)")).click();
		Thread.sleep(2000);
		
		//Select Start Date
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-6\"]/mis-drawer-body/div/mis-employee-web-exp-booking/mis-employee-web-exp-booking-form/div[2]/div/div[2]/form/div[2]/div[1]/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-10\"]/mis-tz-dp/div[2]/div[3]/div[2]/div[9]")).sendKeys(Mon);
		Thread.sleep(2000);
		
		//Select End Date
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-6\"]/mis-drawer-body/div/mis-employee-web-exp-booking/mis-employee-web-exp-booking-form/div[2]/div/div[2]/form/div[2]/div[2]/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-19\"]/mis-tz-dp/div[2]/div[3]/div[2]/div[11]")).sendKeys(Wed);
		Thread.sleep(2000);
		
		//Select Start & End Time
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-20\"]/div[2]/div[2]/cdk-virtual-scroll-viewport/div[1]/div[6]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-21\"]/div[2]/div[2]/cdk-virtual-scroll-viewport/div[1]/div[7]/div")).click();
		Thread.sleep(10000);
		
		//Select Desk
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-6\"]/mis-drawer-body/div/mis-employee-web-exp-booking/mis-employee-web-exp-booking-form/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"header-left-container\"]/mis-dropdown")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-3\"]/div[2]/div[2]/cdk-virtual-scroll-viewport/div[1]/div[4]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"fb57fc81-6e2b-4662-a3fe-62d42b2c1b1d\"]")).click();
		Thread.sleep(5000);
		
		//Confirm
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-4\"]/mis-drawer-body/div/mis-employee-web-exp-booking/mis-employee-web-exp-booking-form/div[2]/div[1]/div[3]/button")).click();
		
	}
	
	

}
