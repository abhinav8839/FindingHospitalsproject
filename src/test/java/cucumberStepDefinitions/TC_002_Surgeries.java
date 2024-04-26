package cucumberStepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_Surgeries {
	@Given("user navigate to surgeries section")
	public void user_navigate_to_surgeries_section() {
		System.out.println("User is on surgery page");
	    
	}

	@When("scrolls the page")
	public void scrolls_the_page() {
		HomePage hp = new HomePage(BaseClass.getDriver());
		//logger.info("getting surgeries");
		hp.getSurgeries().click();
		
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("window.scrollBy(0, 600)");
	
	}

	@Then("user gets a list of popular surgery and prints it")
	public void user_gets_a_list_of_popular_surgery_and_prints_it() {
		List<WebElement> surgeries = BaseClass.getDriver().findElements(By.xpath("//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div//p"));
		System.out.println("Top surgeries");
		for (WebElement surgery : surgeries) {
			System.out.println(surgery.getText());
		}
	
	}

}
