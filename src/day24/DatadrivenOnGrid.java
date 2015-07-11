package day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatadrivenOnGrid {

	@Parameters("browser")
	@Test
	public void linkTest(String b) throws IOException
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
		FileInputStream f=new FileInputStream("E:\\May18Batch\\Selenium\\src\\com\\qedge\\excelfiles\\links.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			String linkname=r.getCell(0).getStringCellValue();
			try
			{
			   driver.findElement(By.linkText(linkname)).click();
			   String acturl=driver.getCurrentUrl();
			   r.createCell(2).setCellValue(acturl);
			   String expurl=r.getCell(1).getStringCellValue();
			   if(acturl.equals(expurl))
			   {
				   r.createCell(3).setCellValue("Passed");
			   }
			   else
			   {
				   r.createCell(3).setCellValue("Failed");
			   }
			   driver.navigate().back();
			}
			catch(Exception e)
			{
				r.createCell(3).setCellValue("Link not present");
			}
			
		}
		FileOutputStream f1=new FileOutputStream("E:\\May18Batch\\Selenium\\src\\com\\qedge\\resultexcelfiles\\"+b+"_links.xlsx");
		wb.write(f1);
		f1.close();
	}
		

}
