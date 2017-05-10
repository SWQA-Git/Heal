package lib.common;

import java.io.IOException;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jxl.read.biff.BiffException;

public class WebPageVerifier
{
	private static final Logger	logger	= LogManager.getLogger(WebPageVerifier.class.getName());

	protected static TestDriver	driver;

	public boolean verifyErrorMessage(String pageName, String elementName, String expectedErrorMessage) throws Exception
	{
		String actualMessage = driver.getElement(pageName, elementName).getAttribute("data-original-title").toString();
		if (expectedErrorMessage.equalsIgnoreCase(actualMessage))
			return true;
		else
		{
			logger.info("Verification failed.\nExpected Result = " + expectedErrorMessage + "\nActual Result = " + actualMessage);
			System.out.println("Verification failed.\nExpected Result = " + expectedErrorMessage + "\nActual Result = " + actualMessage);
			return false;
		}
	}

	public WebPageVerifier() throws MalformedURLException
	{
		driver = TestDriver.getInstance();
	}

	public boolean verifyLabelText(String pageName, String elementName) throws Exception
	{
		String expectedResult = ConfigurationProperty.xlData.getValueFor(pageName, elementName);
		Thread.sleep(10000);
		// TODO: Remove this
		String actualResult = driver.getElement(pageName, elementName).getText();
		if (expectedResult.equals(actualResult))
		{
			logger.info("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return true;
		}
		else
		{
			logger.info("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return false;
		}
	}

	public boolean verifyURL(String pageName, String elementName) throws Exception
	{
		String expectedResult = ConfigurationProperty.xlData.getValueFor(pageName, elementName);
		String actualResult = driver.getCurrentURL();
		if (expectedResult.equals(actualResult))
		{
			logger.info("Verification Successfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return true;
		}
		else
		{
			logger.info("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return false;
		}
	}

	public boolean verifyTitle(String pageName, String elementName)
	{
		String expectedResult = ConfigurationProperty.xlData.getValueFor(pageName, elementName);
		String actualResult = driver.getTitle();
		if (expectedResult.equals(actualResult))
		{
			logger.info("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return true;
		}
		else
		{
			logger.info("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return false;
		}

	}

	public boolean isElementPresent(String sheetName, String elementName) throws BiffException, IOException
	{
		return driver.isElementPresent(sheetName, elementName);
	}

	public boolean verifyValue(String pageName, String elementName)
	{
		String expectedResult = ConfigurationProperty.xlData.getValueFor(pageName, elementName);
		String actualResult = driver.getElement(pageName, elementName).getAttribute("value");
		if (expectedResult.equals(actualResult))
		{
			logger.info("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification Sucessfully.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return true;
		}
		else
		{
			logger.info("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			System.out.println("Verification failed.\nExpected Result = " + expectedResult + "\nActual Result = " + actualResult);
			return false;
		}
	}
}
