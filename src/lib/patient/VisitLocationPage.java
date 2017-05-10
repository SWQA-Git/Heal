package lib.patient;

import java.awt.AWTException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import jxl.read.biff.BiffException;

import org.apache.logging.log4j.LogManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import lib.common.Browser;
import lib.common.ConfigurationProperty;

public class VisitLocationPage
{
	private static final Logger		logger	= LogManager.getLogger(VisitLocationPage.class.getName());
	private Browser					browser;
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public VisitLocationPage() throws MalformedURLException
	{
		browser = new Browser();
	}

	public void enterValue(String fieldname, String fieldvalue)
	{
		browser.clearField("VisitLocation", fieldname);
		browser.enterValue("VisitLocation", fieldname, fieldvalue);
	}

	public void clickOnContinue() throws NoSuchElementException, BiffException, IOException
	{
		browser.clickOn("VisitLocation", "ContinueButton");
	}

	public void robotDownPress() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public void findAddress() throws InterruptedException, AWTException, NoSuchElementException, BiffException, IOException
	{
		System.out.println("Address: " + config.getDataValue("VisitLocation", "Address"));
		logger.info("Address: " + config.getDataValue("VisitLocation", "Address"));
		enterValue("Address", config.getDataValue("VisitLocation", "Address"));
		Thread.sleep(5000);
		robotDownPress();
		enterValue("Apt", config.getDataValue("VisitLocation", "Apt"));
		enterValue("EntryInstrucations", config.getDataValue("VisitLocation", "EntryInstrucations"));
		clickOnContinue();
	}
}
