package com.atmecs.constants;

import java.io.File;

public class FilePath {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator;
	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;
	public final static String LIB_HOME = USER_HOME + "lib" + File.separator;

	public final static String CONFIG_FILE = RESOURCES_HOME + "testData" + File.separator + "config.properties";
	public final static String CHROME_PATH = LIB_HOME + "chromedriver.exe";
	public final static String FIREFOX_PATH = LIB_HOME + "geckodriver.exe";
	public final static String IE_PATH = LIB_HOME + "IEDriver.exe";

	public final static String ONEWAY_FILE = LOCATOR_HOME + "oneWay.properties";
	public final static String ROUNDTRIP_FILE = LOCATOR_HOME + "roundTrip.properties";
	public final static String CITYTESTDATA_FILE = RESOURCES_HOME + "testData" + File.separator
			+ "cityinput.xlsx";
	public final static String INPUTTESTDATA_FILE = RESOURCES_HOME + "testData" + File.separator
			+ "testdata.xlsx";

	public static void main(String[] args) {
		System.out.println(INPUTTESTDATA_FILE);
	}
}
