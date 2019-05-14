package com.shiptInterview.Helpers;

import org.openqa.selenium.WebDriver;

public class UserSession {

    private WebDriver driver;

    public UserSession(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
