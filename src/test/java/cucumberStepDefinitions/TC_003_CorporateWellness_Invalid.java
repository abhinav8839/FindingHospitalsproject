package cucumberStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CorporateWellnessPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_003_CorporateWellness_Invalid {
	@Given("the user navigates to health & wellness Plan under For Corporates section")
	public void the_user_navigates_to_health_wellness_plan_under_for_corporates_section() {
		HomePage hp = new HomePage(BaseClass.getDriver());
	   System.out.println("User gets to health and wellness plan.");
	   hp.getForCorporates();
	   hp.getWellnessPlans();
	}

	@When("user enters all the fields with invalid inputs")
	public void user_enters_all_the_fields_with_invalid_inputs() {
		CorporateWellnessPage cw = new CorporateWellnessPage(BaseClass.getDriver());
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		//logger.info("putting in invalid details");
		js.executeScript("window.scrollBy(0, 100)");
		cw.setName();
		cw.setOrganizationName();
		cw.setContactNumber();
		cw.setEmail().sendKeys("test");
		//logger.debug("checking if button is enabled");
		if (!cw.getScheduleButton().isEnabled()) {
			//takeSnapshot(BaseClass.getDriver(), "Invalid Details Form");
			System.out.println("Schedule button is disabled");
		}
		cw.getOrgranizationSize();
		Select select1 = new Select(
				BaseClass.getDriver().findElement(By.xpath("//header[@id='header']//select[@id='organizationSize']")));
		select1.selectByVisibleText("<500");
		cw.getInterestedIn();
		Select select2 = new Select(
				BaseClass.getDriver().findElement(By.xpath("//header[@id='header']//select[@id='interestedIn']")));
		select2.selectByVisibleText("Taking a demo");
		cw.getScheduleButton();
	 
	}

	@Then("Schedule a demo button is disabled and user clicks it but it will not work")
	public void schedule_a_demo_button_is_disabled_and_user_clicks_it_but_it_will_not_work() {
	   System.out.println("Schedule a demo is disabled!!");
	}

	@Then("print test failed in the console and clears all inputs")
	public void print_test_failed_in_the_console_and_clears_all_inputs() {
		System.out.println("Enter a valid email.");
		CorporateWellnessPage cw = new CorporateWellnessPage(BaseClass.getDriver());
		
	}


}
