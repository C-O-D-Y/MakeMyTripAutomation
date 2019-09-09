package com.atmecs.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.atmecs.constants.RoundTrip;
import com.atmecs.dataProvider.CityDataProvider;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.testBase.TestBase;

public class Book_Ticket_RoundTrip extends TestBase {
	RoundTrip roundtrip = new RoundTrip();

	@Test(priority = 1, dataProvider = "cityinput", dataProviderClass = CityDataProvider.class)
	public void homePage(String fromCity, String toCity) {

		CommonUtility.clickElement(driver, roundtrip.getLoc_oneway_rbtn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_from_box());
		System.out.println(" " + CommonUtility.isDisplayed(driver, roundtrip.getLoc_from_search()));
		System.out.println(" " + CommonUtility.isElementVisible(driver, roundtrip.getLoc_from_search()));
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_from_inputtext(), 2, fromCity);
		
		CommonUtility.clickElement(driver, roundtrip.getLoc_from_search());
		System.out.println(CommonUtility.isDisplayed(driver, roundtrip.getLoc_to_search()));
		System.out.println(CommonUtility.isElementVisible(driver, roundtrip.getLoc_to_search()));
		System.out.println("1st");
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_to_inputtext(), 2, toCity);
		
		System.out.println("2nd");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		CommonUtility.clickElement(driver, roundtrip.getLoc_to_search());
		System.out.println("3rd");
		CommonUtility.clickElement(driver, roundtrip.getLoc_departure_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_departure_date_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_return_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_nextmont_btn());
		System.out.println("4th");
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_return_date_btn());

		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_class_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_adults_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_children_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_infants_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_choose_travel_class_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_apply_btn());
		driver.switchTo().frame("webpush-bubble");
		driver.findElement(By.xpath("//button[text()=\"I'll do this later\"]")).click();
		CommonUtility.clickElement(driver, roundtrip.getLoc_search_btn());
	}

	@Test(priority = 2)
	public void selectFlightAndReview() {
		
		boolean visibility = CommonUtility.isElementVisible(driver, roundtrip.getLoc_departuresortby_dpdn());
		System.out.println(visibility);
		if (visibility == true) {
			CommonUtility.clickElement(driver, roundtrip.getLoc_departuresortby_dpdn());
		}
		CommonUtility.clickElement(driver, roundtrip.getLoc_departuresortby_option_btn());

		boolean visibility1 = CommonUtility.isElementVisible(driver, roundtrip.getLoc_returnsortby_dpdn());
		System.out.println(visibility1);
		if (visibility1 == true) {
			CommonUtility.clickElement(driver, roundtrip.getLoc_returnsortby_dpdn());
		}
		CommonUtility.clickElement(driver, roundtrip.getLoc_returnsortby_option_btn());

		CommonUtility.clickElement(driver, roundtrip.getLoc_select_departure_flight_rbtn());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebElement Element = driver
				.findElement(By.xpath("(//span[@class='splitVw-inner'])[20]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);

		CommonUtility.clickElement(driver, roundtrip.getLoc_select_return_flight_rbtn());
//		CommonUtility.clickElement(driver, roundtrip.getLoc_booknow_rtrip_btn());
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		// click some link that opens a new window
		driver.findElement(By.xpath(roundtrip.getLoc_booknow_rtrip_btn())).click();

		// switch focus of WebDriver to the next found window handle
		// (that's your newly opened window)
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// code to do something on new window
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, 5000)");
		CommonUtility.clickElement(driver, roundtrip.getLoc_continue_btn());
	}

	@Test(priority = 3, dataProvider = "testinput", dataProviderClass = TestDataProvider.class)
	public void travellersDetails(String firstname, String lastname, String firstname1, String lastname1, String mob_no,
			String email) {

		CommonUtility.clickElement(driver, roundtrip.getLoc_add_adult_btn());
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_firstname_btn(), 2, firstname);
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_lastname_btn(), 2, lastname);
		CommonUtility.clickElement(driver, roundtrip.getLoc_f_gender_rbtn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_add_adult_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_cursorup_btn());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Element not found ");
		}

		CommonUtility.clickAndSendText(driver, "(" + (roundtrip.getLoc_firstname_btn()) + ")[2]", 2, firstname1);
		CommonUtility.clickAndSendText(driver, "(" + (roundtrip.getLoc_lastname_btn()) + ")[2]", 2, lastname1);
		CommonUtility.clickElement(driver, "(" + (roundtrip.getLoc_f_gender_rbtn()) + ")[2]");

		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_contact_info_mob_no_text(), 2, mob_no);
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_contact_info_email_text(), 2, email);
		CommonUtility.clickElement(driver, roundtrip.getLoc_flight_details_continue_btn());
	}

	@AfterSuite
	public void end() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	}
}
