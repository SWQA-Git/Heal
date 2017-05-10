package verification.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import jxl.read.biff.BiffException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lib.common.WebPageVerifier;

public class PaymentMethodsPageVerifier extends WebPageVerifier
{
	public PaymentMethodsPageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LogManager.getLogger(PaymentMethodsPageVerifier.class.getName());

	public boolean verifyURLRedriectToRegister() throws Exception
	{
		return verifyURL("Properties", "HealPatientRegisterURL");
	}

	// HEADER - PAYMENT
	public boolean verifyHeader() throws Exception
	{
		return verifyLabelText("PaymentMethods", "PaymentsHeader");
	}

	// SUBHEADER - ADD PAYMENTS
	public boolean verifySubHeader() throws Exception
	{
		return verifyLabelText("PaymentMethods", "SubPaymentHeader");
	}

	// FIELD VERIFICTION - CARD NUMBER
	public boolean verifyCardNumberLabel() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardNumberLabel");
	}

	public boolean verifyInputFieldCardNumber() throws BiffException, IOException
	{
		return isElementPresent("PaymentMethods", "CardNumber");
	}

	// FIELD VERIFICTION - EXPIRATION
	public boolean verifyExpirationLabel() throws Exception
	{
		return verifyLabelText("PaymentMethods", "ExpirationLabel");
	}

	public boolean verifyInputFieldExpiration() throws BiffException, IOException
	{
		return isElementPresent("PaymentMethods", "Expiration");
	}

	// FIELD VERIFICTION - SECURITY CODE
	public boolean verifySecurityCodeLabel() throws Exception
	{
		return verifyLabelText("PaymentMethods", "SecurityCodeLabel");
	}

	public boolean verifyInputFieldSecurityCode() throws BiffException, IOException
	{
		return isElementPresent("PaymentMethods", "SecurityCode");
	}

	// BUTTON VERIFICTION - APPLY CARD
	public boolean verifyApplyCardLabel() throws Exception
	{
		return verifyLabelText("PaymentMethods", "ApplyCardButtonLabel");
	}

	public boolean verifyButtonApplyCard() throws BiffException, IOException
	{
		return isElementPresent("PaymentMethods", "ApplyCard");
	}

	// SUBHEADER - ADD PAYMENTS
	public boolean verifySubPaymentsDetails() throws Exception
	{
		return verifyLabelText("PaymentMethods", "SubPaymentsDetails");
	}

	// CARD BRAND - VISA
	public boolean verifyCardBrandVisa() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardBrandVisa");
	}

	// CARD BRAND - DinnersClub
	public boolean verifyCardBrandDinnersClub() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardBrandDinnersClub");
	}

	// CARD BRAND - American Express
	public boolean verifyCardBrandAmericanExpress() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardBrandAmrExpress");
	}

	// CARD NUMBER - 16Digits
	public boolean verifyCardNumber() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardNumb");
	}

	// CARD NUMBER - 15Digits
	public boolean verifyCardNumber15Digits() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardNumb15digits");
	}

	// CARD NUMBER - 14Digits
	public boolean verifyCardNumber14Digits() throws Exception
	{
		return verifyLabelText("PaymentMethods", "CardNumb14digits");
	}

	// EXPIRATION DATE
	public boolean verifyExpirationDate() throws Exception
	{
		return verifyLabelText("PaymentMethods", "ExpirationDate");
	}

	public boolean verifyExpirationDateInDiffFormat() throws Exception
	{
		return verifyLabelText("PaymentMethods", "VerifyExpirationDateInDiffFormat");
	}

	// EXPIRATION DATE - 14 Digits
	public boolean verifyExpirationDate14() throws Exception
	{
		return verifyLabelText("PaymentMethods", "ExpirationDate14");
	}

	// EXPIRATION DATE - 15 Digits
	public boolean verifyExpirationDate15() throws Exception
	{
		return verifyLabelText("PaymentMethods", "ExpirationDate15");
	}

	// EDIT PAYMENT BUTTON
	public boolean verifyEditPaymentButtonLabel() throws Exception
	{
		return verifyLabelText("PaymentMethods", "EditPaymentButton");
	}

	// VALIDATION OF INVALID CARD NUMBER
	public boolean verifyValidationForInvalidCardNumber() throws Exception
	{
		return verifyLabelText("PaymentMethods", "InvalidCardNumberError");
	}

	// VALIDATION OF BLANK CARD NUMBER
	public boolean verifyValidationForBlankCardNumber() throws Exception
	{
		return verifyLabelText("PaymentMethods", "BlankCardNumberError");
	}

	// VALIDATION OF INVALID EXPIRY DATE
	public boolean verifyValidationForInvalidExpirationDate() throws Exception
	{
		return verifyLabelText("PaymentMethods", "InvalidExpiryError");
	}

	// VALIDATION OF BLANK EXPIRY DATE
	public boolean verifyValidationForBlankExpirationDate() throws Exception
	{
		return verifyLabelText("PaymentMethods", "BlankExpiryError");
	}

	// VALIDATION OF INVALID SECURITY CODE
	public boolean verifyValidationForInvalidSecurityCode() throws Exception
	{
		return verifyLabelText("PaymentMethods", "InvalidSecutiyError");
	}

	// VALIDATION OF BLANK SECURITY CODE
	public boolean verifyValidationForBlankSecurityCode() throws Exception
	{
		return verifyLabelText("PaymentMethods", "BlankSecurityError");
	}
}
