package com.shiptInterview.Helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class TestContext {

	private static HashMap<String, UserSession> sessionPool = new HashMap<>();
	public static String currentSession = "";

	public static void resetTestContext() {
		sessionPool = new HashMap<>();
		currentSession = "";
	}

    public static WebDriver getDriver() {
		return getDriver(currentSession);
	}

	public static WebDriver getDriver(String sessionKey) {
		WebDriver currentDriver;

		if (sessionPool.containsKey(sessionKey)) currentDriver = sessionPool.get(sessionKey).getDriver();
		else currentDriver = createChromeDriverInstance(sessionKey);

		currentSession = sessionKey;
		return currentDriver;
	}

	private static WebDriver createChromeDriverInstance(String sessionKey) {
		WebDriver currentDriver;

		System.setProperty("webdriver.chrome.driver", getDriverPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("useAutomationExtension", false);

		currentDriver = new ChromeDriver(options);
		currentDriver.manage().deleteAllCookies();
		currentDriver.manage().window().setSize(new Dimension(1900,1200));
		sessionPool.put(sessionKey, new UserSession(currentDriver));
		currentDriver.get("http://google.com");

		return currentDriver;
	}

	private static String getDriverPath() {
		String driverPath = TestContext.class.getResource("/chromedriver").getPath();

		File driver = new File(driverPath);
		if (!driver.canExecute()) {
			driver.setExecutable(true);
		}

		return driverPath;
	}

	public static void closeAllSessions() {
		for (String session : sessionPool.keySet()) {
			sessionPool.get(session).getDriver().quit();
		}
		sessionPool = new HashMap<>();
	}

}
