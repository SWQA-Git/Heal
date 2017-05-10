package test.patient;

import java.io.IOException;

import javax.swing.JOptionPane;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import verification.patient.BookVisitPageVerifier;
import verification.patient.HomePageVerifier;
import jxl.read.biff.BiffException;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.BookVisitPage;
import lib.patient.LoginPage;
import lib.patient.VisitDetailsPage;
import lib.patient.VisitLocationPage;

public class BookVisitTest extends TestBase
{

	public BookVisitTest() throws NullPointerException, BiffException, IOException
	{
		super();
	}

	private static final Logger	logger	= LogManager.getLogger(BookVisitTest.class.getName());
	LoginPage					loginPage;
	BookVisitPage				bookVisitPage;
	BookVisitPageVerifier		bookVisitPageVerifier;
	VisitLocationPage			visitLocationPage;
	VisitDetailsPage			visitDetailsPage;
	HomePageVerifier			homePageVerifier;

	@BeforeTest
	public void SetUp() throws BiffException, NullPointerException, IOException, InterruptedException
	{
		initializeDriver();
		// healPatientLoginPage = new HealPatientLoginPage();
		// healPatientLoginPage.login();
	}

	@Test
	public void testSecurityCheckWithInvalidURL() throws Exception
	{
		Utilities.executionStartedMethod();
		bookVisitPage = new BookVisitPage();
		bookVisitPage.validBookVisitUrl();
		bookVisitPageVerifier = new BookVisitPageVerifier();
		assertTrue(bookVisitPageVerifier.verifyURLRedirectToLogin(), "Redirected to incorrect URL");
		bookVisitPage.invalidBookVisitUrl();
		assertTrue(bookVisitPageVerifier.verifyURLRedirectToLogin(), "Redirected to incorrect URL");
		bookVisitPage.invalidBookVisitUrl01();
		assertTrue(bookVisitPageVerifier.verifyURLRedirectToRegister(), "Redirected to incorrect URL");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testSecurityWithValidURL() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		bookVisitPage = new BookVisitPage();
		bookVisitPage.clickOnBookVisits();
		bookVisitPageVerifier = new BookVisitPageVerifier();
		assertTrue(bookVisitPageVerifier.verifyURLRedirectToBookVisit(), "Redirected to incorrect URL");
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testElementsOfBookVisitPage() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		bookVisitPage = new BookVisitPage();
		bookVisitPage.clickOnBookVisits();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyTitle(), "Incorrect/Mismatch title of the page");
		assertTrue(homePageVerifier.verifyLinkHome(), "Link home is missing");
		assertTrue(homePageVerifier.verifyLinkBookVisit(), "Link BookVisit is missing");
		assertTrue(homePageVerifier.verifyLinkVisits(), "Link Visits is missing");
		assertTrue(homePageVerifier.verifyLinkProfiles(), "Link Profiles is missing");
		assertTrue(homePageVerifier.verifyLinkPaymentMethods(), "Link PaymentMethods is missing");
		assertTrue(homePageVerifier.verifyLinkSignOut(), "Link SignOut is missing");
		assertTrue(homePageVerifier.verifyLinkPrivacyPolicy(), "Link PrivacyPolicy is missing");
		assertTrue(homePageVerifier.verifyLinkTermsofService(), "Link Terms Of Service is missing");
		assertTrue(homePageVerifier.verifyLinkNoticeofPrivacyPractices(), "Link Notice of Privacy Practices is missing");
		assertTrue(homePageVerifier.verifyLinkNondiscriminationNotice(), "Link Nondiscrimination Notice is missing");
		assertTrue(homePageVerifier.verifyLabelHelpLine(), "Label of Helpline is missing/mismatch");
		bookVisitPageVerifier = new BookVisitPageVerifier();
		assertTrue(bookVisitPageVerifier.verifyBookVisitEmergencyLabel(), "Label missing/mismatch");
		assertTrue(bookVisitPageVerifier.verifyYesButton(), "Yes button is missing");
		assertTrue(bookVisitPageVerifier.verifyYesButtonLabel(), "Yes button label is missing");
		assertTrue(bookVisitPageVerifier.verifyNoButton(), "No button is missing");
		assertTrue(bookVisitPageVerifier.verifyNoButtonLabel(), "No button label is missing");
		assertTrue(homePageVerifier.verifyUsername(), "Incorrect Username");
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testYesEmergencyCase() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		BookVisitPage bookVisitPage = new BookVisitPage();
		bookVisitPage.clickOnBookVisits();
		bookVisitPageVerifier = new BookVisitPageVerifier();
		assertTrue(bookVisitPageVerifier.verifyBookVisitEmergencyLabel(), "Emergency Label Mismatch");
		bookVisitPage.clickOnBookVisitEmergencyYES();
		assertTrue(bookVisitPageVerifier.verifyYesEmergencyLabel(), "Yes Emergency Label Mismatch");
		bookVisitPage.clickOnOkButton();
		assertTrue(bookVisitPageVerifier.verifyBookVisitEmergencyLabel(), "Emergency Label Mismatch after visiting");
		loginPage = new LoginPage();
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testNoEmgergencyCase() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		BookVisitPage bookVisitPage = new BookVisitPage();
		bookVisitPage.clickOnBookVisits();
		bookVisitPageVerifier = new BookVisitPageVerifier();
		assertTrue(bookVisitPageVerifier.verifyBookVisitEmergencyLabel(), "Emergency Label Mismatch");
		bookVisitPage.clickOnBookVisitEmergencyNO();
		assertTrue(bookVisitPageVerifier.verifyLinkForAddPatient(), "Add Patient Link Is Missing");
		assertTrue(bookVisitPageVerifier.verifyLinkForExistingPatient(), "Existing Patient Link Is Missing");
		bookVisitPage.clickOnExistingPatient();
		visitLocationPage = new VisitLocationPage();
		visitLocationPage.findAddress();
		visitDetailsPage = new VisitDetailsPage();
		visitDetailsPage.selectServiceSickOrInjuried();
		visitDetailsPage.selectedDate();
		visitDetailsPage.selectTimes();
		visitDetailsPage.clickOnContinue();
	}

	@AfterTest
	public void tearDown()
	{
		closeBrowser();
	}

}
