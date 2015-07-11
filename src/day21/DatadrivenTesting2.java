package day21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatadrivenTesting2 {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		 driver=new FirefoxDriver();
		 driver.get("http://newtours.demoaut.com");
		
	}
	@Test
	public void datadrivenTest() throws IOException
	{
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
		FileOutputStream f1=new FileOutputStream("E:\\May18Batch\\Selenium\\src\\com\\qedge\\resultexcelfiles\\links.xlsx");
		wb.write(f1);
		f1.close();
		
	}	
		
		

}
