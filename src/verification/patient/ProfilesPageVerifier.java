package verification.patient;

import java.net.MalformedURLException;

import lib.common.WebPageVerifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfilesPageVerifier extends WebPageVerifier
{
	public ProfilesPageVerifier() throws MalformedURLException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LogManager.getLogger(ProfilesPageVerifier.class.getName());

	public boolean verifyHeader() throws Exception
	{
		return verifyLabelText("Profiles", "Header");
	}

	public boolean verifySubHeader() throws Exception
	{
		return verifyLabelText("Profiles", "SubHeader");
	}

	public boolean verifySubHeaderForExistingPatient() throws Exception
	{
		return verifyLabelText("Profiles", "SubHeaderForEP");
	}

	public boolean verifyInsuranceHeader() throws Exception
	{
		return verifyLabelText("Profiles", "PatientInfoHeader");
	}

	public boolean verifyInsuranceProviderLabel() throws Exception
	{
		return verifyLabelText("Profiles", "InsuranceProviderLabel");
	}

	public boolean verifyMemberIDLabel() throws Exception
	{
		return verifyLabelText("Profiles", "MemberIDLabel");
	}

	public boolean verifyGroupIDLabel() throws Exception
	{
		return verifyLabelText("Profiles", "GroupIDLabel");
	}

}
