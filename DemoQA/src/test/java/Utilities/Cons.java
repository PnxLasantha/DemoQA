package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;

public class Cons {
	  WebDriver driver;
	public Cons()
	{
		driver = HomePage.driver;
		
	}

	public static final String chrome_path = "E:\\Lasantha\\Auto\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe";
	public static final String Report_path = "E:\\Lasantha\\Auto\\WS\\DemoQA\\src\\test\\Reports\\Result.html";
	public static final String url = "http://demoqa.com";
	
	
	public void waitTime(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chrome_path);   
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:/Lasantha/Auto/Drivers/Gecko/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
	}
	
}
