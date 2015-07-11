package day2;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IELaunch {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver","c:\\IEdriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("http://google.com");
	}

}
