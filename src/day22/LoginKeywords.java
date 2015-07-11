package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginKeywords {
	FirefoxDriver driver;
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
	}
	public void navigate()
	{
		driver.get("http://gmail.com");
	}
	public void enterUsername(String locator) 	{
		driver.findElement(By.id(locator)).sendKeys("gandham.saikrishna");
		
	}
	public void clickNext(String locator) throws InterruptedException
	{
		driver.findElement(By.id(locator)).click();
		Thread.sleep(2000);
	}
	public void enterPassword(String locator)
	{
		driver.findElement(By.id(locator)).sendKeys("pass@123");
	}
	public void clickLogin(String locator)
	{
		driver.findElement(By.id(locator)).click();
	}

}
