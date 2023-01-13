package scripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Shairu.Utils;
import Shairu.browserConfig;
import Shairu.methodConfig;

public class loginSite extends methodConfig
{
	browserConfig brConObj = new browserConfig();
	public static Logger log = Logger.getLogger(loginSite.class.getName());
	
	public By usernamefield = By.xpath("//span[@class='ant-input-affix-wrapper ant-input-affix-wrapper-lg']/input");
	public By passwordfield = By.xpath("//span[@class='ant-input-affix-wrapper ant-input-password ant-input-password-large ant-input-affix-wrapper-lg']/input");
	public By loginBtn = By.xpath("//button/span[text()='Login']");
	public By logoutDropdown = By.xpath("//span[@class='anticon anticon-down']");
	public By logout = By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/ul/li[2]/span/span[text()='Logout']");  //ant-dropdown ant-dropdown-placement-bottomRight  ant-slide-up-enter ant-slide-up-enter-prepare ant-slide-up
	
	loginSite() throws Exception
	{
		//super();
		
		brConObj.openBrowser();
	}
	
	@Test(priority = 1)
	public void loginpage() throws Exception
	{
		enterValueIn(usernamefield,"username");
		enterValueIn(passwordfield, "password");
		
		clickOnElement(loginBtn);
		
		Assert.assertFalse(getURL().contains("user/list"),"User enter not valid credential and taken logged in.");
		log.info("User entered valid credential and redirected into User List screen."); // 		
	}
	
	@Test(priority = 2)
	public void logout() throws Exception
	{
		Utils.waitForTime(2000);
		
		if(getURL().contains("user/list"))
		{
			clickOnElement(logoutDropdown);
			Utils.waitForTime(500);
			clickOnElement(logout);
			Assert.assertFalse(getURL().equalsIgnoreCase("http://13.235.108.14/"), "User enter not logged out properly.");
			log.info("User Logged out Successfully.");
			
			//brConObj.closeBrowser();
		}
		else
		{
			log.info("Browser is fetching wrong URL.");
		}
	}
		
}
