package day27;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import day27.pom.WelcomeMercuryTours;

public class PomControl1 {
	@Test
	public void pomTest()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com");
		 WelcomeMercuryTours wm=PageFactory.initElements(driver,WelcomeMercuryTours.class);
		wm.findAFlight("admin","pass@123");
		driver.navigate().back();
		wm.menu.register();
	}

}
