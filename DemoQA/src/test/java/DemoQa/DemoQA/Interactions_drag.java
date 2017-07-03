package DemoQa.DemoQA;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.GetScreenshot;
import pageObjects.HomePage;
import pageObjects.interaction;

public class Interactions_drag {

	@BeforeClass
	public void swtchingtoclass()
	{
		HomePage.driver.findElement(By.id("menu-item-140")).click();
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
	    Test annotation_test = method.getAnnotation(Test.class);	    
	    String temp_message =("Starting " + annotation_test.description());
	    HomePage.test = HomePage.extent.startTest(annotation_test.description());
	    HomePage.test.log(LogStatus.INFO, temp_message);
	    HomePage.test.assignCategory("Functional Test");
	}
	
	
	
	@Test(description = "Defaul Drag option",priority=6)
	public void dragelement()
	{
		interaction drag = new interaction();
		drag.default_functionality();
		
	}
	
	@Test(description = "Dragable",priority=7)
	public void drag()
	{

		interaction drag = new interaction();
		drag.drag_drop();
		
		
	}
	
	@Test(description = "Drag and drop",priority=8)
	public void drag_drop()
	{
		interaction drop = new interaction();
		drop.drop();
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result,Method method) throws IOException 
	{
		Test annotation_test = method.getAnnotation(Test.class);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenShotPath = GetScreenshot.capture(HomePage.driver, "screenShotName");
            HomePage.test.log(LogStatus.FAIL, result.getThrowable());
            HomePage.test.log(LogStatus.FAIL, "Snapshot below: " + HomePage.test.addScreenCapture(screenShotPath));
           
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String temp_message = annotation_test.description() + " Successful ";
			HomePage.test.log(LogStatus.INFO, temp_message );
		}
		
		HomePage.extent.endTest(HomePage.test);
	}
	
	@AfterClass
	public void swtchingback()
	{
		
	//	HomePage hm = new HomePage();
		//hm.goBack();
	}
	
	@AfterTest
    public void endreport()
    {
	 System.out.println("INSIDE Interacation page.java");
	/* HomePage.driver.close();*/
	 HomePage.extent.flush();
	 HomePage.extent.close();
        
    }
	
	
}
