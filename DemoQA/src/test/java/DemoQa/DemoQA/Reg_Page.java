package DemoQa.DemoQA;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Cons;
import Utilities.GetScreenshot;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;


public class Reg_Page {

	  
	
	@BeforeTest (description = "Starting the Browser and Reports")
	public void setupdriver()
	{		  
		System.setProperty("webdriver.chrome.driver", Cons.chrome_path);   
		HomePage.driver = new ChromeDriver();
		HomePage.driver.get("http://demoqa.com");
		HomePage.extent = new ExtentReports(Cons.Report_path);
		HomePage.test = HomePage.extent.startTest("DemoQA WebSite");
		HomePage.test.assignCategory("Smoke");
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
	    Test annotation_test = method.getAnnotation(Test.class);	    
	    String temp_message =("Starting " + annotation_test.description());
	    HomePage.test.log(LogStatus.INFO, temp_message);
	    
	}
	
	
	@Test (description = "Clicking the Registration Page")
	public void Homepg()
	{
		HomePage hm = new HomePage();
		hm.click_reg_page();
		
	}
	
	
	
	@Test(description = "Customer Registration")
	public void Registration()
	{
		
		HomePage.test.log(LogStatus.INFO, "Starting Registration");
		RegistrationPage reg = new RegistrationPage();
		reg.SetNames();
		reg.setMstatus();
		reg.setHobby();
		reg.setCountry();
		reg.setDateOfBirth();
		reg.setPhone();
		reg.setUserName();
		reg.setEmail();
		reg.setprofPic();
		
		reg.setDescription();
		reg.setPasswords();
		reg.submitbutton();
		//HomePage.test.log(LogStatus.INFO, "Registration Done");
		
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
	}
	
	
	 @AfterTest
	    public void endreport()
	    {
	      //  driver.close();
		 HomePage.extent.flush();
		 HomePage.extent.close();
	        
	    }
	

}
