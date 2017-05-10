package test.patient;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import jxl.read.biff.BiffException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import verification.patient.HomePageVerifier;
import lib.common.TestBase;
import lib.common.Utilities;
import lib.patient.HealPatientLoginPage;
import lib.patient.RegisterPage;

public class HealPatientRegisterTest extends TestBase
{

	public HealPatientRegisterTest() throws NullPointerException, BiffException, IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private static final Logger	logger	= LogManager.getLogger(HealPatientRegisterTest.class.getName());
	RegisterPage				registerPage;
	HomePageVerifier			homePageVerifier;
	HealPatientLoginPage		healPatientLoginPage;

	@BeforeTest
	public void SetUp() throws BiffException, NullPointerException, IOException
	{
		initializeDriver();
	}

	@Test
	public void registerWithValidData() throws Exception
	{
		Utilities.executionStartedMethod();
		registerPage = new RegisterPage("Browser");
		registerPage.newRegistration();
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
