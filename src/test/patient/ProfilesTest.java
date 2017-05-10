package test.patient;

import java.io.IOException;

import jxl.read.biff.BiffException;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.LoginPage;
import lib.patient.ProfilesPage;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import verification.patient.ProfilesPageVerifier;

public class ProfilesTest extends TestBase
{

	public ProfilesTest() throws NullPointerException, BiffException, IOException
	{
		super();
	}

	private static final Logger	logger	= LogManager.getLogger(ProfilesTest.class.getName());
	LoginPage					loginPage;
	ProfilesPage				profilesPage;
	ProfilesPageVerifier		profilesPageVerifier;

	@BeforeTest
	public void SetUp() throws BiffException, NullPointerException, IOException
	{
		initializeDriver();
	}

	@Test
	public void testElementsofInsuranceSection() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		profilesPage = new ProfilesPage();
		profilesPage.loadProfilesURL();
		profilesPageVerifier = new ProfilesPageVerifier();
		assertTrue(profilesPageVerifier.verifyHeader(), "Incorrect/missing header - Manage Profile");
		assertTrue(profilesPageVerifier.verifySubHeader(), "Incorrect/missing subheaader - Manage Profile: Choose Profile");
		profilesPage.clickOnExistingPatient();
		profilesPage.clickOnContinueButton();
		assertTrue(profilesPageVerifier.verifySubHeaderForExistingPatient(), "Incorrect/missing subheaader - Manage Profile: Patient Details");
		assertTrue(profilesPageVerifier.verifyInsuranceHeader(), "Incorrect/missing header - Insurance (Optional)");
		// assertTrue(profilesPageVerifier.verifyInsuranceProviderLabel(),"Incorrect/missing
		// field label - Insurace Provider");
		assertTrue(profilesPageVerifier.verifyMemberIDLabel(), "Incorrect/missing field label - Member ID");
		assertTrue(profilesPageVerifier.verifyGroupIDLabel(), "Incorrect/missing field label - Group ID");
		loginPage.logout();
		Utilities.executionEndedMethod();
	}

	@Test
	public void testAddInsuranceForExistingPatient() throws Exception
	{
		Utilities.executionStartedMethod();
		profilesPage = new ProfilesPage();
		profilesPage.login();
		profilesPage.loadProfilesURL();
		// profilesPage.clickOnProfiles();
		profilesPage.clickOnExistingPatient();
		profilesPage.clickOnContinueButton();
		profilesPage.enterValueForInsurance();
		profilesPage.clickOnSaveAndCont();
		profilesPageVerifier = new ProfilesPageVerifier();
		assertTrue(profilesPageVerifier.verifyHeader(), "Incorrect/missing header - Manage Profile");
		assertTrue(profilesPageVerifier.verifySubHeader(), "Incorrect/missing subheaader - Manage Profile: Choose Profile");
		Utilities.executionEndedMethod();
	}

	@Test
	public void testAddPatients() throws Exception
	{
		Utilities.executionStartedMethod();
		loginPage = new LoginPage();
		loginPage.login();
		profilesPage = new ProfilesPage();
		profilesPage.loadProfilesURL();
		profilesPage.clickOnAddPatient();
		profilesPage.enterValueForPatient();
		profilesPage.clickOnSaveAndCont();
		assertTrue(profilesPageVerifier.verifyHeader(), "Incorrect/missing header - Manage Profile");
		assertTrue(profilesPageVerifier.verifySubHeader(), "Incorrect/missing subheaader - Manage Profile: Choose Profile");
		Utilities.executionEndedMethod();
	}

	@AfterTest
	public void tearDown()
	{
		closeBrowser();
	}
}
