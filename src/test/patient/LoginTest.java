package test.patient;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.LoginPage;
import verification.patient.HomePageVerifier;
import verification.patient.LoginPageVerifier;

public class LoginTest extends TestBase
{

	public LoginTest() throws NullPointerException, BiffException, IOException
	{
		super();
	}

	private static final Logger	logger		= LogManager.getLogger(LoginTest.class.getName());
	LoginPage					loginPage;
	LoginPageVerifier			loginPageVerifier;
	HomePageVerifier			homePageVerifier;
	String						sessionID	= null;

	@BeforeMethod(alwaysRun=true)
	public void SetUp() throws BiffException, NullPointerException, IOException
	{
		initializeDriver();
		sessionID = driver.getSessionID();
		logger.info("Current Session = " + sessionID);
	}
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}

	@Test
	public void testSecurityCheckRedirectToLoginPage() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.validPatientLoginUrl();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyURLRedirectToLogin(), "Redirected to incorrect URL");
			loginPage.invalidPatientLoginUrl();
			assertTrue(loginPageVerifier.verifyURLRedirectToLogin(), "Redirected to incorrect URL");
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}

	}

	@Test
	public void testSecurityWithInvalidURL() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			homePageVerifier = new HomePageVerifier();
			loginPage.validPatientLoginUrl();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyURLRedirectToLogin(), "Redirected to incorrect URL");
			loginPage.invalidPatientLoginUrl01();
			assertTrue(loginPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testElementsOfLoginPage() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.loadLoginURL();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyPageTitle(), "Incorrect title of the page");
			assertTrue(loginPageVerifier.verifyLabelEmail(), "Incorrect/Missing label Email");
			assertTrue(loginPageVerifier.verifyInputFieldEmail(), "Input field  email is missing");
			assertTrue(loginPageVerifier.verifyLabelPassword(), "Incorrect/Missing label Password");
			assertTrue(loginPageVerifier.verifyInputFieldPassword(), "Input field password is missing");
			assertTrue(loginPageVerifier.verifyLabelRememberMe(), "Incorrect/Missing label Remember Me");
			assertTrue(loginPageVerifier.verifyCheckboxRememberMe(), "Checkbox RememberMe is missing");
			assertTrue(loginPageVerifier.verifyLabelForgotPassword(), "Incorrect/Missing label Forgot Password");
			assertTrue(loginPageVerifier.verifyLinkForgotPassword(), "Link ForgotPassword is missing");
			assertTrue(loginPageVerifier.verifyLabelLogIn(), "Incorrect/Missing label LogIn");
			assertTrue(loginPageVerifier.verifyButtonLogIn(), "Button Login is missing");
			assertTrue(loginPageVerifier.verifyLabelRegister(), "Incorrect/Missing label Register");
			assertTrue(loginPageVerifier.verifyButtonRegister(), "Button Register is missing");
			assertTrue(loginPageVerifier.verifyLabelHelpLine(), "Incorrect/Missing label HelpLine");
			assertTrue(loginPageVerifier.verifyLabelPrivacyPolicy(), "Incorrect/Missing label Privacy Policy");
			assertTrue(loginPageVerifier.verifyLinkPrivacyPolicy(), "Link Privacy Policy is missing");
			assertTrue(loginPageVerifier.verifyLabelTermsOfService(), "Incorrect/Missing label TermsOfService");
			assertTrue(loginPageVerifier.verifyLinkTermsOfService(), "Link TermsOfService is missing");
			assertTrue(loginPageVerifier.verifyLabelNoticeOfPrivacyPractices(), "Incorrect/Missing label NoticeOfPrivacyPractices");
			assertTrue(loginPageVerifier.verifyLinkNoticeOfPrivacyPractices(), "Link NoticeOfPrivacyPractices is missing");
			assertTrue(loginPageVerifier.verifyLabelNondiscriminationNotice(), "Incorrect/Missing label NondiscriminationNotice");
			assertTrue(loginPageVerifier.verifyLinkNondiscriminationNotice(), "Link NondiscriminationNotice is missing");
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testBrowserbackButtonFlow() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.login();
			loginPage.browserBackButton();
			homePageVerifier = new HomePageVerifier();
			assertTrue(homePageVerifier.verifyUsername(), "Clicking on back browser button once takes to another screen");
			loginPage.logout();
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testRegisterLinkFlow() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.loadLoginURL();
			loginPage.clickOnRegisterLink();
			homePageVerifier = new HomePageVerifier();
			assertTrue(homePageVerifier.verifyURLRedirectToRegister(), "Redirect to incorrect url, instead of Register page");
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testLogInFormWithBlankData() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.validPatientLoginUrl();
			loginPage.allFieldBlank();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyValidationForUsername(), "Error message mismatch or not found");
			assertTrue(loginPageVerifier.verifyValidationForPassword(), "Error message mismatch or not found");
			loginPage.enterOnlyEmail();
			assertTrue(loginPageVerifier.verifyValidationForPassword(), "Error message mismatch or not found");
			loginPage.enterOnlyPassword();
			assertTrue(loginPageVerifier.verifyValidationForUsername(), "Error message mismatch or not found");
			Utilities.executionEndedMethod();
		}
		catch (Throwable Throwable)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testloginWithValidCredentails()
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.login();
			homePageVerifier = new HomePageVerifier();
			assertTrue(homePageVerifier.verifyUsername(), "Username not correct");
			loginPage.logout();
			Utilities.executionEndedMethod();
			
		}
		catch (Throwable throwable)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testNormsAndConditionsLink() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.validPatientLoginUrl();
			loginPage.clickOnPrivacyPolicyLink();
			loginPage.focusOnNewTabs();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyURLRedirectToPolicyPrivate(), "Redirect to incorrect URL, instead of Policy Private");
			assertTrue(loginPageVerifier.verifyTitlePolicyPrivate(), "Incorrect title of the Policy Private");
			assertTrue(loginPageVerifier.verifyHeaderPolicyPrivate(), "Incorrect header of the Policy Private");
			loginPage.focusOnMainWin();
			loginPage.clickOnTermsOfServiceLink();
			loginPage.focusOnNewTabs();
			assertTrue(loginPageVerifier.verifyURLRedirectToTermsOfService(), "Redirect to incorrect URL, instead of Terms Of Service");
			assertTrue(loginPageVerifier.verifyTitleTermsOfService(), "Incorrect title of the Terms Of Service");
			assertTrue(loginPageVerifier.verifyHeaderTermsOfService(), "Incorrect header of the Terms Of Service");
			loginPage.focusOnMainWin();
			loginPage.clickOnNoticeOfPrivacyPracticesLink();
			loginPage.focusOnNewTabs();
			assertTrue(loginPageVerifier.verifyURLRedirectToNoticeOfPrivacyPractices(), "Redirect to incorrect URL, instead of Notice Of Privacy Practices");
			assertTrue(loginPageVerifier.verifyTitleNoticeOfPrivacyPractices(), "Incorrect title of the Notice Of Privacy Practices");
			assertTrue(loginPageVerifier.verifyHeaderNoticeOfPrivacyPractices(), "Incorrect header of the Notice Of Privacy Practices");
			loginPage.focusOnMainWin();
			loginPage.clickOnNondiscriminationNoticeLink();
			loginPage.focusOnNewTabs();
			assertTrue(loginPageVerifier.verifyURLRedirectToNondiscriminationNotice(), "Redirect to incorrect URL, instead of Nondiscrimination Notice");
			assertTrue(loginPageVerifier.verifyTitleNondiscriminationNotice(), "Incorrect title of the Notice Of Nondiscrimination Notice");
			assertTrue(loginPageVerifier.verifyHeaderNondiscriminationNotice(), "Incorrect header of the Notice Of Nondiscrimination Notice");
			loginPage.focusOnMainWin();
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}

	@Test
	public void testValidationOfLoginForm() throws Exception
	{
		try
		{
			updateTestName(sessionID);
			Utilities.executionStartedMethod();
			loginPage = new LoginPage();
			loginPage.loadLoginURL();
			loginPage.validEmail();
			loginPage.incorrectPassword();
			loginPage.clickOnLoginButton();
			loginPageVerifier = new LoginPageVerifier();
			assertTrue(loginPageVerifier.verifyValidationMessage(), "Error message mismatch");
			loginPage.invalidEmail();
			loginPage.correctPassword();
			loginPage.clickOnLoginButton();
			assertTrue(loginPageVerifier.verifyValidationMessage(), "Error message mismatch");
			loginPage.invalidEmail();
			loginPage.incorrectPassword();
			loginPage.clickOnLoginButton();
			assertTrue(loginPageVerifier.verifyValidationMessage(), "Error message mismatch");
			Utilities.executionEndedMethod();
		}
		catch (Throwable e)
		{
			failTest(sessionID);
		}
	}
}
