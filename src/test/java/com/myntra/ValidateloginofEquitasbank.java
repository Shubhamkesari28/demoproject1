package com.myntra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateloginofEquitasbank {
	
	WebDriver driver;
	@BeforeTest
	public void beforelogin() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://equinox.equitasbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//	driver.get("https://equinox.equitasbank.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='login-redirect-path']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='modal_login']/div[1]/div[1]/div[1]/div[1]/form[1]/ul[1]/li[2]/a[1]")).click();
		
	}
	@AfterTest
	public void AfterTest() throws InterruptedException {
		Thread.sleep(3000);
	driver.quit();
	
		
	}
	@Test(priority=2)
	public void validatewithvalidcredential() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		try {
			String exp= "https://equinox.equitasbank.com/users/dashboard";
			String Act =driver.getCurrentUrl();
			if(exp.equalsIgnoreCase(Act)) {
				System.out.println("Successfully Login");
			}else {
				System.out.println("Please enter Valid credential for Login");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void validatewithInvalidcredential() throws InterruptedException{
		 
		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys("6393920");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@12340");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		try {
			String Act1= driver.findElement(By.xpath("//form[@id='login_form']//div[@id='flash_msg']")).getText();
			String exp1= "Customer Does Not Exists";	
			if(exp1.equalsIgnoreCase(Act1)) {
			System.out.println("Please Register your customer first");
		}else {
			System.out.println("Successfully Login");
		}
	}catch(Exception Throw) {
		Throw.printStackTrace();
	}
}

	}
	