package verification.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;
import lib.common.Browser;
import lib.common.ConfigurationProperty;
import lib.common.WebPageVerifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterPageVerifier extends WebPageVerifier
{
	public RegisterPageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger	logger	= LogManager.getLogger(HomePageVerifier.class.getName());
	WebPageVerifier				webPageVerifier;
	Browser						browser;
	ConfigurationProperty		cong;

	public boolean verifyURLRedirectToRegister() throws Exception
	{
		return verifyURL("Properties", "HealPatientRegisterURL");
	}

	public boolean verifyURLRedirectToLogin() throws Exception
	{
		return verifyURL("Properties", "HealPatientLoginURL");
	}

	public boolean verifyPageTitle()
	{
		return verifyTitle("HealRegistration", "Title");
	}

	// FIRST NAME
	public boolean verifyLabelFirstName() throws Exception
	{
		return verifyLabelText("HealRegistration", "FirstNameLabel");
	}

	public boolean verifyInputFieldFirstName() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "FirstName");
	}

	public boolean verifyValidationForFirstName() throws Exception
	{
		return verifyLabelText("HealRegistration", "FirstNameError");
	}

	// LAST NAME
	public boolean verifyLabelLastName() throws Exception
	{
		return verifyLabelText("HealRegistration", "LastNameLabel");
	}

	public boolean verifyInputFieldLastName() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "LastName");
	}

	public boolean verifyValidationForLastName() throws Exception
	{
		return verifyLabelText("HealRegistration", "LastNameError");
	}

	// EMAIL
	public boolean verifyLabelEmail() throws Exception
	{
		return verifyLabelText("HealRegistration", "EmailLabel");
	}

	public boolean verifyInputFieldEmail() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "Email");
	}

	public boolean verifyValidationForEmail() throws Exception
	{
		return verifyLabelText("HealRegistration", "EmailError");
	}

	// PASSWORD
	public boolean verifyLabelPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "PasswordLabel");
	}

	public boolean verifyInputFieldPassword() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "Password");
	}

	public boolean verifyValidationForPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "PasswordError");
	}

	// CONFIRM PASSWORD
	public boolean verifyLabelConfirmPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "ConfirmPasswordLabel");
	}

	public boolean verifyInputFieldConfirmPassword() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "ConfirmPassword");
	}

	public boolean verifyValidationForConfirmPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "ConfirmPasswordError");
	}

	// PHONE NUMBER
	public boolean verifyLabelPhoneNumber() throws Exception
	{
		return verifyLabelText("HealRegistration", "PhoneNumberLabel");
	}

	public boolean verifyInputFieldPhoneNumber() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "PhoneNumber");
	}

	public boolean verifyValidationForPhoneNumber() throws Exception
	{
		return verifyLabelText("HealRegistration", "PhoneNumberError");
	}

	// ZIP CODE
	public boolean verifyLabelZipCode() throws Exception
	{
		return verifyLabelText("HealRegistration", "ZipcodeLabel");
	}

	public boolean verifyInputFieldZipCode() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "Zipcode");
	}

	public boolean verifyValidationForZipCode() throws Exception
	{
		return verifyLabelText("HealRegistration", "ZipCodeError");
	}

	// REMEMBER ME
	public boolean verifyLabelRememberMe() throws Exception
	{
		return verifyLabelText("HealRegistration", "RememberMeLabel");
	}

	public boolean verifyCheckboxRememberMe() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "RememberMe");
	}

	// CREATE ACCOUNT
	public boolean verifyLabelCreateAccount() throws Exception
	{
		return verifyLabelText("HealRegistration", "CreateAccount");
	}

	public boolean verifyButtonCreateAccount() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "CreateAccount");
	}

	// LOGIN
	public boolean verifyLabelLogIn() throws Exception
	{
		return verifyLabelText("HealRegistration", "LogInLink");
	}

	public boolean verifyLinkLogIn() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "LogInLink");
	}

	// HELPLINE
	public boolean verifyLabelHelpLine() throws Exception
	{
		return verifyLabelText("HealRegistration", "HelpLineLabel");
	}

	// PRIVACY POLICY
	public boolean verifyLabelPrivacyPolicy() throws Exception
	{
		return verifyLabelText("HealRegistration", "PrivacyPolicy");
	}

	public boolean verifyLinkPrivacyPolicy() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "PrivacyPolicy");
	}

	public boolean verifyURLRedirectToPolicyPrivate() throws Exception
	{
		return verifyURL("HealCredential", "PrivacyPolicy");
	}

	public boolean verifyTitlePolicyPrivate() throws Exception
	{
		return verifyTitle("HealCredential", "PrivacyPolicyTitle");
	}

	public boolean verifyHeaderPolicyPrivate() throws Exception
	{
		return verifyLabelText("HealCredential", "PrivacyPolicyHeader");
	}

	// TERMS OF SERVICE
	public boolean verifyLabelTermsOfService() throws Exception
	{
		return verifyLabelText("HealRegistration", "TermsOfService");
	}

	public boolean verifyLinkTermsOfService() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "TermsOfService");
	}

	public boolean verifyURLRedirectToTermsOfService() throws Exception
	{
		return verifyURL("HealCredential", "TermsOfService");
	}

	public boolean verifyTitleTermsOfService() throws Exception
	{
		return verifyTitle("HealCredential", "TermsOfServiceTitle");
	}

	public boolean verifyHeaderTermsOfService() throws Exception
	{
		return verifyLabelText("HealCredential", "TermsOfServiceHeader");
	}

	// NOTICE OF PRIVACY PRATICES
	public boolean verifyLabelNoticeOfPrivacyPractices() throws Exception
	{
		return verifyLabelText("HealRegistration", "NoticeOfPrivacyPractices");
	}

	public boolean verifyLinkNoticeOfPrivacyPractices() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "NoticeOfPrivacyPractices");
	}

	public boolean verifyURLRedirectToNoticeOfPrivacyPractices() throws Exception
	{
		return verifyURL("HealCredential", "NoticeOfPrivacyPractices");
	}

	public boolean verifyTitleNoticeOfPrivacyPractices() throws Exception
	{
		return verifyTitle("HealCredential", "NoticeOfPrivacyPracticesTitle");
	}

	public boolean verifyHeaderNoticeOfPrivacyPractices() throws Exception
	{
		return verifyLabelText("HealCredential", "NoticeOfPrivacyPracticesHeader");
	}

	// NON DISCRIMINATION NOTICE
	public boolean verifyLabelNondiscriminationNotice() throws Exception
	{
		return verifyLabelText("HealRegistration", "NondiscriminationNotice");
	}

	public boolean verifyLinkNondiscriminationNotice() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "NondiscriminationNotice");
	}

	public boolean verifyURLRedirectToNondiscriminationNotice() throws Exception
	{
		return verifyURL("HealCredential", "NondiscriminationNotice");
	}

	public boolean verifyTitleNondiscriminationNotice() throws Exception
	{
		return verifyTitle("HealCredential", "NondiscriminationNoticeTitle");
	}

	public boolean verifyHeaderNondiscriminationNotice() throws Exception
	{
		return verifyLabelText("HealCredential", "NondiscriminationNoticeHeader");
	}

	// UNSUPPORTED ZIPCODE
	public boolean verifyLabelNotInArea() throws Exception
	{
		return verifyLabelText("HealRegistration", "NotInAreaLabel");
	}

	public boolean verifyLabelContinue() throws Exception
	{
		return verifyLabelText("HealRegistration", "ContinueLabel");
	}

	public boolean verifyLabelCont() throws Exception
	{
		return verifyLabelText("HealRegistration", "ContinueButton");
	}

	public boolean verifyButtonCont() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "ContinueButton");
	}

	public boolean verifyLabelOr() throws Exception
	{
		return verifyLabelText("HealRegistration", "Or");
	}

	public boolean verifyLabelNotify() throws Exception
	{
		return verifyLabelText("HealRegistration", "NotifyLabel");
	}

	public boolean verifyLabelNotifyMe() throws Exception
	{
		return verifyLabelText("HealRegistration", "NotifyMeButton");
	}

	public boolean verifyButtonNotifyMe() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "NotifyMeButton");
	}

	public boolean verifyLabelRegisterInDiffArea() throws Exception
	{
		return verifyLabelText("HealRegistration", "RegisterInDifferentArea");
	}

	public boolean verifyButtonRegisterInDiffArea() throws BiffException, IOException
	{
		return isElementPresent("HealRegistration", "RegisterInDifferentArea");
	}

	// UNSUPPORTED ZIPCODE VERIFCATION AFTER CLICK ON REGISTER IN DIFFERENT AREA
	public boolean verifyValueForFirstName()
	{
		return verifyValue("HealRegistration", "FirstName");
	}

	public boolean verifyValueForLastName()
	{
		return verifyValue("HealRegistration", "LastName");
	}

	public boolean verifyValueForPassword()
	{
		return verifyValue("HealRegistration", "Password");
	}

	public boolean verifyValueForConfirmPassword()
	{
		return verifyValue("HealRegistration", "ConfirmPassword");
	}

	public boolean verifyValueForPhoneNumber()
	{
		return verifyValue("HealRegistration", "PhoneNumber");
	}

	public boolean verifyValueForZipCode()
	{
		return verifyValue("HealRegistration", "RetainedUnsupportZipCode");
	}

	// VALIDATION MESSAGE WHILE REGISTER WITH EXISTING EMAIL
	public boolean verifyValidationForExistingUser() throws Exception
	{
		return verifyLabelText("HealRegistration", "ExistingEmailError");

	}

	// VALIDATION MESSAGE FOR MISMATCH PASSWORD
	public boolean verifyValidationForMismatchPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "PasswordMisMatchError");

	}

	// VALIDATION MESSAGE FOR INVALID PHONE NUMBER
	public boolean verifyValidationForInvalidPhoneNumber() throws Exception
	{
		return verifyLabelText("HealRegistration", "InvalidPhoneNumberError");
	}

	// VALIDATION MESSAGE FOR INVALID EMAIL ADDRESS
	public boolean verifyValidationForInvalidEmail() throws Exception
	{
		return verifyLabelText("HealRegistration", "InvalidEmailError");
	}

	// VALIDATION MESSAGE FOR INVALID COMBINATION OF PASSWORD
	public boolean verifyValidationForInvalidPassword() throws Exception
	{
		return verifyLabelText("HealRegistration", "InvalidPasswordError");
	}

	// FOOTER LINK VERIFICATION

}
