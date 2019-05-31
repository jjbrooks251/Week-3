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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests {

	public static WebDriver driver;
	public static String url = "http://thedemosite.co.uk/";

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Ignore
	public void test1() {
		driver.manage().window().maximize();
		driver.get(url);

		WebElement user = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
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

		WebElement login = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
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

		WebElement submit = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
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

		// WebElement hover =
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div"));
		//
		// WebElement colour =
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div"));
		//
		//
		//
		// colour.click();

		// WebElement size = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
		// size.click();

		// WebElement cart =
		// driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		// cart.click();

	}

	@Test
	public void hotel() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		Actions action = new Actions(driver);

		WebElement cIn = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dpd1\"]/div/input")));
		cIn.click();
		cIn.sendKeys("23");

		WebElement cOut = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dpd2\"]/div/input")));
		cOut.click();

		cOut.sendKeys("26");

		WebElement fSearch = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button")));

		fSearch.click();

		Thread.sleep(200);

		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement page = (new WebDriverWait(driver, 100)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[2]/a")));
		page.click();

		Thread.sleep(200);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement page2 = (new WebDriverWait(driver, 100)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[3]/a")));
		page2.click();

		WebElement hotelSelect = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[3]/td/div[3]/a/button")));
		hotelSelect.click();

		Thread.sleep(200);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement rOut = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input")));
		rOut.click();
		Thread.sleep(300);

		WebElement date = (new WebDriverWait(driver, 100)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div[13]/div[1]/table/tbody/tr[5]/td[6]")));
		date.click();

		WebElement people = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input")));
		people.click();

		action.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		;

		WebElement modify = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[5]/input[3]")));
		modify.click();

		Thread.sleep(200);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement room = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div")));
		room.click();

		Thread.sleep(200);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement book = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ROOMS\"]/div/button")));
		book.click();

		WebElement details = (new WebDriverWait(driver, 100)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"guestform\"]/div[1]/div[2]/input")));
		details.click();

		action.sendKeys("John", Keys.TAB, "Doe", Keys.TAB, "trail@tab.com", Keys.TAB, "trail@tab.com", Keys.TAB,
				"07896321546", Keys.TAB, "This road", Keys.TAB, "United Kingdom", Keys.ENTER, Keys.PAGE_DOWN).perform();

		WebElement confirm = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"body-section\"]/div/div/div[1]/div/div[1]/div[2]/div[4]/button")));
		confirm.click();

		action.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,
				Keys.TAB, Keys.ENTER).perform();
		;

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// WebElement reserve =
		// driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]/tbody/tr[1]/td/div/b"));
		//
		// assertEquals("reserved",reserve.getText().toLowerCase());

	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

}
