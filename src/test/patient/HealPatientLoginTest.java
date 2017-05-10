package test.patient;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import jxl.read.biff.BiffException;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.HealPatientLoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import verification.patient.HomePageVerifier;

public class HealPatientLoginTest extends TestBase
{

	public HealPatientLoginTest() throws NullPointerException, BiffException, IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private static final Logger	logger	= LogManager.getLogger(HealPatientLoginTest.class.getName());
	HealPatientLoginPage		healPatientLoginPage;
	HomePageVerifier			homePageVerifier;

	@BeforeTest
	public void SetUp() throws BiffException, NullPointerException, IOException
	{
		initializeDriver();
	}

	@Test
	public void loginWithValidCredentails() throws Exception
	{
		Utilities.executionStartedMethod();
		healPatientLoginPage = new HealPatientLoginPage();
		healPatientLoginPage.login();
		homePageVerifier = new HomePageVerifier();
		assertTrue(homePageVerifier.verifyUsername(), "Username not correct");
		healPatientLoginPage.logout();
		Utilities.executionEndedMethod();
	}

	@AfterTest
	public void tearDown()
	{
		closeBrowser();
	}
}
