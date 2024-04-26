package cucumberStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CorporateWellnessPage;
import testBase.BaseClass;

public class TC_004_CorporateWellness_Valid {
	@Given("user enters valid email.")
	public void user_enters_valid_email() {
		System.out.println("user is entering valid email.");
	}
	@When("user enters all the fields with valid inputs")
	public void user_enters_all_the_fields_with_valid_inputs() {
	  CorporateWellnessPage cw = new CorporateWellnessPage(BaseClass.getDriver());
	  System.out.println("User enters valid email Id");
	  cw.setEmail().click();
	  cw.setEmail().clear();
	  cw.setEmail().sendKeys("test@test.com");
	}

	@Then("Schedule a demo button is enabled and user clicks it")
	public void schedule_a_demo_button_is_enabled_and_user_clicks_it() throws InterruptedException {
		CorporateWellnessPage cw = new CorporateWellnessPage(BaseClass.getDriver());
		if (cw.getScheduleButton().isEnabled()) {
			System.out.println("Schedule button is enabled!");
		}
		cw.getScheduleButton().click();
		Thread.sleep(10000);
	}

	@Then("Thankyou message is printed.")
	public void thankyou_message_is_printed() {
	   System.out.println("Thankyou message displayed");
	}
}
