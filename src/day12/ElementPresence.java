package day12;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementPresence {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		driver=new FirefoxDriver(fp);
		driver.get("http://en.wikipedia.org/wiki/Rajinikanth");
	}
	
	
	@Test
	public void elementTest()
	{
		String str=driver.getPageSource();
		if(str.contains("Rajinikanth"))
		{
			System.out.println("Element exists");
		}
		else
		{
			System.out.println("Element not present");
		}
	}

}
