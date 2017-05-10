package lib.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.saucelabs.saucerest.SauceREST;

import jxl.read.biff.BiffException;

public class TestBase
{
	protected TestDriver	driver;
	protected SauceREST		sauceREST;
	ConfigurationProperty	config	= ConfigurationProperty.getInstance();

	public TestBase() throws NullPointerException, BiffException, IOException
	{
//		initializeDriver();
		String sauceUserName = config.getDataValue("Properties", "sauceLabsUsername");
		String sauceAccessKey = config.getDataValue("Properties", "sauceLabsAccessKey");

		if (sauceREST == null) sauceREST = new SauceREST(sauceUserName, sauceAccessKey);
	}

	public void initializeDriver() throws BiffException, IOException, NullPointerException
	{
		driver = TestDriver.getNewInstance();
	}

	public void closeBrowser()
	{
		driver.closeBrowser();
	}

	public TestDriver getDriver()
	{
		return driver;
	}

	public void setDriver(TestDriver driver)
	{
		this.driver = driver;
	}

	public void failTest(String sessionID)
	{
		sauceREST.jobFailed(sessionID);
		Assert.fail();
	}
	public void updateTestName(String sessionID)
	{
		Map<String, Object> update = new HashMap<>();
		update.put("name", Utilities.getMethodName());
		sauceREST.updateJobInfo(sessionID, update);
	}
}
