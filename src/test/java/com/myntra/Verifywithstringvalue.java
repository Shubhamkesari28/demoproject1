package com.myntra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

				 

public class Verifywithstringvalue {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//Open Myntra url
		driver.get("https://www.myntra.com/");
		Thread.sleep(5000);
		//click on profile
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		//click on signup
		driver.findElement(By.xpath("//a[normalize-space()='login / Signup']")).click();
		
	}
	
	@AfterTest
	public void AfterTest() {
		
		driver.quit();
	}
	@Test(priority =1)
	public void signup() throws InterruptedException {
		//Enter String Value
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("Shubham");
		//click on continue
		driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).click();
		String ExpectedWarning =driver.findElement(By.xpath("//div[@class='errorContainer']")).getText();
		String ActualWarning ="Please enter a valid mobile number (10 digits)";
		//user Assert to handle warning Message 
		Assert.assertTrue(ActualWarning.contains(ExpectedWarning),"exxpected waarning message not found");
	}
	@Test(priority =3)
	public void VerifywithLessThenTenNumber() throws InterruptedException {
		//Enter String Value
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("6393920");
		//click on continue
		driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).click();
		String ExpectedWarning =driver.findElement(By.xpath("//div[@class='errorContainer']")).getText();
		String ActualWarning ="Please enter a valid mobile number (10 digits)";
		//user Assert to handle warning Message 
		Assert.assertTrue(ActualWarning.contains(ExpectedWarning),"exxpected waarning message not found");
	
	}
	@Test(priority =2)
	public void VerifyWithValidNumber() throws InterruptedException {
		//please Enter your valid PhoneNumber 
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("9610281818");
		//click on continue
		driver.findElement(By.xpath("//div[contains(text(),'CONTINUE')]")).click();
		Thread.sleep(5000);		//Enter OTP Manually
		String ExpectedWarning =driver.findElement(By.xpath("//div[contains(text(),'Welcome to Myntra')]")).getText();
		String ActualWarning ="Welcome to Myntra";
		//user Assert to handle warning Message 
		Assert.assertTrue(ActualWarning.contains(ExpectedWarning),"exxpected waarning message not found");
	
		
	}

}
