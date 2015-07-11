package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LoginusingKeywords {
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		FileInputStream f1=new FileInputStream(("E:\\May18Batch\\Selenium\\Gmail.properties"));
		Properties pr=new Properties();
		pr.load(f1);
		
		LoginKeywords keys=new LoginKeywords();
		FileInputStream f=new FileInputStream("E:\\May18Batch\\Selenium\\src\\com\\qedge\\keywords\\LoginKeywords.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			String action=r.getCell(3).getStringCellValue();
			if(action.equals("launchBrowser"))
			{
				keys.launchBrowser();
			}
			else if(action.equals("navigate"))
			{
				keys.navigate();
			}
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(pr.getProperty("txt_username"));
			}
			else if(action.equals("clickNext"))
			{
				keys.clickNext(pr.getProperty("btn_next"));
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword("txt_password");
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(pr.getProperty("btn_signin"));
			}
		}
	}

}
