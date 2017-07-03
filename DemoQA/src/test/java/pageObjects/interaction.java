package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class interaction {
	
	WebDriver driver; 
	
	public interaction()
	{
		driver = HomePage.driver;                                                                                                          
		
	}
	
	
	
	By default_option = By.id("draggable");
	
	
	public void default_functionality()
	{
		
		WebElement drag= driver.findElement(default_option);
		new Actions(driver).dragAndDropBy(drag, 0, 300).build() .perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Actions(driver).dragAndDropBy(drag, 0, -300).build() .perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Actions(driver).dragAndDropBy(drag, 0, 100).build() .perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

}
