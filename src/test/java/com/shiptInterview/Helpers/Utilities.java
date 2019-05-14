package com.shiptInterview.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static void waitForElement(final By elementBy) throws Exception {
        waitForElement(elementBy, null);
    }

    public static void waitForElement(final By elementBy, Integer waitTimeInSeconds) throws Exception {
        try {
            if (waitTimeInSeconds == null) waitTimeInSeconds = 5;
            new WebDriverWait(TestContext.getDriver(), waitTimeInSeconds).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    try {
                        WebElement e = TestContext.getDriver().findElement(elementBy);
                        return e.isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
        } catch (Exception e) {
            throw new Exception("Unable to wait for element with By: [" + elementBy.toString() + "]\n" + e.getMessage());
        }
    }

}
