package com.fullstack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest {
	WebDriver driver;
	
	@BeforeSuite
	@Parameters("browsername")
	public void setup(String browsername) {
		System.out.println(browsername+ " confuration start");
		if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}else {
			System.out.println("browser could not be determined");
			System.exit(0);
		}
	}
	
	@AfterSuite
	public void close() {
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void homepage() {
		driver.get("https://testautomasi.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(true);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@Parameters({"username", "password"})
	public void login(String un, String pw) {
		// Log In/Register As Student
		driver.findElement(By.linkText("Log In/Register As Student")).click();
		// wait for page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pw);
		System.out.println("Entered "+un+" and "+pw);
		
//		driver.findElement(By.linkText("Login")).click();
		Assert.assertTrue(true);
	}

}
