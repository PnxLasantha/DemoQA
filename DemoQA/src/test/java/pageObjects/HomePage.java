package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	public static WebDriver driver;
	
	 public static ExtentReports extent;
	 public static ExtentTest test;
	 
	
	
	By Reg_page = By.id("menu-item-374");
	
	
	
	
	
	public void click_reg_page ()
	{
		
		driver.findElement(Reg_page).click();
		
	}
	
}
