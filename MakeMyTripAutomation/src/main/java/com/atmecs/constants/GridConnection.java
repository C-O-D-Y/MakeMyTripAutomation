package com.atmecs.constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridConnection {
	static WebDriver driver;

	public static WebDriver getConnection() {
		String nodeurl = "http://55.55.53.77:4444/wd/hub";

		DesiredCapabilities capability = new DesiredCapabilities();
		URL url1 = null;
		try {
			url1 = new URL(nodeurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(url1, capability);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}
}