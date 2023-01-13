package Shairu;

import org.openqa.selenium.chrome.ChromeDriver;

public class browserConfig extends methodConfig
{
	String chromePath = dataConfig.getData("chromeDriver");
	String chromeDirPath = System.getProperty("user.dir");
	
	public browserConfig() throws Exception
	{
		super();
	}

	public void setBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromeDirPath+chromePath);
			dr = new ChromeDriver();
		}
		else
		{
			System.out.println("Chrome Browser might be getting updated or Not set properly.");
		}
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
	}
	
	public void openBrowser() throws Exception
	{
		setBrowser(dataConfig.getData("browser"));
		loadPage(dataConfig.getData("site"));
	}
	
	public void closeBrowser()
	{
		dr.quit();
		//dr.close();
	}
}
