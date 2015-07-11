package day24;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GmailLogin_Grid {
	
	@Test
	public void loginTest() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=null;
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		driver.findElement(By.name("Email")).sendKeys("gandham.saikrishna@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Passwd")).sendKeys("passw@123");
		driver.findElement(By.id("signIn")).click();
		
		
		
	}

}
