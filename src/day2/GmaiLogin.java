package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmaiLogin {

	
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.findElement(By.name("Email")).sendKeys("gandham.saikrishna@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("passw@123");
		driver.findElement(By.id("signIn")).click();
		
		
		
		
		
		
		
		
		
		
		

	}

}
