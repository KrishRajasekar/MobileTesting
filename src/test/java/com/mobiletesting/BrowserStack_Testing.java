package com.mobiletesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserStack_Testing {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium:platformName", "Android");
		caps.setCapability("appium:platformVersion", "12");
		caps.setCapability("appium:deviceName", "5da939b1");
		caps.setCapability("appium:automationName", "uiAutomator2");
		caps.setCapability("appium:appPackage", "com.omr_branch");
		caps.setCapability("appium:appActivity", "com.omr_branch.MainActivity");

		URL url = new URL("http://127.0.0.1:4723/");
		AndroidDriver driver = new AndroidDriver(url, caps);
	
//		bs://a1bbffad33f71628b301c78a3246b4907f13426e

		WebElement logoImage = driver
				.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"login_logo_image\"]"));
		boolean displayed = logoImage.isDisplayed();
		System.out.println("Logo is Displayed : " + displayed);

		WebElement appHeader = driver.findElement(By.xpath("//*[contains(@text,'Automation Course')]"));
		System.out.println(appHeader.getText());

		WebElement emailId = driver.findElement(By.xpath("//*[@content-desc=\"Email Address\"]"));
		emailId.sendKeys("rajasekar93446@gmail.com");

		driver.findElement(By.xpath("//*[@resource-id='login_password_input']")).sendKeys("Raja@2709");
		driver.findElement(By.xpath("//*[@text=\"Login\"]")).click();

		String WelcomeMsg = driver.findElement(By.xpath("//*[@resource-id='header_welcome']")).getText();
		System.out.println("Welcome Msg:" + WelcomeMsg);

	}

}
