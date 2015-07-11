package day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelDropdown {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		 driver=new FirefoxDriver();
		 driver.get("http://newtours.demoaut.com");
		 driver.findElement(By.linkText("REGISTER")).click();
	}
	@Test
	public void dropdownExcelTest() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\sai\\Desktop\\Dropdown.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row r=null;
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		
		ws.createRow(0).createCell(0).setCellValue("Country");
		ws.createRow(0).createCell(1).setCellValue("Status");
		for(int i=0;i<dropdown.size();i++)
		{
			r=ws.createRow(i+1);
			r.createCell(0).setCellValue(dropdown.get(i).getText());
			dropdown.get(i).click();
			if(dropdown.get(i).isSelected())
			{
				r.createCell(1).setCellValue("true");
			}
			else
			{
				r.createCell(1).setCellValue("flase");
			}
		}
		FileOutputStream f1=new FileOutputStream("C:\\Users\\sai\\Desktop\\Dropdown.xlsx");
		wb.write(f1);
		f1.close();
	}

}
