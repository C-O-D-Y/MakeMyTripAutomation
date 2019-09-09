package com.atmecs.testScripts;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.atmecs.constants.OneWayTrip;
import com.atmecs.dataProvider.CityDataProvider;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.logReports.LogReport;
import com.atmecs.testBase.TestBase;

public class Book_OneWay_Ticket extends TestBase {
	static OneWayTrip one_way_trip = new OneWayTrip();
	LogReport log = new LogReport();

	@Test(priority = 1, dataProvider = "cityinput", dataProviderClass = CityDataProvider.class)
	public void homePage(String fromCity, String toCity) throws InterruptedException {

		BasicConfigurator.configure();
		logger = extent.startTest("Book_OneWay_Ticket");
		log.info("Starting the homepage testing");
		CommonUtility.clickElement(driver, one_way_trip.getLoc_oneway_rbtn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_from_box());
		System.out.println(" " + CommonUtility.isDisplayed(driver, one_way_trip.getLoc_from_search()));
		System.out.println(" " + CommonUtility.isElementVisible(driver, one_way_trip.getLoc_from_search()));
		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_from_inputtext(), 2, fromCity);

		CommonUtility.clickElement(driver, one_way_trip.getLoc_from_search());
		System.out.println(CommonUtility.isDisplayed(driver, one_way_trip.getLoc_to_search()));
		System.out.println(CommonUtility.isElementVisible(driver, one_way_trip.getLoc_to_search()));
		System.out.println("1st");
		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_to_inputtext(), 2, toCity);

		System.out.println("2nd");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("3nd");
		CommonUtility.clickElement(driver, one_way_trip.getLoc_to_search());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_departure_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_calender_departure_date_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_class_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_adults_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_children_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_infants_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_choose_travel_class_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_traveller_apply_btn());
		driver.switchTo().frame("webpush-bubble");
		driver.findElement(By.xpath("//button[text()=\"I'll do this later\"]")).click();
		// System.out.println(driver.switchTo().frame(one_way_trip.getLoc_search_btn()));
		driver.switchTo().defaultContent();
		CommonUtility.clickElement(driver, one_way_trip.getLoc_search_btn());
	}

	@Test(priority = 2)
	public void selectFlightAndReview() throws InterruptedException {

		BasicConfigurator.configure();

		log.info("Starting the selectFligh testing");
		boolean visibility = CommonUtility.isElementVisible(driver, one_way_trip.getLoc_sortby_departure_btn());
		System.out.println(visibility);
		if (visibility == true) {
			CommonUtility.clickElement(driver, one_way_trip.getLoc_sortby_departure_btn());
		}
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		// click some link that opens a new window
		driver.findElement(By.xpath(one_way_trip.getLoc_book_now_btn())).click();

		// switch focus of WebDriver to the next found window handle
		// (that's your newly opened window)
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// code to do something on new window

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 6000)");

		CommonUtility.clickElement(driver, one_way_trip.getLoc_continue_btn());
	}

	@Test(priority = 3, dataProvider = "testinput", dataProviderClass = TestDataProvider.class)
	public void travellersDetails(String firstname, String lastname, String firstname1, String lastname1, String mob_no,
			String email) throws InterruptedException {
		try {
			BasicConfigurator.configure();

			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		CommonUtility.clickElement(driver, one_way_trip.getLoc_add_adult_btn());
		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_firstname_btn(), 2, firstname);
		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_lastname_btn(), 2, lastname);
		CommonUtility.clickElement(driver, one_way_trip.getLoc_f_gender_rbtn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_add_adult_btn());
		CommonUtility.clickElement(driver, one_way_trip.getLoc_cursorup_btn());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Element not found ");
		}

		CommonUtility.clickAndSendText(driver, "(" + (one_way_trip.getLoc_firstname_btn()) + ")[2]", 2, firstname1);
		CommonUtility.clickAndSendText(driver, "(" + (one_way_trip.getLoc_lastname_btn()) + ")[2]", 2, lastname1);
		CommonUtility.clickElement(driver, "(" + (one_way_trip.getLoc_f_gender_rbtn()) + ")[2]");

		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_contact_info_mob_no_text(), 2, mob_no);
		CommonUtility.clickAndSendText(driver, one_way_trip.getLoc_contact_info_email_text(), 2, email);
		CommonUtility.clickElement(driver, one_way_trip.getLoc_flight_details_continue_btn());
	}

	@AfterSuite
	public void end() throws InterruptedException {

		driver.close();
	}
}
