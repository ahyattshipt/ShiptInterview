package com.shiptInterview.StepDefinitions;

import com.shiptInterview.Helpers.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class GlobalSteps {

	@Before
	public void before() {
		TestContext.resetTestContext();
	}

	@Given("^I am in session \"([^\"]*)\"$")
	public void in_session(String session) {
		TestContext.getDriver(session);
	}

	@After
	public void tearDown() {
		TestContext.closeAllSessions();
	}

}
