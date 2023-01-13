package Shairu;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class dataConfig 
{
	public static WebDriver dr;
	File file;
	static FileInputStream fis;
	static Properties prop;
	static String value;
	
	public static String getData(String key) throws Exception
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/Shairu/data.properties");
		prop = new Properties();
		prop.load(fis);
		value = prop.getProperty(key);
		return value;
	}
}
