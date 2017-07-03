package DemoQa.DemoQA;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Cons;
import Utilities.GetScreenshot;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;


public class Reg_Page {

	  	
	
	@BeforeMethod
	public void beforeMethod(Method method) {
	    Test annotation_test = method.getAnnotation(Test.class);	    
	    String temp_message =("Starting " + annotation_test.description());
	    HomePage.test.assignCategory("Smoke Test");
	    HomePage.test = HomePage.extent.startTest(annotation_test.description());
	    HomePage.test.log(LogStatus.INFO, temp_message);
	    
	}
	

	
	
	@Test(description = "Customer Registration",priority=4)
	public void Registration()
	{
		
		
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
		
		HomePage hm = new HomePage();
		hm.goBack();
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
		 System.out.println("INSIDE Reg_Page.java");
		/* HomePage.driver.close();*/
		 /*HomePage.extent.flush();*/
		// HomePage.extent.close();
	        
	    }
	

}
