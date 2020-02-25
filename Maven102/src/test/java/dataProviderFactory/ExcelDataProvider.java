package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider{
	
	HSSFWorkbook wb;
	
	public ExcelDataProvider(){
	
		try{
			wb = new HSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/TestData.xls")));
		}catch (IOException e){
			
			System.out.println("Unable to read Excel Data " + e.getMessage());
		}
		
	}
	
	
	public String getCellData(String sheetName, int row, int col)
	{
		HSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(col);
		
		String data = null;
		
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data = cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data = String.valueOf((int)cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			data = "";
		}
		return data;
	}
	
	
	public int getRows(String sheetName)
	{
			return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	

	public int getColumns(String sheetName)
	{
			return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}

}
