package test.patient;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import verification.patient.HomePageVerifier;
import verification.patient.LoginPageVerifier;
import verification.patient.RegisterPageVerifier;
import lib.common.Browser;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.LoginPage;
import lib.patient.RegisterPage;

public class RegisterTest extends TestBase
{

	public RegisterTest() throws NullPointerException, BiffException, IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger	logger	= LogManager.getLogger(RegisterTest.class.getName());
	RegisterPage				registerPage;
	HomePageVerifier			homePageVerifier;
	RegisterPageVerifier		registerPageVerifier;
	LoginPage					loginPage;
	LoginPageVerifier			loginPageVerifier;

	@BeforeTest
	public void SetUp() throws BiffException, NullPointerException, IOException
	{
		initializeDriver();
	}

	@Test
	public void testSecurityCheckRedirectToRegisterPage() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage();
		registerPage.loadRegisterURL();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
		registerPage.invalidPatientRegisterUrl();
		assertTrue(registerPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testSecurityWithInvalidURL() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage();
		registerPageVerifier = new RegisterPageVerifier();
		registerPage.loadRegisterURL();
		assertTrue(registerPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
		registerPage.invalidPatientRegisterUrl01();
		assertTrue(registerPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testElementsOfRegisterPage() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage();
		registerPage.loadRegisterURL();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyPageTitle(), "Incorrect title of the page");
		assertTrue(registerPageVerifier.verifyLabelFirstName(), "Incorrect/Missing label FisrtName");
		assertTrue(registerPageVerifier.verifyInputFieldFirstName(), "Input field  FristName is missing");
		assertTrue(registerPageVerifier.verifyLabelLastName(), "Incorrect/Missing label LastName");
		assertTrue(registerPageVerifier.verifyInputFieldLastName(), "Input field  Last Name is missing");
		assertTrue(registerPageVerifier.verifyLabelEmail(), "Incorrect/Missing label Email");
		assertTrue(registerPageVerifier.verifyInputFieldEmail(), "Input field  email is missing");
		assertTrue(registerPageVerifier.verifyLabelPassword(), "Incorrect/Missing label Password");
		assertTrue(registerPageVerifier.verifyInputFieldPassword(), "Input field  password is missing");
		assertTrue(registerPageVerifier.verifyLabelConfirmPassword(), "Incorrect/Missing label Confirm Password");
		assertTrue(registerPageVerifier.verifyInputFieldConfirmPassword(), "Input field  confirm password is missing");
		assertTrue(registerPageVerifier.verifyLabelPhoneNumber(), "Incorrect/Missing label PhoneNumber");
		assertTrue(registerPageVerifier.verifyInputFieldPhoneNumber(), "Input field  phone number is missing");
		assertTrue(registerPageVerifier.verifyLabelZipCode(), "Incorrect/Missing label ZipCode");
		assertTrue(registerPageVerifier.verifyInputFieldZipCode(), "Input field  zip code is missing");
		assertTrue(registerPageVerifier.verifyLabelRememberMe(), "Incorrect/Missing label RememberMe");
		assertTrue(registerPageVerifier.verifyCheckboxRememberMe(), "Checkbox rememberMe is missing");
		assertTrue(registerPageVerifier.verifyLabelCreateAccount(), "Incorrect/Missing label Create Account");
		assertTrue(registerPageVerifier.verifyButtonCreateAccount(), "Create Account is missing");
		assertTrue(registerPageVerifier.verifyLabelLogIn(), "Incorrect/Missing label LogIn");
		assertTrue(registerPageVerifier.verifyLinkLogIn(), "Link login is missing");
		assertTrue(registerPageVerifier.verifyLabelHelpLine(), "Incorrect/Missing label HelpLine");
		assertTrue(registerPageVerifier.verifyLabelPrivacyPolicy(), "Incorrect/Missing label Privacy Policy");
		assertTrue(registerPageVerifier.verifyLinkPrivacyPolicy(), "Link Privacy Policy is missing");
		assertTrue(registerPageVerifier.verifyLabelTermsOfService(), "Incorrect/Missing label TermsOfService");
		assertTrue(registerPageVerifier.verifyLinkTermsOfService(), "Link TermsOfService is missing");
		assertTrue(registerPageVerifier.verifyLabelNoticeOfPrivacyPractices(), "Incorrect/Missing label NoticeOfPrivacyPractices");
		assertTrue(registerPageVerifier.verifyLinkNoticeOfPrivacyPractices(), "Link NoticeOfPrivacyPractices is missing");
		assertTrue(registerPageVerifier.verifyLabelNondiscriminationNotice(), "Incorrect/Missing label NondiscriminationNotice");
		assertTrue(registerPageVerifier.verifyLinkNondiscriminationNotice(), "Link NondiscriminationNotice is missing");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testRegisterFormWithBlankData() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage();
		registerPage.loadRegisterURL();
		registerPage.clickOnCreateAccountButton();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForFirstName(), "Error message mismatch or not found");
		assertTrue(registerPageVerifier.verifyValidationForLastName(), "Error message mismatch or not found");
		assertTrue(registerPageVerifier.verifyValidationForEmail(), "Error message mismatch or not found");
		assertTrue(registerPageVerifier.verifyValidationForPassword(), "Error message mismatch or not found");
		// assertTrue(registerPageVerifier.verifyValidationForConfirmPassword(),"Error
		// message mismatch or not found");
		assertTrue(registerPageVerifier.verifyValidationForPhoneNumber(), "Error message mismatch or not found");
		assertTrue(registerPageVerifier.verifyValidationForZipCode(), "Error message mismatch or not found");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testBrowserbackButtonFlow() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistration();
		registerPage.browserBackButton();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyRegUsername(), "Clicking on back browser button once takes to another screen");
		loginPage = new LoginPage();
		loginPage.logout();
		// registerPage.browserBackButton();
		// registerPage.browserBackButton();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testLogInLinkFlow() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage();
		registerPage.loadRegisterURL();
		registerPage.clickOnLogInLink();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyURLRedirectToLogin(), "Redirect to incorrect url, instead of Login page");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testRegisterWithValidData() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistration();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyRegUsername(), "Username not correct");
		loginPage = new LoginPage();
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testUnsupportedZipcodeElements() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithUnSupportedZipCode();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyLabelNotInArea(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyLabelContinue(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyLabelCont(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyButtonCont(), "Incorrect/Missing button");
		assertTrue(registerPageVerifier.verifyLabelOr(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyLabelNotify(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyLabelNotifyMe(), "Incorrect/Missing label");
		assertTrue(registerPageVerifier.verifyButtonNotifyMe(), "Incorrect/Missing button");
		assertTrue(registerPageVerifier.verifyButtonRegisterInDiffArea(), "Incorrect/Missing button");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testUnsupportedZipcodeContinue() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithUnSupportedZipCode();
		registerPage.clickOnUnsupportedZipcodeContiuneButton();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyRegUsername(), "Username not correct");
		loginPage = new LoginPage();
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testUnsupportedZipcodeNotifyMe() throws Exception
	{
		Utilities.executionStartedMethod();
		// Need to know the Expected
		Utilities.executionEndedMethod();
	}

	@Test
	public void testUnsupportedZipcodeRegisterInDiffArea() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithUnSupportedZipCode();
		registerPage.clickOnUnsupportedZipcodeRegInDiffAreaButton();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValueForFirstName(), "Value doesn't retained as expected");
		assertTrue(registerPageVerifier.verifyValueForLastName(), "Value doesn't retained as expected");
		assertTrue(registerPageVerifier.verifyValueForPassword(), "Value doesn't retained as expected");
		assertTrue(registerPageVerifier.verifyValueForConfirmPassword(), "Value doesn't retained as expected");
		assertTrue(registerPageVerifier.verifyValueForPhoneNumber(), "Value doesn't retained as expected");
		assertTrue(registerPageVerifier.verifyValueForZipCode(), "Value doesn't retained as expected");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testRegisterWithExistingUserName() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithExistingEmail();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForExistingUser(), "Incorrect/Missing error message");
		Utilities.executionStartedMethod();
	}

	@Test
	public void testPasswordMismatch() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithMismatchPassword();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForMismatchPassword(), "Incorrect/Missing error message");
		Utilities.executionStartedMethod();
	}

	@Test
	public void testConsistentErrorMessageForBlankFiled() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.loadRegisterURL();
		registerPage.enterRegisterWithOutPassword();
		registerPage.clickOnCreateAccountButton();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForPassword(), "Incorrect/Mismatch error message");
		registerPage.clearLastName();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForPassword(), "Incorrect/Mismatch error message");
		assertTrue(registerPageVerifier.verifyValidationForLastName(), "Incorrect/Mismatch error message");
		Utilities.executionStartedMethod();
	}

	@Test
	public void testInvalidPhoneNumber() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistrationWithInvalidPhoneNumber();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPhoneNumber(), "Incorrect/Mismatch error message");
		registerPage.enterInvalidPhoneNumber();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPhoneNumber(), "Incorrect/Mismatch error message");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testValidInvalidEmailAddress() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.loadRegisterURL();
		registerPage.enterRegisterForm();
		registerPage.clearEmail();
		registerPage.emailWithSpaceAndTwicePeriod();
		registerPage.clickOnCreateAccountButton();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForInvalidEmail(), "Incorrect/Mismatch error message");
		registerPage.clearEmail();
		registerPage.emailWithSpecialCharaters();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidEmail(), "Incorrect/Mismatch error message");
		registerPage.clearEmail();
		registerPage.emailWithoutTextbeforeAtTheRate();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidEmail(), "Incorrect/Mismatch error message");
		registerPage.clearEmail();
		registerPage.emailWithTwiceAtTheRate();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidEmail(), "Incorrect/Mismatch error message");
		registerPage.clearEmail();
		registerPage.emailWithRoundBracket();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidEmail(), "Incorrect/Mismatch error message");
		registerPage.enterRegisterForm();
		registerPage.clickOnCreateAccountButton();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyRegUsername(), "Username not correct");

		loginPage = new LoginPage();
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testValidInvalidPassword() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.loadRegisterURL();
		registerPage.enterRegisterForm();
		registerPage.clearPassword();
		registerPage.passwordWithOneUppercaseOthersLowercase();
		registerPage.clickOnCreateAccountButton();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithoneNumberOthersLowercase();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithAllUppercase();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithAllLowercase();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithAllNumbers();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithLessThan8Characters();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithAllUpperCaseAndNumeric();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithKeepWhiteSpacesInCharacters();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");

		registerPage.clearPassword();
		registerPage.passwordWithKeepPasswordFieldEmpty();
		registerPage.clickOnCreateAccountButton();
		assertTrue(registerPageVerifier.verifyValidationForInvalidPassword(), "Incorrect/Mismatch error message");
		assertTrue(registerPageVerifier.verifyValidationForPassword(), "Incorrect/Mismatch error message");
		assertTrue(registerPageVerifier.verifyValidationForMismatchPassword(), "Incorrect/Mismatch error message");

		registerPage.enterRegisterForm();
		registerPage.clickOnCreateAccountButton();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyRegUsername(), "Username not correct");

		loginPage = new LoginPage();
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testValidInvalidFirstName() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testValidInvalidLastName() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testValidInvalidZipcode() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testNormsAndConditionsLink() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.validPatientRegisterUrl();
		registerPage.clickOnPrivacyPolicyLink();
		registerPage.focusOnNewTabs();
		registerPageVerifier = new RegisterPageVerifier();
		assertTrue(registerPageVerifier.verifyURLRedirectToPolicyPrivate(), "Redirect to incorrect URL, instead of Policy Private");
		assertTrue(registerPageVerifier.verifyTitlePolicyPrivate(), "Incorrect title of the Policy Private");
		assertTrue(registerPageVerifier.verifyHeaderPolicyPrivate(), "Incorrect header of the Policy Private");
		registerPage.focusOnMainWin();
		registerPage.clickOnTermsOfServiceLink();
		registerPage.focusOnNewTabs();
		assertTrue(registerPageVerifier.verifyURLRedirectToTermsOfService(), "Redirect to incorrect URL, instead of Terms Of Service");
		assertTrue(registerPageVerifier.verifyTitleTermsOfService(), "Incorrect title of the Terms Of Service");
		assertTrue(registerPageVerifier.verifyHeaderTermsOfService(), "Incorrect header of the Terms Of Service");
		registerPage.focusOnMainWin();
		registerPage.clickOnNoticeOfPrivacyPracticesLink();
		registerPage.focusOnNewTabs();
		assertTrue(registerPageVerifier.verifyURLRedirectToNoticeOfPrivacyPractices(), "Redirect to incorrect URL, instead of Notice Of Privacy Practices");
		assertTrue(registerPageVerifier.verifyTitleNoticeOfPrivacyPractices(), "Incorrect title of the Notice Of Privacy Practices");
		assertTrue(registerPageVerifier.verifyHeaderNoticeOfPrivacyPractices(), "Incorrect header of the Notice Of Privacy Practices");
		registerPage.focusOnMainWin();
		registerPage.clickOnNondiscriminationNoticeLink();
		registerPage.focusOnNewTabs();
		assertTrue(registerPageVerifier.verifyURLRedirectToNondiscriminationNotice(), "Redirect to incorrect URL, instead of Nondiscrimination Notice");
		assertTrue(registerPageVerifier.verifyTitleNondiscriminationNotice(), "Incorrect title of the Notice Of Nondiscrimination Notice");
		assertTrue(registerPageVerifier.verifyHeaderNondiscriminationNotice(), "Incorrect header of the Notice Of Nondiscrimination Notice");
		Utilities.executionEndedMethod();
	}

	@AfterTest
	public void tearDown()
	{
		closeBrowser();
	}
}
