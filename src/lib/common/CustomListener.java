package lib.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter
{
	private static Logger logger = LogManager.getLogger(CustomListener.class.getName());

	@Override
	public void onTestFailure(ITestResult tr)
	{
		logger.info(tr.getName() + "--                     *#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*# ");
		logger.info(tr.getName() + "--                        FFFFF     AA       II   LL ");
		logger.info(tr.getName() + "--                        FF       AAAA      II   LL");
		logger.info(tr.getName() + "--                        FFFF    AA  AA     II   LL");
		logger.info(tr.getName() + "--                        FF     AAAAAAAA    II   LL");
		logger.info(tr.getName() + "--                        FF    AA      AA   II   LLLLLL");
		logger.info(tr.getName() + "--                      *#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*# ");
		Throwable exception = tr.getThrowable();
		if (exception != null)
		{
			logger.info(exception.getMessage());
			for (StackTraceElement e : exception.getStackTrace())
			{
				logger.info(e.toString());
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr)
	{
		logger.info(tr.getName() + "--                      +++++++++++++++++++ Skipped +++++++++++++++ ");
		logger.info(tr.getName() + "--                      +++++++++++++++++++ Skipped +++++++++++++++ ");
		logger.info(tr.getName() + "--                      +++++++++++++++++++ Skipped +++++++++++++++ ");
		logger.info(tr.getName() + "--                      +++++++++++++++++++ Skipped +++++++++++++++ ");
	}

	@Override
	public void onTestSuccess(ITestResult tr)
	{
		logger.info(tr.getName() + "--                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ");
		logger.info(tr.getName() + "--                           OOO    KK KK     PPPPP      AA     SSSSSS SSSSSS  ");
		logger.info(tr.getName() + "--                          OO OO   KKK    == PP PPP    AAAA    SSS    SSS     ");
		logger.info(tr.getName() + "--                           OOO    KK KK     PPPPP    AA  AA   SSSSSS SSSSSS  ");
		logger.info(tr.getName() + "--                                            PP      AAAAAAAA     SSS    SSS  ");
		logger.info(tr.getName() + "--                                            PP     AA      AA SSSSSS SSSSSS  ");
		logger.info(tr.getName() + "--                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  ");
	}

}