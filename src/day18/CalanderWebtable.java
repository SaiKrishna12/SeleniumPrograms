package day18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalanderWebtable {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		driver=new FirefoxDriver(fp);
		driver.get("http://makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void webtableTest()
	{
		driver.findElement(By.id("one_way_button")).click();
		driver.findElement(By.id("from_city_head")).click();
		driver.findElement(By.linkText("Mumbai, India (BOM)")).click();
		
		driver.findElement(By.id("to_city_head")).click();
		driver.findElement(By.linkText("New Delhi, India (DEL)")).click();
		
		driver.findElement(By.xpath("//*[@id='start_date_sec']/span[2]")).click();
		
		String doj="10/05/2016";
		String [] a=doj.split("/");
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
		int x=Integer.parseInt(a[1]);
		
		String month=months[x-1];
		String day=a[0];
		String year=a[2];
		
		String calyear=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		while(!calyear.equals(year))
		{
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
			calyear=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		}
		
		String calmonth=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText();
		while(!calmonth.equals(month))
		{
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
			calmonth=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText();
		}
		boolean flag=false;
		WebElement table=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				if(cols.get(j).getText().equals(day))
				{
					cols.get(j).click();
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
