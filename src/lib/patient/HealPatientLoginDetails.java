package lib.patient;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HealPatientLoginDetails
{
	private static final Logger				logger					= LogManager.getLogger(HealPatientLoginDetails.class.getName());
	private String							email;
	private String							password;
	private static HealPatientLoginDetails	instance;

	HealPatientLoginDetails					healPatientLoginDetails	= new HealPatientLoginDetails();

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
