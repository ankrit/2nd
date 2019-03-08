package VDOhire_KeywordDriven.VDOhire_KeywordDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ExcecutorEngine {
	
	public  WebDriver driver;
	public static Properties prop;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	
	public String locaterName;
	String locaterValue;
	
	public BaseClass base;
	
	public WebElement element;
	
	
	String Excelpath="C:\\Users\\vinda\\eclipse-workspace\\VDOhire_KeywordDriven\\Excelfiles\\keyword.xlsx";
	
	public void excecuteSript(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		File file=new File(Excelpath);
		
		FileInputStream fis=new FileInputStream(file);
		
		workbook=WorkbookFactory.create(fis);
		
		 sheet = workbook.getSheet(sheetName);
		   int i=0;
		   int k=0;
try
{
	

		 for(i=0; i<=sheet.getLastRowNum(); i++)
		 {
			String locaterColumnValue = sheet.getRow(i+1).getCell(k+1).toString().trim();
 // what i hv done here is - for row i am starting from -getRow(i+1)bcoz in row no=0 I hv written test step,locater,action,value which is not required
	//for cell -getcell(k+1) becoz in k=0 I hv written --> test step
//			 open browser 
//			 lunch url
//			 enter email address
//			 enter pwd address
//			 click on login button
//			 close browser
                               //      which is also not required at the runtime
	//means - String locaterColumnValue = sheet.getRow(i+1).getCell(k+1).toString().trim(); --here we are focusing only locater column (see ur excel sheet)
			
			if(!locaterColumnValue.equalsIgnoreCase("NA"))//means it will not going to take "NA" value bocoz (!)
			{
				
				String locaterName = locaterColumnValue.split("=")[0].trim();  // id  
	//	split("=")[0] -->split method will take String value with array (return type=String [])		
				String locaterValue = locaterColumnValue.split("=")[1].trim(); //username			
			}
			
		String actionColumnValue = sheet.getRow(i+1).getCell(k+2).toString().trim();
		
		
		String valueColumnValue = sheet.getRow(i+1).getCell(k+3).toString().trim();
		
		
			//getCell(k+2) for action coloumn
			
			// switch (key) -- this key represent key - that's why it is keyword driver framework 
		//key means your action coloumn from the excel sheet 
		
			switch (actionColumnValue) //this is for row 1(NA) see excel sheet
			//note: we will write every switch statement on the basis of locater only which we hv written in excel
			
			{
			case "open browser":
				base=new BaseClass();
				prop=base.initproperties();
				
				String browser = prop.getProperty("browser");
				
				base.launchBrowser(browser);		
				break;
				
			case "enter url":	
				if(valueColumnValue.isEmpty() || valueColumnValue.equals("NA"))
					//means if value is not present in excel sheet then it will take the value from Config file
				{
					driver.get(prop.getProperty("url"));
				}
				else
				{
					driver.get(valueColumnValue);
				}
				
		        case "quit":
				driver.quit();
				locaterName=null;
				break;
			default:
				break;
				// first switch statement completed for locater- NA
			}
		 
				switch (locaterName) 
				{
				case "id":
					
			element = driver.findElement(By.id(locaterValue));
				 if(actionColumnValue.equals("SendKeys"))
				 {
					 element.clear();
				 element.sendKeys(valueColumnValue);
		 //but another id is also using for click in action coloum so we can use it in else statement 
				 }
				 else if(actionColumnValue.equalsIgnoreCase("click"))
				 {
					 element.click();
					 
				 }
				 locaterName=null;  //so that we can use same locater for another WebElement
					break;
					
				case "linkText":
					 element=driver.findElement(By.linkText(locaterValue));
					

				default:
					break;
				}
				
		 }
}
		 catch(NullPointerException e)
		 {
			 
		 }
				
				
				
				
			}
			
			
			
			
			
			
			
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
	
	
	
	
	
	

