package Com.generic;

//package VDOhire_KeywordDriven.VDOhire_KeywordDriven.Com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver launchBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\exefiles\\chromedriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--headless");
				driver=new ChromeDriver();
				
			}
			
			else
			{
				driver=new ChromeDriver();
			}
		}
		return driver;	
	}
	
	public Properties initproperties() throws FileNotFoundException
	{
		
		prop=new Properties();
		
		File file=new File("C:\\Users\\vinda\\eclipse-workspace\\VDOhire_KeywordDriven\\Config");
		FileInputStream fis=new FileInputStream(file);
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
