package com.shiptInterview.StepDefinitions;

import com.shiptInterview.Helpers.*;
import com.shiptInterview.Pages.Login;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	private String LOGIN_URL = "https://shipt.com/login";

	@When("^I go to the login page$")
	public void go_to_login_page() throws Exception {
		TestContext.getDriver().get(LOGIN_URL);
		Login.waitForPage();
	}

	@And("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login(String email, String password) {
		Login.loginUser(email, password);
	}

	@Then("^the invalid login message should have text \"([^\"]*)\"$")
	public void check_invalid_login_message(String message) throws Exception {
		Login.checkInvalidLoginMessage(message);
	}

}
