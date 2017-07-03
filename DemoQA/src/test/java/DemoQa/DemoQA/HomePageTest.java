package DemoQa.DemoQA;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Cons;
import Utilities.GetScreenshot;
import pageObjects.HomePage;

public class HomePageTest {
	
	@BeforeTest (description = "Starting the Browser and Reports")
	@Parameters("browser")
	public void setupdriver(String browser)
	{		  
		//System.setProperty("webdriver.chrome.driver", Cons.chrome_path);   
		//HomePage.driver = new ChromeDriver();
		//Cons setupbrowser = new Cons();
		//setupbrowser.setbrowser(browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Cons.chrome_path);   
			HomePage.driver = new ChromeDriver();
			HomePage.driver.get(Cons.url);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:/Lasantha/Auto/Drivers/Gecko/geckodriver.exe");
			HomePage.driver = new FirefoxDriver();
			HomePage.driver.get(Cons.url);
		}
		
		
		
		
		
		
		
		HomePage.extent = new ExtentReports(Cons.Report_path);
		HomePage.test = HomePage.extent.startTest("Home Page");
		HomePage.extent
					.addSystemInfo("Project","DemoQA Test")
					.addSystemInfo("Environment","Web")
					.addSystemInfo("Test Designee","Lasantha");
		
		
	
		
	}
	

	@BeforeMethod
	public void beforeMethod(Method method) {
	    Test annotation_test = method.getAnnotation(Test.class);	    
	    String temp_message =("Starting " + annotation_test.description());
	    HomePage.test.assignCategory("Smoke Test");
	 
	    HomePage.test.log(LogStatus.INFO, temp_message);
	    
	}
	
	@Test (description = "Switching Tabs 1 to 5",priority=0)
	public void switch_tabs()
	{
		HomePage hm = new HomePage();
		hm.switch_tabs();
		
		
	}
	
	@Test (description = "Clicking the Registration Page",priority=1)
	public void Homepg()
	{
		
		HomePage hm = new HomePage();
		hm.click_reg_page();
		
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
	

	 @AfterTest
	    public void endreport()
	    {
		 
		  
		 System.out.println("INSIDE HomePageTest.java");
		 //HomePage.extent.flush();
		
		 
		 //HomePage.extent.close();
	        
	    }
	

}
