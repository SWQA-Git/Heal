package verification.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;
import lib.common.WebPageVerifier;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BookVisitPageVerifier extends WebPageVerifier
{
	public BookVisitPageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LogManager.getLogger(BookVisitPageVerifier.class.getName());

	public boolean verifyTitle() throws Exception
	{
		return verifyLabelText("BookVisit", "BookVisit");
	}

	public boolean verifyBookVisitEmergencyLabel() throws Exception
	{
		return verifyLabelText("BookVisit", "BookVisitEmergencyLabel");
	}

	public boolean verifyYesButtonLabel() throws Exception
	{
		return verifyLabelText("BookVisit", "EmergencyYesButton");
	}

	public boolean verifyYesButton() throws BiffException, IOException
	{
		return isElementPresent("BookVisit", "EmergencyYesButton");
	}

	public boolean verifyNoButtonLabel() throws Exception
	{
		return verifyLabelText("BookVisit", "EmergencyNoButton");
	}

	public boolean verifyNoButton() throws BiffException, IOException
	{
		return isElementPresent("BookVisit", "EmergencyNoButton");
	}

	public boolean verifyYesEmergencyLabel() throws Exception
	{
		return verifyLabelText("BookVisit", "YesEmergencyLabel");
	}

	public boolean verifyLinkForAddPatient() throws Exception
	{
		return isElementPresent("BookVisit", "AddPatient");
	}

	public boolean verifyLinkForExistingPatient() throws Exception
	{
		return isElementPresent("BookVisit", "ExistingPatient");
	}

	public boolean verifyURLRedirectToLogin() throws Exception
	{
		return verifyURL("Properties", "HealPatientLoginURL");
	}

	public boolean verifyURLRedirectToRegister() throws Exception
	{
		return verifyURL("Properties", "HealPatientRegisterURL");
	}

	public boolean verifyURLRedirectToBookVisit() throws Exception
	{
		return verifyURL("Properties", "HealBookVisitURL");
	}
}
