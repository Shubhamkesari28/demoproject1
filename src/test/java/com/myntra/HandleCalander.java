package com.myntra;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleCalander {
	String day;
	
	WebDriver driver;	
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://equinox.equitasbank.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='login-redirect-path']")).click();
		Thread.sleep(3000);
		//click on signup
		driver.findElement(By.xpath("//body/div[@id='modal_login']/div[1]/div[1]/div[1]/div[1]/form[1]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Flight & Hotel')]")).click();
//		  WebElement currentDay = driver.findElement(By.xpath("//td[text()='" + day + "']"));
//	        currentDay.click();
		
		driver.findElement(By.xpath("//input[@id='dp1']")).click();
		Thread.sleep(3000);
		  LocalDate targetDate = LocalDate.now().plusDays(30);
		    DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");  // Day format
		    String targetDay = targetDate.format(dayFormatter);
		    System.out.println("Current Date: " + targetDay);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//body[1]/div[6]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
		 driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),"+targetDay+")]")).click();
		 driver.findElement(By.xpath("//input[@value='Search Flight']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//label[contains(text(),'Direct Flight')]")).click();
		 driver.findElement(By.xpath("//label[contains(text(),'SpiceJet')]")).click();
		 driver.findElement(By.xpath("//input[@id='flight_filters_button']")).click();
		 driver.findElement(By.xpath("//div[@id='details_left_443']//span[@class='checkmark']")).click();
		
		
	}

}
