package lib.common;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jxl.read.biff.BiffException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDriver
{

	private WebDriver				webDriver;
	private static TestDriver		testDriver		= null;
	private final static Logger		logger			= LogManager.getLogger(TestDriver.class.getName());
	private ConfigurationProperty	config;
	private DesiredCapabilities		desiredCapabilities;
	private final String			USERNAME;
	private final String			ACCESS_KEY;
	private final String			ON_DEMAND;
	private final String			URL;
	private static final int		TIMEOUT_SECONDS	= 60;
	private String					sessionID		= null;

	public String getSessionID()
	{
		return sessionID;
	}

	public void setSessionID(String sessionID)
	{
		this.sessionID = sessionID;
	}

	public TestDriver(String browserName, String env) throws MalformedURLException
	{
		config = ConfigurationProperty.getInstance();
		USERNAME = config.getDataValue("Properties", "sauceLabsUsername");
		ACCESS_KEY = config.getDataValue("Properties", "sauceLabsAccessKey");
		ON_DEMAND = config.getDataValue("Properties", "sauceLabsOnDemands");
		URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@" + ON_DEMAND;
		initializeAndGetSessionID(browserName, env);
	}

	public static TestDriver getNewInstance() throws MalformedURLException
	{
		testDriver = null; 
		testDriver = new TestDriver("Browser", "ExecuteOn");
		return testDriver;
	}
	public static TestDriver getInstance() throws MalformedURLException
	{
		if(testDriver == null) 
		testDriver = new TestDriver("Browser", "ExecuteOn");
		return testDriver;
	}

	public void remoteWebDriver()
	{
		try
		{
			webDriver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String initializeAndGetSessionID(String browserName, String env) throws MalformedURLException
	{

		String browser = config.getDataValue("Properties", browserName);
		
		String executeOn = config.getDataValue("Properties", env);
		logger.info("Browser=" + browser);
		logger.info("Env=" + executeOn);
		if (executeOn.equals("SauceLab"))
		{
			// Fetch the values
			String recordVideo = config.getDataValue("Properties", "recordVideo");
			String recordScreenshots = config.getDataValue("Properties", "recordScreenshots");
			String screenResolution = config.getDataValue("Properties", "screenResolution");
			String browserVersion = config.getDataValue("Properties", "version");
			String operatingSystem = config.getDataValue("Properties", "platform");

			switch (browser)
			{
				case "Firefox":
					desiredCapabilities = DesiredCapabilities.firefox();
					break;
				case "InternetExplorer":
					desiredCapabilities = DesiredCapabilities.internetExplorer();
					break;
				case "Chrome":
					desiredCapabilities = DesiredCapabilities.chrome();
					break;
				case "Safari":
					desiredCapabilities = DesiredCapabilities.safari();
					desiredCapabilities.setCapability("seleniumVersion", "3.3.1");
					desiredCapabilities.setCapability("SafariDriver", "2.48");
					break;

			}
			// Set the values
			desiredCapabilities.setCapability("platform", operatingSystem);
			desiredCapabilities.setCapability("recordVideo", recordVideo);
			desiredCapabilities.setCapability("recordScreenshots", recordScreenshots);
			desiredCapabilities.setCapability("screenResolution", screenResolution);
			desiredCapabilities.setCapability("version", browserVersion);
			desiredCapabilities.setCapability("passed", true);
			desiredCapabilities.setCapability("name", Utilities.getMethodName());
			webDriver = new RemoteWebDriver(new URL(URL), desiredCapabilities);

			logger.info("Session ID = " + (((RemoteWebDriver) webDriver).getSessionId()).toString());
			sessionID = (((RemoteWebDriver) webDriver).getSessionId()).toString();

		}
		else if (executeOn.equals("Locally"))
		{
			switch (browser)
			{
				case "Firefox":
					webDriver = new FirefoxDriver();
					break;
				case "InternetExplorer":
					System.setProperty("webdriver.ie.driver", config.getDriver("IEDriverServer.exe"));
					DesiredCapabilities iEDesiredCapabilities = DesiredCapabilities.internetExplorer();
					iEDesiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					iEDesiredCapabilities.setCapability("ignoreZoomSetting", true);
					webDriver = new InternetExplorerDriver(iEDesiredCapabilities);
					break;
				case "Chrome":
					// logger.info("Path to Driver:
					// "+config.getPath("ChromeDriver"));
					System.setProperty("webdriver.chrome.driver", config.getDriver("chromedriver.exe"));
					DesiredCapabilities chromeDesiredCapabilities = DesiredCapabilities.chrome();
					webDriver = new ChromeDriver(chromeDesiredCapabilities);
					break;
				case "Safari":
					break;
			}
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Long.parseLong(config.getDataValue("Properties", "timeout")), TimeUnit.SECONDS);
		}
		return sessionID;
	}

	public void closeBrowser()
	{
		if (webDriver.toString().contains("null"))
		{
			logger.info("Trying to close already closed browser..");
		}
		else
		{
			logger.info("Browser: QUIT");
			webDriver.quit();
		}
	}

	public void waitForElementPresent(String sheetName, String elementName) throws IOException, BiffException, NoSuchElementException
	{
		WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((config.xlLocation.getValueFor(sheetName, elementName)))));
	}

	public void refreshPage()
	{
		webDriver.navigate().refresh();
	}

	void doubleClickOn(WebElement element)
	{
		Actions action = new Actions(webDriver).doubleClick(element);
		action.build().perform();
	}

	public void mouse_Hover(int times)
	{
		try
		{
			for (int i = 0; i < times; i++)
			{
				Robot robot = new Robot();
				robot.mouseMove((int) (Math.random() * 1024), (int) (Math.random() * 786));
				robot.delay(1000);
			}
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}

	}

	public Dimension getOriginalSize()
	{
		return webDriver.manage().window().getSize();
	}

	public void resizeWindow(int dimensionX, int dimensionY)
	{
		Dimension dimension = new Dimension(dimensionX, dimensionY);
		webDriver.manage().window().setSize(dimension);
	}

	public Point getLocation(WebElement webElement)
	{
		return webElement.getLocation();
	}

	/*
	 * public void mouse_Hover(String sheetName, String menuElement, String
	 * elementName) { Actions actions = new Actions(webDriver);
	 * actions.moveToElement
	 * (webDriver.findElement(By.xpath(config.getLocationValue(sheetName,
	 * menuElement)))).build().perform();
	 * actions.moveToElement(webDriver.findElement
	 * (By.xpath(config.getLocationValue(sheetName, elementName)))).click(); }
	 */

	public void mouseHoverAndGetTooltip(WebElement webElement)
	{
		Actions actions = new Actions(webDriver);
		actions.moveToElement(webElement).click().build().perform();
		WebElement tooltip = webDriver.findElement(By.className("highcharts-tooltip"));
		if (tooltip.isDisplayed()) logger.info(tooltip.getText() + " displayed");

	}

	public void dragAndDrop(String sheetName, String source, String target)
	{
		Actions actions = new Actions(webDriver);
		WebElement targetWebElement = webDriver.findElement(By.xpath(config.getLocationValue(sheetName, target)));
		WebElement sourceWebElement = webDriver.findElement(By.xpath(config.getLocationValue(sheetName, source)));
		actions.dragAndDrop(sourceWebElement, targetWebElement).perform();
	}

	public void drag_Drop(String pageName, String source, String target)
	{
		Utilities.sleep(2000);
		Actions builder = new Actions(webDriver);
		WebElement sourceWebElement = webDriver.findElement(By.xpath(source));
		WebElement targetWebElement = webDriver.findElement(By.xpath(config.getLocationValue(pageName, target)));
		builder.dragAndDrop(sourceWebElement, targetWebElement).perform();
	}

	public void selectFrame(String sheetName, String elementName)
	{
		webDriver.switchTo().frame(webDriver.findElement(By.xpath((config.getLocationValue(sheetName, elementName)))));
	}

	public String getWindowHandle()
	{
		return webDriver.getWindowHandle();
	}

	public Set<String> getWindowHandles()
	{
		return webDriver.getWindowHandles();
	}

	public void switchWindow(String windowID)
	{
		webDriver.switchTo().window(windowID);
		logger.info("Switched To=" + webDriver.getTitle());
	}

	public void switchTabLtoR()
	{
		Actions actions = new Actions(webDriver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	}

	public void switchToTab(int i)
	{
		Actions actions = new Actions(webDriver);
		actions.keyDown(Keys.CONTROL).sendKeys(Integer.toString(i)).build().perform();
	}

	public void clickOnDynValue(String pageName, String elementName, String selectValue)
	{
		List<WebElement> select = webDriver.findElements(By.xpath(config.getLocationValue(pageName, elementName)));
		System.out.println("Size of the list:" + select.size());
		for (int i = 0; i < select.size(); i++)
		{
			WebElement element = select.get(i);
			String value = element.getText();
			System.out.println("Values " + i + ":" + value);
			if (value.equalsIgnoreCase(config.getDataValue(pageName, selectValue)))
			{
				element.click();
				break;
			}
		}
	}

	public void focusOnMainWindow()
	{
		ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs2.get(1)).close();
		webDriver.switchTo().window(tabs2.get(0));
	}

	public void focusOnNewTab()
	{
		ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs2.get(1));
		// webDriver.close();
		// webDriver.switchTo().window(tabs2.get(0));
	}

	public void navigateBack()
	{
		webDriver.navigate().back();
	}

	public String getPageSource()
	{
		return webDriver.getPageSource();
	}

	public void clickOn(String elementName)
	{
		webDriver.findElement(By.xpath(elementName)).click();
	}

	public WebElement getElement(String sheetName, String elementName)
	{
		return webDriver.findElement(By.xpath(config.getLocationValue(sheetName, elementName)));
	}

	public String replacePath(String sheetName, String elementName, int i)
	{
		String path = config.getLocationValue(sheetName, elementName);
		String pathChange = path + "[" + i + "]";
		return path.replace(path, pathChange);
	}

	public WebElement getElementByClassname(String className)
	{
		return webDriver.findElement(By.className(className));
	}

	public WebElement getElement(String selector)
	{
		return webDriver.findElement(By.cssSelector(selector));
	}

	public void scrollToElement(WebElement webElement)
	{
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public void scrollUpDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollTo(0, 250)", "");
		Utilities.sleep(1000);
		jse.executeScript("window.scrollBy(0,-250)", "");

	}

	public double getSize(String sheetName, String elementName)
	{
		return webDriver.findElement(By.xpath(config.getLocationValue(sheetName, elementName))).getSize().getWidth();
	}

	public double getWidthOfElement(String sheetName, String elementName)
	{
		return webDriver.findElement(By.cssSelector(config.getLocationValue(sheetName, elementName))).getSize().getWidth();
	}

	public List<WebElement> getElements(String sheetName, String elementName)
	{
		return webDriver.findElements(By.xpath(config.getLocationValue(sheetName, elementName)));
	}

	public String getFieldValue(String pageName, String elementName)
	{
		WebElement element = webDriver.findElement(By.xpath(config.getLocationValue(pageName, elementName)));
		return element.getText();
	}

	public WebElement getElementDirectly(String xPathLocation)
	{
		return webDriver.findElement(By.xpath(xPathLocation));
	}

	public List<WebElement> getElementsDirectly(String xPathLocation)
	{
		return webDriver.findElements(By.xpath(xPathLocation));
	}

	public void loadURL(String url)
	{
		webDriver.get(url);
	}

	public String getCurrentURL()
	{
		return webDriver.getCurrentUrl();
	}

	public String getTitle()
	{
		return webDriver.getTitle();
	}

	public boolean isElementPresent(String sheetName, String elementName)
	{
		try
		{
			return webDriver.findElement(By.xpath(config.getLocationValue(sheetName, elementName))).isDisplayed();
		}
		catch (NoSuchElementException exception)
		{
			return false;
		}
	}

	public boolean isElementEnabled(String sheetName, String elementName)
	{
		try
		{
			return webDriver.findElement(By.xpath(config.getLocationValue(sheetName, elementName))).isEnabled();
		}
		catch (NoSuchElementException exception)
		{
			return false;
		}
	}

	public void openInNewTab(String sheetName, String linkText)
	{
		logger.info("Open New Tab : " + linkText);
		WebElement webElement = webDriver.findElement(By.xpath(config.getLocationValue(sheetName, linkText)));
		Actions actions = new Actions(webDriver);
		actions.keyDown(Keys.CONTROL).click(webElement).build().perform();
	}

	public void switchToNewTab()
	{
		try
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
	}

	public void openInNewTab(String sheetName, String linkText, String subElement)
	{
		logger.info("Open New Tab : on " + getCurrentURL() + " : " + linkText);
		Actions actions = new Actions(webDriver);
		WebElement webElement = webDriver.findElement(By.xpath(config.getLocationValue(sheetName, linkText)));
		actions.moveToElement(webElement).build().perform();
		WebElement subWebElement = webDriver.findElement(By.xpath((config.getLocationValue(sheetName, subElement))));
		actions.keyDown(Keys.CONTROL).click(subWebElement).build().perform();
	}

	public void closeTab()
	{
		logger.info("Closed Tab=" + webDriver.getTitle());
		webDriver.close();
	}

	public void open_closedTab()
	{
		webDriver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.SHIFT + "t");
		List<String> tabs = new ArrayList<>(getWindowHandles());
		webDriver.switchTo().window(tabs.get(1));
		logger.info("Reopened Tab=" + webDriver.getTitle());
	}

	public List<WebElement> selectFromDropDown(String pageName, String elementName)
	{
		WebElement select = webDriver.findElement(By.xpath(config.getLocationValue(pageName, elementName)));
		Select dropDown = new Select(select);
		return dropDown.getOptions();
	}

	public void clickLink(String link)
	{
		webDriver.findElement(By.linkText(link)).click();
	}

	public int getCount(String sheetName, String elementName)
	{
		/*
		 * WebElement address =
		 * webDriver.findElement(By.xpath(config.getLocationValue(sheetName,
		 * elementName))); Select select = new Select(address); List<WebElement>
		 * elem = select.getOptions(); return elem.size();
		 */

		List<WebElement> services = webDriver.findElements(By.className("md-ink-ripple"));
		return services.size();
	}

	public void clickOnActions(String sheetName, String elementName)
	{
		Actions act = new Actions(webDriver);
		act.moveToElement(webDriver.findElement(By.xpath(config.getLocationValue(sheetName, elementName)))).click().build().perform();
	}

}
