package verification.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;
import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.WebPageVerifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageVerifier extends WebPageVerifier
{
	public LoginPageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger	logger	= LogManager.getLogger(LoginPageVerifier.class.getName());
	WebPageVerifier				webPageVerifier;
	Browser						browser;
	ConfigurationProperty		cong;

	public boolean verifyURLRedirectToLogin() throws Exception
	{
		return verifyURL("Properties", "HealPatientLoginURL");
	}

	public boolean verifyURLRedirectToRegister() throws Exception
	{
		return verifyURL("Properties", "HealPatientRegisterURL");
	}

	public boolean verifyPageTitle()
	{
		return verifyTitle("Login", "Title");
	}

	public boolean verifyLabelEmail() throws Exception
	{
		return verifyLabelText("Login", "EmailLabel");
	}

	public boolean verifyInputFieldEmail() throws BiffException, IOException
	{
		return isElementPresent("Login", "EmailInputField");
	}

	public boolean verifyLabelPassword() throws Exception
	{
		return verifyLabelText("Login", "PasswordLabel");
	}

	public boolean verifyInputFieldPassword() throws BiffException, IOException
	{
		return isElementPresent("Login", "PasswordInputField");
	}

	public boolean verifyLabelRememberMe() throws Exception
	{
		return verifyLabelText("Login", "RememberMeLabel");
	}

	public boolean verifyCheckboxRememberMe() throws BiffException, IOException
	{
		return isElementPresent("Login", "RemembermeCheckBox");
	}

	public boolean verifyLabelForgotPassword() throws Exception
	{
		return verifyLabelText("Login", "ForgotPasswordLink");
	}

	public boolean verifyLinkForgotPassword() throws BiffException, IOException
	{
		return isElementPresent("Login", "ForgotPasswordLink");
	}

	public boolean verifyLabelLogIn() throws Exception
	{
		return verifyLabelText("Login", "LoginButtonLabel");
	}

	public boolean verifyButtonLogIn() throws BiffException, IOException
	{
		return isElementPresent("Login", "LoginButtonLabel");
	}

	public boolean verifyLabelRegister() throws Exception
	{
		return verifyLabelText("Login", "RegisterButtonLabel");
	}

	public boolean verifyButtonRegister() throws BiffException, IOException
	{
		return isElementPresent("Login", "RegisterButtonLabel");
	}

	public boolean verifyLabelHelpLine() throws Exception
	{
		return verifyLabelText("Login", "HelpLineLabel");
	}

	public boolean verifyLabelPrivacyPolicy() throws Exception
	{
		return verifyLabelText("Login", "PrivacyPolicyLink");
	}

	public boolean verifyLinkPrivacyPolicy() throws BiffException, IOException
	{
		return isElementPresent("Login", "PrivacyPolicyLink");
	}

	public boolean verifyLabelTermsOfService() throws Exception
	{
		return verifyLabelText("Login", "TermsOfServiceLink");
	}

	public boolean verifyLinkTermsOfService() throws BiffException, IOException
	{
		return isElementPresent("Login", "TermsOfServiceLink");
	}

	public boolean verifyLabelNoticeOfPrivacyPractices() throws Exception
	{
		return verifyLabelText("Login", "NoticeOfPrivacyPracticesLink");
	}

	public boolean verifyLinkNoticeOfPrivacyPractices() throws BiffException, IOException
	{
		return isElementPresent("Login", "NoticeOfPrivacyPracticesLink");
	}

	public boolean verifyLabelNondiscriminationNotice() throws Exception
	{
		return verifyLabelText("Login", "NondiscriminationNoticeLink");
	}

	public boolean verifyLinkNondiscriminationNotice() throws BiffException, IOException
	{
		return isElementPresent("Login", "NondiscriminationNoticeLink");
	}

	public boolean verifyValidationForUsername() throws Exception
	{
		return verifyLabelText("Login", "usernameError");
	}

	public boolean verifyValidationForPassword() throws Exception
	{
		return verifyLabelText("Login", "passwordError");
	}

	public boolean verifyURLRedirectToPolicyPrivate() throws Exception
	{
		return verifyURL("HealCredential", "PrivacyPolicy");
	}

	public boolean verifyURLRedirectToTermsOfService() throws Exception
	{
		return verifyURL("HealCredential", "TermsOfService");
	}

	public boolean verifyURLRedirectToNoticeOfPrivacyPractices() throws Exception
	{
		return verifyURL("HealCredential", "NoticeOfPrivacyPractices");
	}

	public boolean verifyURLRedirectToNondiscriminationNotice() throws Exception
	{
		return verifyURL("HealCredential", "NondiscriminationNotice");
	}

	public boolean verifyTitlePolicyPrivate() throws Exception
	{
		return verifyTitle("HealCredential", "PrivacyPolicyTitle");
	}

	public boolean verifyTitleTermsOfService() throws Exception
	{
		return verifyTitle("HealCredential", "TermsOfServiceTitle");
	}

	public boolean verifyTitleNoticeOfPrivacyPractices() throws Exception
	{
		return verifyTitle("HealCredential", "NoticeOfPrivacyPracticesTitle");
	}

	public boolean verifyTitleNondiscriminationNotice() throws Exception
	{
		return verifyTitle("HealCredential", "NondiscriminationNoticeTitle");
	}

	public boolean verifyHeaderPolicyPrivate() throws Exception
	{
		return verifyLabelText("HealCredential", "PrivacyPolicyHeader");
	}

	public boolean verifyHeaderTermsOfService() throws Exception
	{
		return verifyLabelText("HealCredential", "TermsOfServiceHeader");
	}

	public boolean verifyHeaderNoticeOfPrivacyPractices() throws Exception
	{
		return verifyLabelText("HealCredential", "NoticeOfPrivacyPracticesHeader");
	}

	public boolean verifyHeaderNondiscriminationNotice() throws Exception
	{
		return verifyLabelText("HealCredential", "NondiscriminationNoticeHeader");
	}

	public boolean verifyValidationMessage() throws Exception
	{
		return verifyLabelText("HealCredential", "validationerrormessage");
	}
}
