package lib.patient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import jxl.read.biff.BiffException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoSuchElementException;

import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.Utilities;

public class LoginPage extends Browser
{
	private static final Logger		logger	= LogManager.getLogger(LoginPage.class.getName());
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public LoginPage(String browserName) throws MalformedURLException
	{
		super(browserName);
	}

	public LoginPage() throws MalformedURLException
	{}

	public void loadURL(String elementName)
	{
		loadURL("Properties", elementName);
	}

	public void enterValue(String fieldname, String fieldvalue)
	{
		clearField("HealCredential", fieldname);
		enterValue("HealCredential", fieldname, fieldvalue);
	}

	public void clickOn(String fieldname) throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealCredential", fieldname);
	}

	public void clickOnLoginButton() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("LoginButton");
	}

	public void enterCredentials() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("Email", config.getDataValue("HealCredential", "Email"));
		logger.info("Logged in with email: " + config.getDataValue("HealCredential", "Email"));
		enterValue("Password", config.getDataValue("HealCredential", "Password"));
		clickOn("LoginButton");
		waitForElementPresent("HealRegistration", "username");

	}

	public void enterCredentialsForProfiles() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("Profiles", "emailAdd", config.getDataValue("Profiles", "emailAdd"));
		logger.info("Logged in with email: " + config.getDataValue("Profiles", "emailAdd"));
		enterValue("Profiles", "Password", config.getDataValue("Profiles", "Password"));
		clickOn("LoginButton");
		waitForElementPresent("Profiles", "emailAdd");

	}

	public void enterOnlyEmail() throws NoSuchElementException, BiffException, IOException
	{
		clearField("HealCredential", "Password");
		enterValue("Email", config.getDataValue("HealCredential", "Email"));
		clickOn("LoginButton");
	}

	public void enterOnlyPassword() throws NoSuchElementException, BiffException, IOException
	{
		clearField("HealCredential", "Email");
		enterValue("Password", config.getDataValue("HealCredential", "Password"));
		clickOn("LoginButton");
	}

	public void allFieldBlank() throws NoSuchElementException, BiffException, IOException
	{
		clearField("HealCredential", "Email");
		clearField("HealCredential", "Password");
		clickOn("LoginButton");
	}

	public void login() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		loadURL("HealPatientLoginURL");
		enterCredentials();
		waitForElementPresent("Home", "username");
		System.out.println("Logged In");
		logger.info("Logged In");

	}

	public void loginForProfiles() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		loadURL("HealPatientLoginURL");
		enterCredentialsForProfiles();
		System.out.println("Logged In");
		logger.info("Logged In");
	}

	public void logout() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		clickOn("LogOut");
		waitForElementPresent("HealCredential", "Email");
		System.out.println("Logged Out");
		logger.info("Logged Out");
	}

	public void validPatientLoginUrl()
	{
		loadURL("validPatientLoginUrl");
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "validPatientLoginUrl"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "validPatientLoginUrl"));
	}

	public void invalidPatientLoginUrl()
	{
		loadURL("invalidPatientLoginUrl");
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "invalidPatientLoginUrl"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "invalidPatientLoginUrl"));
	}

	public void invalidPatientLoginUrl01() throws InterruptedException
	{
		loadURL("invalidPatientLoginUrl01");
		Thread.sleep(2000);
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "invalidPatientLoginUrl01"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "invalidPatientLoginUrl01"));
	}

	public void loadLoginURL()
	{
		loadURL("HealPatientLoginURL");
	}

	public void browserBackButton()
	{
		Utilities.sleep(2000);
		System.out.println("Click on back browser button before");
		navigateBack();

		System.out.println("Click on back browser button");
	}

	public void clickOnRegisterLink() throws NoSuchElementException, BiffException, IOException
	{
		waitForElementPresent("HealCredential" , "RegisterButton");
		clickOn("RegisterButton");
	}

	public void clickOnPrivacyPolicyLink() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("PrivacyPolicy");
	}

	public void clickOnTermsOfServiceLink() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("TermsOfService");
	}

	public void clickOnNoticeOfPrivacyPracticesLink() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("NoticeOfPrivacyPractices");
	}

	public void clickOnNondiscriminationNoticeLink() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("NondiscriminationNotice");
	}

	public void focusOnNewTabs()
	{
		focusOnNewTab();
	}

	public void focusOnMainWin()
	{
		focusOnMainWindow();
	}

	public void closeTabs()
	{
		closeTab();
	}

	public void invalidEmail()
	{
		enterValue("Email", config.getDataValue("HealCredential", "invalidEmailAddress"));
	}

	public void validEmail()
	{
		enterValue("Email", config.getDataValue("HealCredential", "validEmailAddress"));
	}

	public void incorrectPassword()
	{
		enterValue("Password", config.getDataValue("HealCredential", "invalidPassword"));

	}

	public void correctPassword()
	{
		enterValue("Password", config.getDataValue("HealCredential", "validPassword"));

	}

}
