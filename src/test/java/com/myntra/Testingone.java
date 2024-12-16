package com.myntra;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testingone {
	WebDriver driver;
	
	@Test
	public void login() throws InterruptedException, IOException {
	driver = new ChromeDriver();
	driver.get("https://equinox.equitasbank.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='login-redirect-path']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@href=\"#logintab1\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"customer_id\"]")).sendKeys("639392");
	driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Shubham@1234");
	driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	Thread.sleep(3000);
	String acturl=driver.getCurrentUrl();
	String Expurl = "https://equinox.equitasbank.com/users/dashboard";
	if(Expurl.equalsIgnoreCase(acturl)) {
		System.out.println("Login Succssfully");
	}else {
		System.out.println("Plz try again");
	}
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File targ = new File(".//Aman//homepage4.png");
	FileUtils.copyFile(src, targ);

	
	
	}

}
