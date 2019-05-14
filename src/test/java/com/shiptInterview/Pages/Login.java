package com.shiptInterview.Pages;

import com.shiptInterview.Helpers.TestContext;
import com.shiptInterview.Helpers.Utilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    private static final By EMAIL_FIELD = By.cssSelector("[data-test='LoginForm-emailField']");
    private static final By PASSWORD_FIELD = By.cssSelector("[data-test='LoginForm-passwordField']");
    private static final By LOGIN_BUTTON = By.cssSelector("[data-test='LoginForm-log-in-button']");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='LoginForm-error']");

    public static void waitForPage() throws Exception {
        //wait for expected fields to render
        Utilities.waitForElement(EMAIL_FIELD);
        Utilities.waitForElement(PASSWORD_FIELD);
        Utilities.waitForElement(LOGIN_BUTTON);
    }

    public static void loginUser(String email, String password) {
        //enter email
        WebElement emailField = TestContext.getDriver().findElement(EMAIL_FIELD);
        emailField.sendKeys(email);
        //enter password
        WebElement passwordField = TestContext.getDriver().findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
        //click login
        WebElement loginButton = TestContext.getDriver().findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    public static void checkInvalidLoginMessage(String expectedMessage) throws Exception {
        Utilities.waitForElement(ERROR_MESSAGE);
        WebElement errorMessage = TestContext.getDriver().findElement(ERROR_MESSAGE);
        Assert.assertEquals(expectedMessage, errorMessage.getText());
    }

}