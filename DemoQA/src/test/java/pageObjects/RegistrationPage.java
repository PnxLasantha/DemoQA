package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Cons;


public class RegistrationPage {
	
	WebDriver driver;
	public RegistrationPage()
	{
		this.driver = HomePage.driver;
	}
	
	
	
	
	By First_name = By.id("name_3_firstname");
	
	By Last_name = By.id("name_3_lastname");
	
	By Martial_status = By.name("radio_4[]");
	
	By Hobby = By.name("checkbox_5[]");
	
	By Country = By.id("dropdown_7");
	
	By Date_DOB = By.id("mm_date_8");
	
	By Month_DOB = By.id("dd_date_8");
	
	By Year_DOB = By.id("yy_date_8");
	
	By Phone_Number = By.id("phone_9");
	
	By UserName = By.id("username");
	
	By E_mail = By.id("email_1");
	
	By Prof_pic = By.id("profile_pic_10");
	
	By dese = By.id("description");
	
	By Password = By.id("password_2");
	
	By Com_Password = By.id("confirm_password_password_2");
	
	By submit = By.name("pie_submit");
	
	
	public void SetNames()
	{
		driver.findElement(First_name).sendKeys("FirstName");
		driver.findElement(Last_name).sendKeys("LastName ");
		HomePage.test.log(LogStatus.INFO, "Names Done");
	}
	
	public void setMstatus()
	{
		
		List<WebElement> M_statusRadio = driver.findElements(Martial_status);
		M_statusRadio.get(0).click();
		HomePage.test.log(LogStatus.INFO, "Martial status Done");
	}
	
	public void setHobby()
	{
		List<WebElement> R_hobby = driver.findElements(Hobby);
		R_hobby.get(0).click();
		HomePage.test.log(LogStatus.INFO, "Hobby Done");
		
	}
	
	public void setCountry()
	{
		Select Country_dropdown = new Select(driver.findElement(Country));
		Country_dropdown.selectByVisibleText("Armenia");
		HomePage.test.log(LogStatus.INFO, "Country Done");
	}
	
	public void setDateOfBirth()
	{
		Select Day_dropdown = new Select(driver.findElement(Date_DOB));
		Day_dropdown.selectByVisibleText("5");
		
		Select Month_dropdown = new Select(driver.findElement(Month_DOB));
		Month_dropdown.selectByVisibleText("2");
		
		Select Year_dropdown = new Select(driver.findElement(Year_DOB));
		Year_dropdown.selectByVisibleText("1991");
		HomePage.test.log(LogStatus.INFO, "DOB Done");
		
	}
	
	public void setPhone()
	{
		driver.findElement(Phone_Number).sendKeys("0745236985");
		HomePage.test.log(LogStatus.INFO, "Phone Done");
	}
	
	public void setUserName()
	{
		driver.findElement(UserName).sendKeys("DEMOQAUSER");
		HomePage.test.log(LogStatus.INFO, "UserName Done");
	}
	
	public void setEmail()
	{
		driver.findElement(E_mail).sendKeys("aa@aa.aa");
		HomePage.test.log(LogStatus.INFO, "E_mail  Done");
	}
	
	public void setprofPic()
	{
		
		driver.findElement(Prof_pic).sendKeys("E:/Lasantha/Auto/WS/DemoQA/src/test/Resources/100442.jpg");
		HomePage.test.log(LogStatus.INFO, "Profile Pic Done");
	}
	
	public void setDescription()
	{
		
		driver.findElement(dese).sendKeys("The Details");
		HomePage.test.log(LogStatus.INFO, "Details Done");
	}
	
	public void setPasswords()
	{
		driver.findElement(Password).sendKeys("ib1234567");
		driver.findElement(Com_Password).sendKeys("ib1234567");
		HomePage.test.log(LogStatus.INFO, "Passwords Done");
	}
	
	public void submitbutton()
	{
		driver.findElement(submit).click();
		
	}
	
	public void switchingBack()
	{
		driver.get(Cons.url);
	}
}
