package day12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputFields2 {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		driver=new FirefoxDriver(fp);
		driver.get("https://twitter.com");
	}
	
	
	@Test
	public void inputBoxTest()
	{
		String[] str={"one","two","three","four","five"};
		List<WebElement> myinput=driver.findElements
				       (By.xpath("//input[@type='text' or @type='password']"));
		System.out.println(myinput.size());
		int j=0;
		for(int i=0;i<myinput.size();i++)
		{
			
			if(myinput.get(i).isDisplayed())
			{
				
				myinput.get(i).sendKeys(str[j]);
				j++;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
