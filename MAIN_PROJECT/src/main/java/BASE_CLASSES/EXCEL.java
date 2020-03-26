package BASE_CLASSES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class EXCEL {
	public static String[][] testdata= new String[7][2];
	public static int r,c,i,j;
//method to read data from excel
public static void read()
{
	File f=new File("src/test/resources/TEST_DATA/Login_data.xlsx");
	try 
	{
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh=wb.getSheet("Sheet1");
	for(r=1,i=0;r<7;r++,i++)
	{
	XSSFRow row = sh.getRow(r);
	for(c=0,j=0;c<2;c++,j++)
	{
	XSSFCell cell=row.getCell(c);
	testdata[i][j]=cell.getStringCellValue();
	}
	}
	}
	catch (FileNotFoundException e) 
	{
	e.printStackTrace();
	}
	catch (IOException e1) 
	{
	e1.printStackTrace();
	}

}
}