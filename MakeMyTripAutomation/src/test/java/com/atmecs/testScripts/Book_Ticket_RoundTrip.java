package com.atmecs.testScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.constants.RoundTrip;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.testBase.TestBase;

public class Book_Ticket_RoundTrip extends TestBase {
	RoundTrip roundtrip = new RoundTrip();

	@Test(priority = 1)
	public void homePage() {
		System.out.println("IHIGY");
		CommonUtility.clickElement(driver, roundtrip.getLoc_round_trip_rbtn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_from_box());
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_from_inputtext(), 2, "Hyderabad");
		CommonUtility.clickElement(driver, roundtrip.getLoc_from_search());
		System.out.println("1st");
		CommonUtility.clickAndSendText(driver, roundtrip.getLoc_to_box(), 2, "Kolkata");
		System.out.println("2nd");
		CommonUtility.clickElement(driver, roundtrip.getLoc_to_search());
		CommonUtility.clickElement(driver, roundtrip.getLoc_departure_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_departure_date_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_departure_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_return_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_nextmont_btn());
		System.out.println("3nd");
		CommonUtility.clickElement(driver, roundtrip.getLoc_calender_return_date_btn());

		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_class_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_adults_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_children_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_infants_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_choose_travel_class_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_traveller_apply_btn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_search_btn());
	}

	@Test(priority = 2)
	public void selectFlightAndReview() {
		CommonUtility.clickElement(driver, roundtrip.getLoc_departuresortby_dpdn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_departuresortby_dpdn());
		CommonUtility.clickElement(driver, roundtrip.getLoc_book_now_btn());
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> iterator = windowhandle.iterator();
		String mainwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
		CommonUtility.scrollDownPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		CommonUtility.clickElement(driver, roundtrip.getLoc_continue_btn());

	}
}
