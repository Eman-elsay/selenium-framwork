package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static FileInputStream FIS = null ;
	public FileInputStream getfileinputstream()
	{
		String filepath= System .getProperty("user.dir")+"\\src\\main\\java\\properties\\UserData.xlsx";
	    java.io.File srcfile =  new java.io.File(filepath);
	    
	    try {
			FIS = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			
		System.out.println("error occured"+ e.getMessage());
		System.exit(0);
		}
	    return FIS ;
	    
	}
	public Object[][] getExcelData() throws IOException
	{
		FIS= getfileinputstream();
		XSSFWorkbook wb= new  XSSFWorkbook(FIS);
		XSSFSheet sheet= wb.getSheetAt(0);
		int totalnumberofrows= (sheet.getLastRowNum()+1);
		int totalnumberofcol= 4;
		String [][]arrayexceldata= new String [totalnumberofrows][totalnumberofcol];
		for (int i = 0; i < totalnumberofrows; i++) {
			for (int j = 0; j < totalnumberofcol; j++) {
				XSSFRow row =sheet.getRow(i);
				arrayexceldata[i][j]= row.getCell(j).toString();
				
			}
			
		}
		wb.close();
		return arrayexceldata;
	}
	

}
