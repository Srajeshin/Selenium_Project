package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
			
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Testdata\\Testing.xls"; 
		//List<List<object>> retval = ApachePOIExcelRead.getExcelContent(fileName);
		
		
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Testdata\\Testing.xls", "Sheet1"); 
	}
	@DataProvider(name = "excel-inputs3")
	public Object[][] getXLData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Testdata\\Testing1.xls", "Sheet1"); 
	}
	@DataProvider(name = "excel-inputs4")
	public Object[][] getXLData1(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Testdata\\Testing2.xls", "Sheet1"); 
	}
	
	
	
	
}
