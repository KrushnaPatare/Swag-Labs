package com.swagLabs.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getloginData() throws IOException
	{
		String path = AutoConstant.loginTestDataPath;
		XLUtility xlutil = new XLUtility(path);
		
		int rownum = xlutil.getRowCount("credentials"); //
		int colcount = xlutil.getCellCount("credentials", 0); //
		
		String apidata[][] = new String[rownum][colcount];
		for(int i=1; i<rownum; i++) 
		{
			for(int j=0; j<colcount; j++) 
			{
				apidata[i-1][j]= xlutil.getCellData("credentials", i, j);
			}
		}
			
		return apidata;
	}
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xlutil = new XLUtility(path);
		
		int rownum = xlutil.getRowCount("Sheetl");
		int colcount = xlutil.getCellCount("Sheetl", 1);
		
		String apidata[][] = new String[rownum][colcount];
		for(int i=1; i<rownum; i++) 
		{
			for(int j=0; j<colcount; j++) 
			{
				apidata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
			
		return apidata;
	}
	
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Pserdata.xlsx";
		XLUtility xlutil = new XLUtility(path);
	
		int rownum = xlutil.getRowCount("Sheet1");
		String apidata[] = new String[rownum];
	
		for(int i=1; i<=rownum; i++)
		{ 
			apidata[i-1]= xlutil.getCellData("Sheet1",i, 1);
		}
	
		return apidata;
	}
	

}
