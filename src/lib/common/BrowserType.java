package lib.common;

public enum BrowserType
{
	FIREFOX("Firefox"),
	CHROME("Chrome"),
	INTERNET_EXPLORER("InternetExplorer"),
	SAFARI("Safari");
		
	private final String browserType;
	private BrowserType(final String text) {this.browserType = text;}
	public String toString() { return browserType; }
}
