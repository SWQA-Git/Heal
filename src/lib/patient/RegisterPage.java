package lib.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;
import lib.common.Browser;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoSuchElementException;

import lib.common.ConfigurationProperty;
import lib.common.Utilities;

public class RegisterPage extends Browser
{
	private static final Logger		logger	= LogManager.getLogger(RegisterPage.class.getName());
	private Browser					browser;
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public RegisterPage(String browserName) throws MalformedURLException
	{
		browser = new Browser(browserName);
	}

	public void clickOn(String fieldname) throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealCredential", fieldname);
	}

	public RegisterPage() throws MalformedURLException
	{}

	public void loadURL(String elementName)
	{
		loadURL("Properties", elementName);
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

	public void enterValue(String fieldname, String fieldvalue)
	{
		browser.clearField("HealRegistration", fieldname);
		browser.enterValue("HealRegistration", fieldname, fieldvalue);
	}

	public void enterRegistrationForm() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
		waitForElementPresent("HealRegistration", "username");
	}

	public void newRegistration() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		System.out.println(".....Heal New Patient Registration......");
		logger.info(".....Heal New Patient Registration......");
		browser.loadURL("Properties", "HealPatientRegisterURL");
		enterRegistrationForm();
	}

	public void enterRegisterWithUnsupportZipcode() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "UnsupportZipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
	}

	public void newRegistrationWithUnSupportedZipCode() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		System.out.println(".....Heal New Patient Registration......");
		logger.info(".....Heal New Patient Registration......");
		browser.loadURL("Properties", "HealPatientRegisterURL");
		enterRegisterWithUnsupportZipcode();
	}

	public void enterRegisterWithExistingEmail() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		// String emailAddress = Utilities.getDateAndTime()
		// + config.getDataValue("HealRegistration", "ExistingEmail");
		enterValue("Email", config.getDataValue("HealRegistration", "ExistingEmail"));
		// System.out.println("Email: " + emailAddress);
		// logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
	}

	public void newRegistrationWithExistingEmail() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		System.out.println(".....Heal New Patient Registration......");
		logger.info(".....Heal New Patient Registration......");
		browser.loadURL("Properties", "HealPatientRegisterURL");
		enterRegisterWithExistingEmail();
	}

	public void enterRegisterWithMismatchPassword() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password01"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password01"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword01"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
	}

	public void newRegistrationWithMismatchPassword() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		browser.loadURL("Properties", "HealPatientRegisterURL");
		enterRegisterWithMismatchPassword();
	}

	public void enterRegisterWithOutPassword() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
	}

	public void browserBackButton()
	{
		navigateBack();
		System.out.println("Click on back browser button");
	}

	public void loadRegisterURL() throws InterruptedException
	{
		loadURL("HealPatientRegisterURL");
		Thread.sleep(2000);
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "validPatientRegisterUrl"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "validPatientRegisterUrl"));
	}

	public void validPatientRegisterUrl() throws InterruptedException
	{
		loadURL("validPatientRegisterUrl");
		Thread.sleep(2000);
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "validPatientRegisterUrl"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "validPatientRegisterUrl"));
	}

	public void invalidPatientRegisterUrl() throws InterruptedException
	{
		loadURL("invalidPatientRegisterUrl");
		Thread.sleep(5000);
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "invalidPatientRegisterUrl"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "invalidPatientRegisterUrl"));
	}

	public void invalidPatientRegisterUrl01() throws InterruptedException
	{
		loadURL("invalidPatientRegisterUrl01");
		Thread.sleep(5000);
		System.out.println("Loaded URL: " + config.getDataValue("Properties", "invalidPatientRegisterUrl01"));
		logger.info("Loaded URL: " + config.getDataValue("Properties", "invalidPatientRegisterUrl01"));
	}

	public void clickOnLogInLink() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealRegistration", "LogInLink");
	}

	public void clickOnCreateAccountButton() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealRegistration", "CreateAccount");
	}

	public void clickOnUnsupportedZipcodeContiuneButton() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealRegistration", "ContinueButton");
	}

	public void clickOnUnsupportedZipcodeRegInDiffAreaButton() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("HealRegistration", "RegisterInDifferentArea");
	}

	public void enterRegisterWithInvalidPhoneNumber() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber01"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
		browser.clickOn("HealRegistration", "CreateAccount");
	}

	public void newRegistrationWithInvalidPhoneNumber() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		browser.loadURL("Properties", "HealPatientRegisterURL");
		enterRegisterWithInvalidPhoneNumber();
	}

	public void enterInvalidPhoneNumber()
	{
		clearField("HealRegistration", "PhoneNumber");
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber02"));
	}

	public void enterRegisterForm() throws InterruptedException
	{
		enterValue("FirstName", config.getDataValue("HealRegistration", "FirstName"));
		enterValue("LastName", config.getDataValue("HealRegistration", "LastName"));
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("HealRegistration", "Email");
		enterValue("Email", emailAddress);
		System.out.println("Email: " + emailAddress);
		logger.info("Email: " + emailAddress);
		enterValue("Password", config.getDataValue("HealRegistration", "Password"));
		logger.info("Password: " + config.getDataValue("HealRegistration", "Password"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "ConfirmPassword"));
		enterValue("PhoneNumber", config.getDataValue("HealRegistration", "PhoneNumber"));
		enterValue("Zipcode", config.getDataValue("HealRegistration", "Zipcode"));
	}

	public void clearFirstName()
	{
		clearField("HealRegistration", "FirstName");
	}

	public void clearLastName()
	{
		clearField("HealRegistration", "LastName");
	}

	public void clearEmail()
	{
		clearField("HealRegistration", "Email");
	}

	public void clearPassword()
	{
		clearField("HealRegistration", "Password");
		clearField("HealRegistration", "ConfirmPassword");
	}

	public void clearZipcode()
	{
		clearField("HealRegistration", "Zipcode");
	}

	public void emailWithSpaceAndTwicePeriod()
	{
		enterValue("Email", config.getDataValue("HealRegistration", "WithSpaceAndTwicePeriod"));
	}

	public void emailWithSpecialCharaters()
	{
		enterValue("Email", config.getDataValue("HealRegistration", "WithSpecialCharaters"));
	}

	public void emailWithoutTextbeforeAtTheRate()
	{
		enterValue("Email", config.getDataValue("HealRegistration", "WithoutTextbeforeAtTheRate"));
	}

	public void emailWithTwiceAtTheRate()
	{
		enterValue("Email", config.getDataValue("HealRegistration", "WithTwiceAtTheRate"));
	}

	public void emailWithRoundBracket()
	{
		enterValue("Email", config.getDataValue("HealRegistration", "WithRoundBracket"));
	}

	public void passwordWithOneUppercaseOthersLowercase()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "OneUppercaseOthersLowercase"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "OneUppercaseOthersLowercase"));
	}

	public void passwordWithoneNumberOthersLowercase()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "OneNumberOthersLowercase"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "OneNumberOthersLowercase"));
	}

	public void passwordWithAllUppercase()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "AllUppercase"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "AllUppercase"));
	}

	public void passwordWithAllLowercase()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "AllLowercase"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "AllLowercase"));
	}

	public void passwordWithAllNumbers()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "AllNumbers"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "AllNumbers"));
	}

	public void passwordWithLessThan8Characters()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "LessThan8Characters"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "LessThan8Characters"));
	}

	public void passwordWithAllUpperCaseAndNumeric()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "AllUpperCaseAndNumeric"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "AllUpperCaseAndNumeric"));
	}

	public void passwordWithKeepWhiteSpacesInCharacters()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "KeepWhiteSpacesInCharacters"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "KeepWhiteSpacesInCharacters"));
	}

	public void passwordWithKeepPasswordFieldEmpty()
	{
		enterValue("Password", config.getDataValue("HealRegistration", "KeepPasswordFieldEmpty"));
		enterValue("ConfirmPassword", config.getDataValue("HealRegistration", "KeepPasswordFieldEmpty"));
	}

}
