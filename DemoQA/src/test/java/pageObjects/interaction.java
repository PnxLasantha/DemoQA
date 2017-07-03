package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	By darg_drop = By.id("ui-id-5");
	
	
	
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
	
	
	public void drag_drop()
	{
		driver.findElement(darg_drop).click();
		WebElement drag_1= driver.findElement(By.xpath("//*[@id='sortablebox']/li[1]"));
		new Actions(driver).dragAndDropBy(drag_1, 0, 100).build() .perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement drag_2= driver.findElement(By.xpath("//*[@id='sortablebox']/li[2]"));
		new Actions(driver).dragAndDropBy(drag_2, 0, 100).build() .perform();
		
		
	}
	
	
	

}
