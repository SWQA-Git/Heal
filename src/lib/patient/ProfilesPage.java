package lib.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;
import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

public class ProfilesPage extends Browser
{
	private static final Logger		logger	= LogManager.getLogger(ProfilesPage.class.getName());
	private Browser					browser;
	private ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public ProfilesPage() throws MalformedURLException
	{}

	public ProfilesPage(String browserName) throws MalformedURLException
	{
		browser = new Browser(browserName);
	}

	// LOGIN URL
	public void loadLoginURL()
	{
		loadURL("Properties", "HealPatientLoginURL");
	}

	// LOGIN CREDENTIALS FOR PROFILES
	public void enterCredentials() throws NoSuchElementException, BiffException, IOException
	{
		enterValue("Profiles", "emailAdd", config.getDataValue("Profiles", "emailAdd"));
		logger.info("Logged in with email: " + config.getDataValue("Profiles", "Email"));
		enterValue("Profiles", "Password", config.getDataValue("Profiles", "Password"));
		clickOn("Profiles", "LoginButton");
		waitForElementPresent("Profiles", "username");
	}

	// FINAL LOGIN
	public void login() throws NoSuchElementException, BiffException, IOException
	{
		loadLoginURL();
		enterCredentials();
		System.out.println("Logged In");
		logger.info("Logged In");
	}

	// NAVIGATE TO PROFILES PAGE THROUGH SIDE BAVIGATION
	public void clickOnProfiles() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "NavProfiles");
	}

	// NAVIGATE TO PROFILES PAGE THROUGH DIRECT URL
	public void loadProfilesURL()
	{
		loadURL("Properties", "HealProfilesURL");
	}

	// CLICK ON DEFAULT EXISTING PATIENT
	public void clickOnExistingPatient() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "ExistingPatient");
	}

	// CLICK ON ADD PATIENT LINK
	public void clickOnAddPatient() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "AddPatient");
	}

	// CLICK ON CONTINUE BUTTON - MANAGE PROFILE SCREEN
	public void clickOnContinueButton() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "ContinueButton");
	}

	// CLICK ON DROPDOWN INSURANCE PROVIDER
	public void clickOnInsuranceProvider() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "InsuranceProvider");
	}

	// SELECT THE VALUE FOR THE DROPDOWN INSURANCE PROVIDER
	public void selectvalueFromInsuranceProvider()
	{
		clickOnDynamicValue("Profiles", "InsuranceOption", "InsuranceOptionValue");
	}

	// ENTER VALUE IN FIELD MEMBER ID
	public void enterMemberID()
	{
		clearField("Profiles", "MemberIDInputField");
		enterValue("Profiles", "MemberIDInputField", config.getDataValue("Profiles", "MemberIDInputField"));
	}

	// ENTER VALUE IN FIELD GROUP ID
	public void enterGroupID()
	{
		clearField("Profiles", "GroupIDInputField");
		enterValue("Profiles", "GroupIDInputField", config.getDataValue("Profiles", "GroupIDInputField"));
	}

	// ENTER VAUE FOR INSURANCE SECTION
	public void enterValueForInsurance() throws NoSuchElementException, BiffException, IOException
	{
		clickOnInsuranceProvider();
		selectvalueFromInsuranceProvider();
		enterMemberID();
		enterGroupID();
	}

	// CLICK ON SAVE AND CONTINUE BUTTON
	public void clickOnSaveAndCont() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "Save&ContinueButton");
	}

	// ENTER FIRST NAME
	public void enterFirstName()
	{
		clearField("Profiles", "FirstNameInputField");
		enterValue("Profiles", "FirstNameInputField", config.getDataValue("Profiles", "FirstNameInputField"));
	}

	// ENTER LAST NAME
	public void enterLastName()
	{
		clearField("Profiles", "LastNameInputField");
		enterValue("Profiles", "LastNameInputField", config.getDataValue("Profiles", "LastNameInputField"));
	}

	// ENTER EMAIL
	public void enterEmail()
	{
		clearField("Profiles", "EmailInputField");
		String emailAddress = Utilities.getDateAndTime() + config.getDataValue("Profiles", "EmailInputField");
		enterValue("Profiles", "EmailInputField", emailAddress);
	}

	// ENTER PHONE NUMBER
	public void enterPhoneNumber()
	{
		clearField("Profiles", "PhoneNumberInputField");
		enterValue("Profiles", "PhoneNumberInputField", config.getDataValue("Profiles", "PhoneNumberInputField"));
	}

	// ENTER DATE OF BIRTH
	public void enterDateOfBirth()
	{
		clearField("Profiles", "DOBInputField");
		enterValue("Profiles", "DOBInputField", config.getDataValue("Profiles", "DOBInputField"));
	}

	// SELECT VALUE FOR RELATIONSHIP
	public void selectRelationship() throws NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "RelationshipDropdown");
		clickOnDynamicValue("Profiles", "RelationshipOption", "RelationshipOptionValue");

	}

	// SELECT VALUE FOT GENDER
	public void selectGender() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		clickOn("Profiles", "GenderDropdown");
		clickOnDynamicValue("Profiles", "GenderOption", "GenderOptionValue");
		System.out.println("Clicked on Gender");
	}

	// ENTER VALUE FOR PATIENT SECTION
	public void enterValueForPatient() throws InterruptedException, NoSuchElementException, BiffException, IOException
	{
		enterFirstName();
		enterLastName();
		enterEmail();
		enterPhoneNumber();
		enterDateOfBirth();
		selectRelationship();
		selectGender();
	}

}
