package com.myntra;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class browserincognito {
	@Test
	public static void chrome() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://equinox.equitasbank.com/");
		String tab1 = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://equinox.equitasbank.com/");
		String tab2 = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://equinox.equitasbank.com/");
		String tab3 =driver.getWindowHandle();
		Set<String> tabs =driver.getWindowHandles();
		Iterator<String> iterator=tabs.iterator();
		
		while(iterator.hasNext()) {
			driver.switchTo().window(tab1);
			Thread.sleep(3000);
			driver.quit();
		}
		
	}

}
