package Shairu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class methodConfig extends dataConfig
{
	public methodConfig() throws Exception
	{
		super();
	}
	
	public void loadPage(String url)
	{
		dr.get(url);
		
	}
	
	public void enterValueIn(By usernamefield, String value) throws Exception
	{
		dr.findElement(usernamefield).sendKeys(dataConfig.getData(value));;
	}
	
	public void clickOnElement(By button)
	{
		dr.findElement(button).click();
	}
	
	public String getURL()
	{
		return dr.getCurrentUrl();
	}

}
