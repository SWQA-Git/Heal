package lib.patient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jxl.read.biff.BiffException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.Utilities;

public class VisitDetailsPage
{
	private static final Logger		logger	= LogManager.getLogger(VisitDetailsPage.class.getName());
	private Browser					browser;
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public VisitDetailsPage() throws MalformedURLException
	{
		browser = new Browser();
	}

	public void enterValue(String fieldname, String fieldvalue)
	{
		browser.clearField("VisitDetails", fieldname);
		browser.enterValue("VisitDetails", fieldname, fieldvalue);
	}

	public void clickOnContinue() throws NoSuchElementException, BiffException, IOException
	{
		browser.clickOn("VisitDetails", "ContinueButton");
	}

	public void selectServiceSickOrInjuried() throws NoSuchElementException, BiffException, IOException
	{
		browser.waitForElementPresent("VisitDetails", "SickOrInjuried");
		Utilities.sleep(10000);
		browser.clickOn("VisitDetails", "SickOrInjuried");
		System.out.println("Selected Service: " + config.getDataValue("VisitDetails", "SickOrInjuried"));
		logger.info("Selected Service:" + config.getDataValue("VisitDetails", "SickOrInjuried"));
	}

	public void selectServiceAnnualPhysical() throws NoSuchElementException, BiffException, IOException
	{
		browser.waitForElementPresent("VisitDetails", "AnnualPhysical");
		Utilities.sleep(10000);
		browser.clickOn("VisitDetails", "AnnualPhysical");
		System.out.println("Selected Service:" + config.getDataValue("VisitDetails", "AnnualPhysical"));
		logger.info("Selected Service:" + config.getDataValue("VisitDetails", "AnnualPhysical"));
	}

	public void selectServiceFluShot() throws NoSuchElementException, BiffException, IOException
	{
		browser.waitForElementPresent("VisitDetails", "FluShot");
		Utilities.sleep(10000);
		browser.clickOn("VisitDetails", "FluShot");
		System.out.println("Selected Service:" + config.getDataValue("VisitDetails", "FluShot"));
		logger.info("Selected Service:" + config.getDataValue("VisitDetails", "FluShot"));
	}

	public void selectServiceOther() throws NoSuchElementException, BiffException, IOException
	{
		browser.waitForElementPresent("VisitDetails", "Other");
		Utilities.sleep(10000);
		browser.clickOn("VisitDetails", "Other");
		System.out.println("Selected Service:" + config.getDataValue("VisitDetails", "Other"));
		logger.info("Selected Service:" + config.getDataValue("VisitDetails", "Other"));
	}

	public void selectedDate() throws InterruptedException
	{
		Thread.sleep(5000);
		enterValue("SelectDate", config.getDataValue("VisitDetails", "SelectDate"));
		// TODO: Find the Solution for Chrome for selecting the date
		System.out.println("Selected Date:" + config.getDataValue("VisitDetails", "SelectDate"));
		logger.info("Selected Date:" + config.getDataValue("VisitDetails", "SelectDate"));
	}

	public void selectTimes() throws NoSuchElementException, BiffException, IOException
	{
		JOptionPane.showInputDialog(null, "Wait for the interaction", "Wait", 0, null, null, "Label");
		browser.waitForElementPresent("VisitDetails", "SelectTime");
		browser.clickOn("VisitDetails", "SelectTime");
		// String value = browser.selectValueFromDropDown("VisitDetails",
		// "SelectTime");
		// System.out.println("Time Selected: "+value );
		// System.out.println("Value are: " +Value);

		// int count = browser.getCount("VisitDetails", "AvailableTimes");
		// System.out.println("Count of Avaiable Time Slot:" + count);
		// for (int i = 1; i < count; i++) {
		// WebElement timeslot = browser
		// .getElementsDirectly("//*[@id='select-service']/div[2]/div/div/div[6]/div/button["
		// + i + "]");
		// if (timeslot.isEnabled()) {
		// logger.info(timeslot.getText() + " timeslot is avaliable");
		// timeslot.click();
		// } else {
		// logger.info("All time slot are booked for select date");
		// }
		//
		// }

	}
}
