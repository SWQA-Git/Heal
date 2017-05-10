package lib.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Utilities
{

	private static String		dateFormat	= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private final static Logger	logger		= LogManager.getLogger(Utilities.class.getName());

	public Utilities()
	{}

	public static void executionStartedMethod() throws Exception
	{
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[2];
		String methodName = e.getMethodName();
		System.out.println("Execution Started Method " + methodName);
		logger.info("Execution Started Method " + methodName);
	}
	
	public static String getMethodName()
	{
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[3];
		String methodName = e.getMethodName();
		System.out.println("Method Name = " + methodName);
		return methodName;
	}

	public static void executionEndedMethod() throws Exception
	{
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[2];
		String methodName = e.getMethodName();
		System.out.println("Execution Ended Method " + methodName);
		logger.info("Execution Ended Method " + methodName);
	}

	public static String getDateAndTime()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMMyyyy_hhmmss");
		return sdf.format(cal.getTime());
	}

	public static String getTime()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	public static String addTime(int i)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, i);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	public static long getUTCTimestamp()
	{
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return DateUtils.truncate(Date.from(utc.toInstant()), Calendar.MILLISECOND).getTime();
	}

	public static String getTimestamp()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return simpleDateFormat.format(cal.getTime());
	}

	public static long timestampDifference(String expectedTimestamp, String actualTimestamp)
	{
		logger.info("Expected Timestamp=" + expectedTimestamp);
		logger.info("Actual Timestamp=" + actualTimestamp);

		Date expectedTime = parseTimestamp(expectedTimestamp);
		Date actualTime = parseTimestamp(actualTimestamp);

		long duration = expectedTime.getTime() - actualTime.getTime();
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) % 60;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) % 60;
		long milliseconds = duration % 1000;
		logger.info("Difference=" + String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds));

		return duration;
	}

	private static Date parseTimestamp(String timestamp)
	{
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date expectedTime = null;
		try
		{
			expectedTime = format.parse(timestamp);
		}
		catch (ParseException e)
		{
			logger.info("Cannot parse the time stamp" + timestamp + " using the expected format " + dateFormat);
			Assert.fail("Cannot parse the time stamp" + timestamp + " using the expected format", e);
		}
		return expectedTime;
	}

	public static String getTabId()
	{
		return "Expected TabId= " + getUnixTime();
	}

	public static void sleep(int millseconds)
	{
		try
		{
			Thread.sleep(millseconds);
		}
		catch (InterruptedException e)
		{
			logger.info("Thread.sleep was interrupted.", e);
		}
	}

	private static long getUnixTime()
	{
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}

	public static void waitForFile(File file)
	{
		long lastTouched = file.lastModified();
		while (getUnixTime() - lastTouched < 3000)
		{
			lastTouched = file.lastModified();
			Utilities.sleep(2000);
		}
	}

}
