package verification.patient;

import java.net.MalformedURLException;

import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.WebPageVerifier;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HomePageVerifier extends WebPageVerifier
{
	public HomePageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger	logger	= LogManager.getLogger(HomePageVerifier.class.getName());
	WebPageVerifier				webPageVerifier;
	Browser						browser;
	ConfigurationProperty		cong;

	public boolean verifyUsername() throws Exception
	{
		return verifyLabelText("Home", "username");
	}

	public boolean verifyRegUsername() throws Exception
	{
		return verifyLabelText("HealRegistration", "username");
	}

	public boolean verifyURLRedirectToRegister() throws Exception
	{
		return verifyURL("Properties", "HealPatientRegisterURL");

	}

	public boolean verifyLinkHome() throws Exception
	{
		return verifyLabelText("Home", "Home");
	}

	public boolean verifyLinkBookVisit() throws Exception
	{
		return verifyLabelText("Home", "BookVisit");
	}

	public boolean verifyLinkVisits() throws Exception
	{
		return verifyLabelText("Home", "Visits");
	}

	public boolean verifyLinkProfiles() throws Exception
	{
		return verifyLabelText("Home", "Profiles");
	}

	public boolean verifyLinkPaymentMethods() throws Exception
	{
		return verifyLabelText("Home", "PaymentMethods");
	}

	public boolean verifyLinkSignOut() throws Exception
	{
		return verifyLabelText("Home", "SignOut");
	}

	public boolean verifyLabelHelpLine() throws Exception
	{
		return verifyLabelText("Home", "HelpLine");
	}

	public boolean verifyLinkPrivacyPolicy() throws Exception
	{
		return verifyLabelText("Home", "PrivacyPolicy");
	}

	public boolean verifyLinkNoticeofPrivacyPractices() throws Exception
	{
		return verifyLabelText("Home", "NoticeofPrivacyPractices");
	}

	public boolean verifyLinkTermsofService() throws Exception
	{
		return verifyLabelText("Home", "TermsofService");
	}

	public boolean verifyLinkNondiscriminationNotice() throws Exception
	{
		return verifyLabelText("Home", "NondiscriminationNotice");
	}

	public boolean verifyHeader() throws Exception
	{
		return verifyLabelText("Home", "Header");
	}

	public boolean verifyTitle() throws Exception
	{
		return verifyTitle("Home", "Title");
	}

}
