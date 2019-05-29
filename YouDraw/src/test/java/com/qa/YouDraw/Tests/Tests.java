package com.qa.YouDraw.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tests {

	public static WebDriver driver;
	public static String url = "https://www.youidraw.com/apps/painter/";
	
	@BeforeClass
	public static void setup() {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@Test
	public void test1(){
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement canvas = driver.findElement(By.id("catch"));
		
		canvas.getLocation();
		canvas.click();
		
		
		
		
		Actions action = new Actions(driver);
		action.moveByOffset(-250,-150).clickAndHold().moveByOffset(100, 0).release().moveByOffset(-50, 0).clickAndHold().moveByOffset(0, 75).moveByOffset(-35, 0).release().perform();
		
		action.moveByOffset(95, -75).clickAndHold().moveByOffset(50, 0).moveByOffset(0, 75).moveByOffset(-50, 0).moveByOffset(0, -75).release().perform();
		
		action.moveByOffset(115, 0).clickAndHold().moveByOffset(-50, 0).moveByOffset(0, 37).moveByOffset(50, 0).moveByOffset(0, 38).moveByOffset(-50, 0).release().perform();
		
		action.moveByOffset(60, -75).clickAndHold().moveByOffset(0, 75).release().moveByOffset(0, -38).clickAndHold().moveByOffset(50, 0).moveByOffset(0, -37).release().moveByOffset(0, 37).clickAndHold().moveByOffset(0, 38).release().perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
	
	
}
