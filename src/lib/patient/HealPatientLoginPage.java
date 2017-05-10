package lib.patient;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import jxl.read.biff.BiffException;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import lib.common.Browser;
import lib.common.ConfigurationProperty;

public class HealPatientLoginPage extends Browser
{
	private static final Logger		logger	= LogManager.getLogger(HealPatientLoginPage.class.getName());
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public HealPatientLoginPage(String browserName) throws MalformedURLException
	{
		super(browserName);
	}

	public HealPatientLoginPage() throws MalformedURLException
	{}

	public void enterValue(String fieldname, String fieldvalue)
	{
		clearField("HealCredential", fieldname);
		enterValue("HealCredential", fieldname, fieldvalue);
	}

	public void enterCredentials() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("Email", config.getDataValue("HealCredential", "Email"));
		logger.info("Logged in with email: " + config.getDataValue("HealCredential", "Email"));
		enterValue("Password", config.getDataValue("HealCredential", "Password"));
		clickOn("HealCredential", "LoginButton");
	}

	public void login() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		System.out.println(".....Heal Patient Login......");
		logger.info(".....Heal Patient Login ......");
		loadURL("Properties", "HealPatientLoginURL");
		enterCredentials();
	}

	public void logout() throws NoSuchElementException, BiffException, IOException
	{
		System.out.println(".....Heal Patient Logout....");
		logger.info(".....Heal Patient Logout....");
		clickOn("HealCredential", "LogOut");
	}

}
