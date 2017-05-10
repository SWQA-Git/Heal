package lib.common;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

// This is the configuration singleton class
// It reads all data from two Excel Files, Data.xls and Location.xls that are
// used in the tests.

public class ConfigurationProperty
{
	private final static Logger				logger		= LogManager.getLogger(ConfigurationProperty.class.getName());
	private static ConfigurationProperty	instance	= null;

	public static XLReader					xlData		= null;
	static XLReader							xlLocation	= null;
	private Properties						config		= null;
	private String							localpath	= System.getProperty("user.dir");

	public static ConfigurationProperty getInstance()
	{
		if (instance == null)
		{
			instance = new ConfigurationProperty();
		}
		return instance;
	}

	private ConfigurationProperty()
	{
		String dataXLPath = localpath + "\\Data.xls";
		String locationXLPath = localpath + "\\Location.xls";
		// String propertyPath = localpath + "/uitest.properties";

		xlData = new XLReader(dataXLPath);
		xlLocation = new XLReader(locationXLPath);
		config = new Properties();
		// try {
		//
		// //File configFile = new File(propertyPath);
		// //FileReader configReader = new FileReader(configFile);
		//// config.load(configReader);
		//// configReader.close();
		// } catch (FileNotFoundException e) {
		// //logger.fatal("FileNotFoundException while opening config file "
		// // + propertyPath, e);
		// Assert.fail("FileNotFoundException while opening config file "
		// + propertyPath, e);
		// } catch (IOException e) {
		// logger.fatal("IOException while reading/closing config file "
		// + propertyPath, e);
		// Assert.fail("IOException while reading/closing config file "
		// + propertyPath, e);
		// }

	}

	public String getDataValue(String sheet, String element)
	{
		String value = xlData.getValueFor(sheet, element);
		if (value == null)
		{
			logger.fatal("No element " + element + " found in Data.xls sheet " + sheet);
			Assert.fail("No element " + element + " found in Data.xls sheet " + sheet);
		}
		return value;
	}

	String getLocationValue(String sheet, String element)
	{
		String value = xlLocation.getValueFor(sheet, element);
		if (value == null)
		{
			logger.fatal("No element " + element + " found in Location.xls sheet " + sheet);
			Assert.fail("No element " + element + " found in Location.xls sheet " + sheet);
		}
		return value;
	}

	public List<String> getDataValues(String sheet, String element)
	{
		return xlData.getValuesFor(sheet, element);
	}

	public String getPath(String key)
	{
		String value = config.getProperty(key);
		if (value.startsWith("/") || value.startsWith("C:") || value.startsWith("c:"))
		{
			return value;
		}
		else
		{
			return localpath + System.getProperty("file.separator") + value;
		}
	}

	public String getDriver(String key)
	{

		return localpath + System.getProperty("file.separator") + key;

	}
}
