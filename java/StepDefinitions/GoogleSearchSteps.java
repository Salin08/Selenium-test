package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Starting - browser is open");
		
		System.setProperty("webdriver.chrome.driver","/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
		System.out.println("Ending - browser is open");
	}


	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in google search box")
	public void user_enters_a_text_in_google_search_box() {
		
		driver.findElement(By.name("q")).sendKeys("Champions League");
	}

	@And("hits Enter")
	public void hits_Enter() {
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to Search Results page")
	public void user_is_navigated_to_Search_Results_page() {
		driver.getPageSource().contains("Champions League | UEFA Champions League");
		driver.close();
		driver.quit();
	}

}
