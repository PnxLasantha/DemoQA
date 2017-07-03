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
	By Drag_page = By.id("menu-item-140");
	By Drop_page = By.id("menu-item-141");
	By tab_2 = By.xpath("//*[@id='tab_ul']/li[2]");
	By tab_2_text = By.xpath("//*[@id='tabs-2']/p[2]");
	
	
	
	
	
	
	public void click_reg_page ()
	{
		
		driver.findElement(Reg_page).click();
		
	}
	
	public void switch_tabs()
	{
		
		driver.findElement(tab_2).click();
		String s =driver.findElement(By.xpath("//*[@id='tabs-2']/p[2]")).getText();
		System.out.println(s);
	
	}
	
	public void DragPage()
	{
		
		driver.findElement(Drag_page).click();
	}
	
	public void DropPage()
	{
		driver.findElement(Drop_page).click();
	}
	
}
