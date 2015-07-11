package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailLoginUisngProperties {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://gmail.com");
	}
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		FileInputStream f=new FileInputStream("E:\\May18Batch\\Selenium\\Gmail.properties");
		Properties pr=new Properties();
		pr.load(f);
		
		driver.findElement(By.id(pr.getProperty("txt_username"))).sendKeys("gandham.saikrishna");
		driver.findElement(By.id(pr.getProperty("btn_next"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(pr.getProperty("txt_password"))).sendKeys("pass@123");
		driver.findElement(By.id(pr.getProperty("btn_signin"))).click();
		
		
		
		
		
		
		
		
	}

}
