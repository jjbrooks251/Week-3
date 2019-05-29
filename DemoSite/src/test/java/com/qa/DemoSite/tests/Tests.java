package com.qa.DemoSite.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tests {

	public static WebDriver driver;
	public static String url = "http://thedemosite.co.uk/";
	
	@BeforeClass
	public static void setup() {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@Ignore
	public void test1(){
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement user = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		user.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement name = driver.findElement(By.name("username"));
		name.sendKeys("class");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("password");
		password.submit();
		
		WebElement login = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement name2 = driver.findElement(By.name("username"));
		
		name2.sendKeys("class");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement password2 = driver.findElement(By.name("password"));
		password2.sendKeys("password");


		WebElement submit = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		submit.click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Ignore
	@Test
	public void shopping() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		women.click();
		
		WebElement tops = driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a"));
		tops.click();
		
		WebElement blouse = driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[2]/a"));
		blouse.click();
		
		WebElement check = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
		
		
		assertEquals("blouse", check.getText().toLowerCase());
		
		
//		WebElement hover = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div"));
//		
//		WebElement colour = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div"));
//		
//	
//		
//		colour.click();
		
//		WebElement size = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
//		size.click();
		
//		WebElement cart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
//		cart.click();
		
		
		
		
	}
	
	
	@Test
	public void hotel() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		Actions action = new Actions(driver);
		
		WebElement cIn = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		cIn.click();
		Thread.sleep(200);
		
		cIn.sendKeys("23");
		
		WebElement cOut = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		cOut.click();
		Thread.sleep(200);
		cOut.sendKeys("26");
		
		WebElement fSearch = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));
		Thread.sleep(200);
		fSearch.click();
		
		Thread.sleep(300);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(300);
		
		WebElement page = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[2]/a"));
		page.click();
		
		Thread.sleep(300);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(300);
		
		WebElement page2 = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[3]/a"));
		page2.click();
		
		WebElement hotelSelect = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[3]/td/div[3]/a/button"));
		hotelSelect.click();
		
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(300);
		
		WebElement rOut = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input"));
		rOut.click();
		Thread.sleep(300);
		
		WebElement date = driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/tbody/tr[5]/td[6]"));
		date.click();
		Thread.sleep(300);
		
		
		
		
//		WebElement people = driver.findElement(By.name("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input"));
//		people.click();
//		Thread.sleep(500);
//		action.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();;
		Thread.sleep(10000);
		
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
	
	
}
