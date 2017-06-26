package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


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
		
	}
	
	public void setMstatus()
	{
		
		List<WebElement> M_statusRadio = driver.findElements(Martial_status);
		M_statusRadio.get(0).click();
	}
	
	public void setHobby()
	{
		List<WebElement> R_hobby = driver.findElements(Hobby);
		R_hobby.get(0).click();
		
		
	}
	
	public void setCountry()
	{
		Select Country_dropdown = new Select(driver.findElement(Country));
		Country_dropdown.selectByVisibleText("Armenia");
		
	}
	
	public void setDateOfBirth()
	{
		Select Day_dropdown = new Select(driver.findElement(Date_DOB));
		Day_dropdown.selectByVisibleText("5");
		
		Select Month_dropdown = new Select(driver.findElement(Month_DOB));
		Month_dropdown.selectByVisibleText("2");
		
		Select Year_dropdown = new Select(driver.findElement(Year_DOB));
		Year_dropdown.selectByVisibleText("1991");
		
		
	}
	
	public void setPhone()
	{
		driver.findElement(Phone_Number).sendKeys("0745236985");
		
	}
	
	public void setUserName()
	{
		driver.findElement(UserName).sendKeys("Username002");
		
	}
	
	public void setEmail()
	{
		driver.findElement(E_mail).sendKeys("aa@aa.aa");
		
	}
	
	public void setprofPic()
	{
		
		driver.findElement(Prof_pic).sendKeys("E:/Lasantha/Auto/WS/DemoQA/src/test/Resources/100442.jpg");
	}
	
	public void setDescription()
	{
		
		driver.findElement(dese).sendKeys("The Details");
	}
	
	public void setPasswords()
	{
		driver.findElement(Password).sendKeys("ib1234567");
		driver.findElement(Com_Password).sendKeys("ib1234567");
	}
	
	public void submitbutton()
	{
		driver.findElement(submit).click();
		
	}
}
