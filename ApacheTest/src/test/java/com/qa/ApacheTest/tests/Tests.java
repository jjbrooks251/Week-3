package com.qa.ApacheTest.tests;



import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Resources.Constants;



public class Tests {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@Test
	public void test1(){
				
		FileInputStream file = null;
		
		try {
			file = new FileInputStream (Constants.Path_TestData + Constants.File_TestData);
		} catch (FileNotFoundException e) {}
			
		
		XSSFWorkbook workbook = null;
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {}
		
		
		
		driver.manage().window().maximize();
		driver.get(Constants.url);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell use = sheet.getRow(1).getCell(0);
		XSSFCell login = sheet.getRow(1).getCell(1);
		
		Constants.username = use.getStringCellValue();
		Constants.pass = login.getStringCellValue();
		
		WebElement user = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		user.click();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement name = driver.findElement(By.name("username"));
		name.sendKeys(Constants.username);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(Constants.pass);
		password.submit();
		
	
		WebElement bigCheck = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote"));
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//	assertEquals( , );
//		
		WebElement login2 = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login2.click();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement name2 = driver.findElement(By.name("username"));
		
		name2.sendKeys(Constants.username);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		WebElement password2 = driver.findElement(By.name("password"));
		password2.sendKeys(Constants.pass);


		WebElement submit = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		submit.click();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement check = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**successful login**", check.getText().toLowerCase());
		
		try {
			FileOutputStream out = new FileOutputStream(new File(Constants.pathToFile + Constants.nameOfFile));
			workbook.write(out);
			out.close();
			System.out.println("File saved without issue");
		} catch (IOException e) {System.out.println("error");};
		
		
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
