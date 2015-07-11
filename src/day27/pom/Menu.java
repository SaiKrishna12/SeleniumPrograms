package day27.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {
	@FindBy(linkText="SIGN-ON")
	WebElement signon;
	public void signon()
	{
		signon.click();
	}

	@FindBy(linkText="REGISTER")
	WebElement register;
	public void register()
	{
		register.click();
	}

	
	@FindBy(linkText="SUPPORT")
	WebElement support;
	public void support()
	{
		support.click();
	}

	@FindBy(linkText="CONTACT")
	WebElement contact;
	public void contact()
	{
		contact.click();
	}

}
