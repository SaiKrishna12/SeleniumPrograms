package day25;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileDownloadRobot {
	@Test
	public void downloadTest() throws IOException, InterruptedException, AWTException, InstantiationException, IllegalAccessException, ClassNotFoundException  

	{
		String d="org.openqa.selenium.firefox.FirefoxDriver";
		Class.forName(d).newInstance();
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://seleniumhq.org");
		driver.findElement(By.linkText("Download")).click();
		driver.findElement(By.linkText("2.46.0")).click();
		Thread.sleep(3000);
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

}
