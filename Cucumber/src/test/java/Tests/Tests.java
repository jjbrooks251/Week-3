package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tests {

	public static String searchTerm;

	@Before
	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Constants.driver = new ChromeDriver();

	}

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		Constants.driver.manage().window().maximize();
		Constants.driver.get(Constants.url);
		assertEquals("http://www.practiceselenium.com/welcome.html", Constants.url);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {

		WebElement menu = Constants.driver
				.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));

		menu.click();

		WebElement menuCheck = Constants.driver
				.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
		assertEquals("menu", menuCheck.getText().toLowerCase());
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		WebElement green = Constants.driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
		WebElement red = Constants.driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"));
		WebElement oolong = Constants.driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"));

		assertEquals("green tea", green.getText().toLowerCase());
		assertEquals("red tea", red.getText().toLowerCase());
		assertEquals("oolong tea", oolong.getText().toLowerCase());

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {

		WebElement menu = Constants.driver
				.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));

		menu.click();

		WebElement checkOut = Constants.driver
				.findElement(By.xpath("//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span"));

		checkOut.click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {

		WebElement details = Constants.driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span"));
		assertEquals("enter your billing information", details.getText().toLowerCase());
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Throwable {
		Constants.driver.manage().window().maximize();
		Constants.driver.get(arg1);
		assertEquals("https://www.bing.com", arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Actions action = new Actions(Constants.driver);
		searchTerm = arg1;
		WebElement bar = Constants.driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		bar.click();

		WebElement search = Constants.driver.findElement(By.id("sb_form_go"));

		// action.sendKeys(arg1).perform();
		// Thread.sleep(200);
		// action.sendKeys(Keys.ENTER).perform();

		action.sendKeys(arg1).click(search).perform();

		WebElement text = Constants.driver.findElement(By.xpath("//*[@id=\"b_header\"]/nav/ul/li[1]/a"));

		String s = text.getText();

		assertEquals("all", s.toLowerCase());

	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {

		// File src=
		// ((TakesScreenshot)Constants.driver).getScreenshotAs(OutputType.FILE);
		//
		// FileUtils.copyFile(src, )

		WebElement search = Constants.driver.findElement(By.xpath("//*[@id=\"b_content\"]"));

		String t = search.getText();

		assertTrue(t.contains(searchTerm));

	}

	@After
	public static void close() {
		Constants.driver.quit();
	}

}
