package VDOhire_KeywordDriven.VDOhire_KeywordDriven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Com.generic.ExcecutorEngine;

public class TestScript {
	
	@Test
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcecutorEngine engine=new ExcecutorEngine();
		engine.excecuteSript("Sheet1");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
