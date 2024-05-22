package com.mobiletesting;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OmrBranch extends Baseclass_MobileTesting {

	public static void main(String[] args) throws Exception {

		MobBrowserLaunch();
		implicitWait(10);

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

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select State\"]")).click();
		driver.findElement(By.xpath("//*[@text='Karnataka']")).click();

		driver.findElement(By.xpath("//*[@text='Select City']")).click();
		driver.findElement(By.xpath("//*[@text='Bengaluru']")).click();

		driver.findElement(By.xpath("//*[@text='Select Room Type']")).click();
		driver.findElement(By.xpath("//*[@text='Standard']")).click();

		driver.findElement(By.xpath("//*[@resource-id=\"search_select_checkin\"]")).click();
		driver.findElement(By.xpath("//*[@resource-id=\"android:id/button1\"]")).click();

		driver.findElement(By.xpath("//*[@resource-id='search_select_checkout']")).click();
		driver.findElement(By.xpath("//*[@resource-id=\"android:id/button1\"]")).click();

		driver.findElement(By.xpath("//*[@text='No. Of Room']")).click();
		driver.findElement(By.xpath("//*[@text='1-One']")).click();

		driver.findElement(By.xpath("//*[@text=\"No. Of Adults\"]")).click();
		driver.findElement(By.xpath("//*[@text=\"1-One\"]")).click();

		driver.findElement(By.xpath("//*[@resource-id=\"search_no_of_children\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@text=\"Search\"]")).click();

		SwipDown();

		ScroolToElement("//*[@resource-id='hotel_continue_button']");
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		String BookHotelMsg = driver.findElement(By.xpath("//*[@resource-id='book_hotel_text']")).getText();
		System.out.println("BookHotelMsg :" + BookHotelMsg);
		SwipDown();

		driver.findElement(By.xpath("//*[@text='Myself']")).click();
		driver.findElement(By.xpath("//*[@resource-id='book_hotel_salutation']")).click();
		driver.findElement(By.xpath("//*[@text='Mr.']")).click();
		driver.findElement(By.xpath("//*[@resource-id='book_hotel_first_name']")).sendKeys("Rajasekar");

		SwipDown();
		driver.findElement(By.xpath("//*[@resource-id='book_hotel_last_name']")).sendKeys("Sekar");
		driver.findElement(By.xpath("//*[@resource-id='book_hotel_mobile_no']")).sendKeys("8760836156");
		driver.findElement(By.xpath("//*[@resource-id='book_hotel_email']")).sendKeys("rajasekar93446@gmail.com");
		
		driver.findElement(By.xpath("//*[@resource-id=\"book_hotel_enter_gst\"]/android.widget.ImageView")).click();
		SwipDown();
		driver.findElement(By.xpath("//*[@content-desc=\"book_hotel_registration\"]")).sendKeys("9043592058");
		driver.findElement(By.xpath("//*[@content-desc=\"book_hotel_company_name\"]")).sendKeys("Greens Tech OMR Branch");
		driver.findElement(By.xpath("//*[@content-desc=\"book_hotel_company_address\"]")).sendKeys("Thoraipakkam");
		
		driver.findElement(By.xpath("//*[@text='Next']")).click();
		driver.findElement(By.xpath("//*[@resource-id='filter_option_late']")).click();
		driver.findElement(By.xpath("//*[@content-desc=\"TextInput\"]")).sendKeys("Good");
		driver.findElement(By.xpath("//*[@text='Next']")).click();
		
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement ProgressBar = driver.findElement(By.xpath("//android.widget.ProgressBar"));

		driverWait.until(ExpectedConditions.invisibilityOf(ProgressBar));

		driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@text='UPI']"))));

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Credit/Debit/ATM Card\"]")).click();

		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles);
		driver.context("WEBVIEW_com.omr_branch");

		WebElement ddnCardType = driver.findElement(By.xpath("//select[@name='payment_type']"));
		SelectByVisisbilityText(ddnCardType, "Debit Card");
		SwipDown();

		WebElement ddnCard = driver.findElement(By.xpath("//select[@name='card_type']"));
		SelectByVisisbilityText(ddnCard, "Visa");

		driver.findElement(By.xpath("//input[@name='card_no']")).sendKeys("5555555555552222");
		WebElement txtCardName = driver.findElement(By.xpath("//input[@name='card_name']"));
		txtCardName.sendKeys("DharmaPrakash");
		
		WebElement ddnMonth = driver.findElement(By.xpath("//select[@id='card_month']"));
		SelectByVisisbilityText(ddnMonth, "December");

//		WebElement ddnYear = driver.findElement(By.xpath("//select[@id='card_year']"));
//		SelectByVisisbilityText(ddnYear, "2024");
		
		driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys("547");
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
//		driver.context("NATIVE_App");
		
		String OrderId = driver.findElement(By.xpath("//android.widget.TextView[@text=\"#LIZKW43555 Booking is Confirmed\"]")).getText();
		System.out.println("PlaceOrder:"+OrderId);
		
		WebElement HotelName = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Hotel Royal Orchid Resort & Convention Centre is booked!\"]"));
		String text = HotelName.getText();
		System.out.println("OrderHotelName :"+text);
		
	}

}
