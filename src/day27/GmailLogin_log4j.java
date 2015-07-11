package day27;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogin_log4j {

	private static Logger log=Logger.getLogger(GmailLogin_log4j.class);
	public static void main(String[] args) throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		FirefoxDriver driver=new FirefoxDriver();
		log.info("Browser Launched");
		driver.get("http://gmail.com");
		log.info("Navigated to gmail");
		driver.findElement(By.name("Email")).sendKeys("gandham.saikrishna@gmail.com");
		log.info("Enterd the username");
		driver.findElement(By.id("next")).click();
		log.info("Clicked on next button");
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("passw@123");
		log.info("Entered the  password");
		driver.findElement(By.id("signIn")).click();
		log.info("Clicked on Signin");

	}

}
