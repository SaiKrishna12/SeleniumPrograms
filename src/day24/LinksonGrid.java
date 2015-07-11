package day24;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksonGrid {
	
	@Parameters("browser")
	@Test
	public void linkTest(String b) throws MalformedURLException
	{
		System.out.println(b);
		DesiredCapabilities cap=null;
		if(b.equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(b.equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		driver.get("http://newtours.demoaut.com");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				String linkname=links.get(i).getText();
				String expurl=links.get(i).getAttribute("href");
				links.get(i).click();
				String acturl=driver.getCurrentUrl();
				if(acturl.contains(expurl))
				{
					System.out.println(linkname+" is working correctly");
				}
				else
				{
					System.out.println(linkname+" is not working correctly");
				}
				driver.navigate().back();
				links=driver.findElements(By.tagName("a"));
				
				
				
				
				
				
				
				
				
			}
		}
	}

}
