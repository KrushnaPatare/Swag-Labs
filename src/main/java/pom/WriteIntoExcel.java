package pom;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteIntoExcel {

	public void writeTest() throws IOException {
	
		File src = new File("F:\\WorkSpace\\SwagLabs\\src\\test\\resources\\TestData.xlsx");
		
		FileInputStream fis= new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(3);
		
		
		
		sheet.getRow(0).getCell(1).setCellValue("fafaerfwedwef");

		FileOutputStream fos = new FileOutputStream(src);
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("Successfully completed.");
	}
	
	
	public static void main(String[] args) throws IOException{
		
		WriteIntoExcel obj = new WriteIntoExcel();
		
		obj.writeTest();

	}
	

}
