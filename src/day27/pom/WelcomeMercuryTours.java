package day27.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeMercuryTours {
	public Menu menu=null;
	public WelcomeMercuryTours(WebDriver driver)
	{
		menu=PageFactory.initElements(driver, Menu.class);
	}
	
	@FindBy(name="userName")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="login")
	WebElement signin;
	public void findAFlight(String u,String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		signin.click();
	}
	
	
	@FindBy(linkText="your destination")
	WebElement destinations;
	public void destinations()
	{
		destinations.click();
	}
	
	@FindBy(linkText="featured vacation destinations")
	WebElement vacations;
	public void vacations()
	{
		vacations.click();
	}
	@FindBy(linkText="Register here")
	WebElement register;
	public void register()
	{
		register.click();
	}
	
	

}
