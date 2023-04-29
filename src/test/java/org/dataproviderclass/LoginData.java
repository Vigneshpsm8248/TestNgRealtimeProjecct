package org.dataproviderclass;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginData extends BaseClass{
	
	
	@DataProvider(name = "ref")
	public Object[][] getData() throws IOException {
		return new Object[][] { { getDataFromExcel("LoginData", 0, 0), getDataFromExcel("LoginData",0, 1) }, 
			                    { getDataFromExcel("LoginData",1, 0), getDataFromExcel("LoginData",1, 1) },
				                { getDataFromExcel("LoginData",2, 0), getDataFromExcel("LoginData",2, 1) }, 
			                    { getDataFromExcel("LoginData",3, 0), getDataFromExcel("LoginData",3, 1) }};
	}
	
	
	@DataProvider(name = "scearch")
	private Object[][] loginScearch() throws IOException {
		
		return new Object[][] { { getDataFromExcel("LoginData", 0, 0), getDataFromExcel("LoginData",0, 1) }};
	} 

}
