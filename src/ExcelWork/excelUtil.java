package ExcelWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;







public class excelUtil {
	
	/*
	public static void main(String[] args) throws IOException{
	
		
		int rowNum=GetRowCount("E:\\java_workspace\\Java_Prac\\src","testdata.xls","Sheet1");
		System.out.println("The total number of row is "+rowNum);
		
		int colNum=GetColCount("E:\\java_workspace\\Java_Prac\\src","testdata.xls","Sheet1");
		System.out.println("The total number of column is "+colNum);
		
		SetCellData("E:\\java_workspace\\Java_Prac\\src","testdata.xls","Sheet1","88",2,2);
		
		CheckExcelFileAndAddData("E:\\java_workspace\\Java_Prac\\src","javaexcel.xlsx","Sheet1","testoutput",5,5);
		
		
		//String data = GetCellData(CONSTANTS.EXCEL_PATH, "Foundation.xlsx", "TestData", 2, 1);
		
		
	}
	*/
	
	public void excelUtil(String filePath,String fileName) throws IOException{
		//create a object of File class to open excel file
				File file=new File(filePath+"\\"+fileName);
				
				//create an object of FileInputStream class to read excel file
				FileInputStream inputStream=new FileInputStream(file);
				Workbook wb = null;
				
				//Find the file extension by spliting file name in substring and getting only extension name
				String FileExtensionName=fileName.substring(fileName.indexOf("."));
				
				//Check condition for xlsx file
				if(FileExtensionName.equals(".xlsx")){
					wb = new XSSFWorkbook(inputStream);
				}
				
				//Check condition for xlsx file
				if(FileExtensionName.equals(".xls")){
					wb=new HSSFWorkbook(inputStream);
				}
				wb.close();
	}

	public static int GetRowCount(String filePath,String fileName,String sheetName) throws IOException{
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook wb = null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
		String FileExtensionName=fileName.substring(fileName.indexOf("."));
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xlsx")){
			wb = new XSSFWorkbook(inputStream);
		}
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xls")){
			wb=new HSSFWorkbook(inputStream);
		}
		
		//read sheet inside the workbook
		Sheet sh = wb.getSheet(sheetName);
		
		//Find number of rows in excel file
		int rowCount=sh.getLastRowNum()-sh.getFirstRowNum()+1;
		return rowCount;
	}
	
	public static int GetColCount(String filePath,String fileName,String sheetName) throws IOException{
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook wb = null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
		String FileExtensionName=fileName.substring(fileName.indexOf("."));
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xlsx")){
			wb = new XSSFWorkbook(inputStream);
		}
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xls")){
			wb=new HSSFWorkbook(inputStream);
		}
		
		//read sheet inside the workbook
		Sheet sh = wb.getSheet(sheetName);
		
		//Find number of columns in excel file
		//int colCount=sh.getRow(0).getLastCellNum();
		int colCount=sh.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}
	
	public static String GetCellData(String filePath,String fileName,String sheetName,int rownum,int colnum) throws IOException{
		String celldata;
		celldata=null;
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook wb = null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
		String FileExtensionName=fileName.substring(fileName.indexOf("."));
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xlsx")){
			wb = new XSSFWorkbook(inputStream);
		}
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xls")){
			wb=new HSSFWorkbook(inputStream);
		}
		
		//read sheet inside the workbook
		Sheet sh = wb.getSheet(sheetName);
		
		//get the cell
		Row row=sh.getRow(rownum-1);
		
		Cell cell=null;
		try {
			cell=row.getCell(colnum-1);
		}
		catch(NullPointerException e)
		{
			//Exception caught
			cell=null;
			celldata = "";
		}
		
		if(cell != null){
			
			cell.setCellType(Cell.CELL_TYPE_STRING);
			//String value = cell.getStringCellValue();
			//System.out.println(value);
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
		        //System.out.println("string value : " + cell.getStringCellValue());
		       celldata=cell.getStringCellValue();
				
		    }
		}
		
		if(cell == null)
		{
			celldata = "";
		}
		
		return celldata;
		
		}
		
	public static void SetCellData(String filePath,String fileName,String sheetName,String data,int rownum,int colnum) throws IOException{
		
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		System.out.println("Current File is "+file);
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook wb = null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
		String FileExtensionName=fileName.substring(fileName.indexOf("."));
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xlsx")){
			wb = new XSSFWorkbook(inputStream);
		}
		
		//Check condition for xlsx file
		if(FileExtensionName.equals(".xls")){
			wb=new HSSFWorkbook(inputStream);
		}
		
		try{
		//read sheet inside the workbook
		Sheet sh = wb.getSheet(sheetName);
		
		//get the cell
		Row row=sh.getRow(rownum-1);
		if(row==null){
			row = sh.createRow(rownum-1);
		}
				
		Cell cell=row.getCell(colnum-1);
		
		
		//create cell for the row
		cell=row.createCell(colnum-1);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		
		FileOutputStream outputStream = new FileOutputStream(file); 
		wb.write(outputStream);
		outputStream.close();
		}catch(FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		}	
		
	
public static void CheckExcelFileAndAddData(String filePath,String fileName,String sheetName,String data,int rownum,int colnum) throws IOException {
		
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		
		Workbook wb = null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
		String FileExtensionName=fileName.substring(fileName.indexOf("."));
		
		if(file.exists()){
			//create an object of FileInputStream class to read excel file
			FileInputStream inputStream=new FileInputStream(file);
			
			//Check condition for xlsx file
			if(FileExtensionName.equals(".xlsx")){
				wb = new XSSFWorkbook(inputStream);
			}
			
			//Check condition for xlsx file
			if(FileExtensionName.equals(".xls")){
				wb=new HSSFWorkbook(inputStream);
			}
			
		}
		else
		{
			//Check condition for xlsx file
			if(FileExtensionName.equals(".xlsx")){
				wb = new XSSFWorkbook();
			}
			
			//Check condition for xlsx file
			if(FileExtensionName.equals(".xls")){
				wb=new HSSFWorkbook();
			}
			//create an object of FileInputStream class to read excel file
			FileOutputStream outputStream=new FileOutputStream(file);
			wb.createSheet(sheetName);
			wb.write(outputStream);
			outputStream.close();
		}
		
		try{
			//read sheet inside the workbook
			Sheet sh = wb.getSheet(sheetName);
			
			//get the cell
			Row row=sh.getRow(rownum-1);
			if(row==null){
				row = sh.createRow(rownum-1);
			}
					
			Cell cell=row.getCell(colnum-1);
			
			
			//create cell for the row
			cell=row.createCell(colnum-1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(data);
			
			FileOutputStream outputStream = new FileOutputStream(file); 
			wb.write(outputStream);
			outputStream.close();
			}catch(FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}

	}

	

	
	
public static void SetCellDataWithExecutionStatus(String filePath,String fileName,String sheetName,String data,int rownum,int colnum) throws IOException{
		
		//create a object of File class to open excel file
		File file=new File(filePath+"\\"+fileName);
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream=new FileInputStream(file);
		
		Workbook wb = null;
		
		
			wb = new XSSFWorkbook(inputStream);
		
		
		try{
		//read sheet inside the workbook
		Sheet sh = wb.getSheet(sheetName);
		
		// Create a new font and alter it.
	    Font font = wb.createFont();
	    font.setBold(true);
	    if(data.equalsIgnoreCase("PASSED")){
	    	
	    	font.setColor(IndexedColors.GREEN.getIndex());
	    }
	    else if(data.equalsIgnoreCase("FAILED"))
	    {
	    	font.setColor(IndexedColors.RED.getIndex());
	    }
	    
		
	    CellStyle style = wb.createCellStyle();
	    
	    /*
		// Aqua background
	    style = wb.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    */
	    style.setFont(font);
	    style.setBorderBottom(CellStyle.BORDER_THIN); //--USE FOR ONLY BORDER
	    style.setBorderRight(CellStyle.BORDER_THIN); //--USE FOR ONLY BORDER
	    /*
	    style.setBorderBottom(CellStyle.BORDER_MEDIUM_DASHED);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_MEDIUM_DASHED);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderRight(CellStyle.BORDER_MEDIUM_DASHED);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    */
        
		//get the cell
		Row row=sh.getRow(rownum-1);
		if(row==null){
			row = sh.createRow(rownum-1);
		}
				
		Cell cell=row.getCell(colnum-1);
		
		
		//create cell for the row
		cell=row.createCell(colnum-1);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		cell.setCellStyle(style);
		
		FileOutputStream outputStream = new FileOutputStream(file); 
		wb.write(outputStream);
		outputStream.close();
		}catch(FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		}	
	
	public static void CreateExcelFile(String filePath,String fileName,String sheetName) throws IOException{
		
		//create a object of File class to open excel file
		File file=new File(filePath+"//"+fileName+".xlsx");
		
		
		if(!file.exists())
		{
			//Write the workbook in file system
		      FileOutputStream out = new FileOutputStream( 
		      new File(filePath+"//"+fileName+".xlsx"));
		      XSSFWorkbook workbook = new XSSFWorkbook();
		      XSSFSheet sheet = workbook.getSheet(sheetName);
		      XSSFSheet spreadsheet = workbook.createSheet(sheetName);
		      workbook.write(out);
		      out.close();
		      
		}
		
				//create an object of FileInputStream class to read excel file
				FileInputStream inputStream=new FileInputStream(file);
			      
			    
			    
			      //Create blank workbook
			      XSSFWorkbook workbook = new XSSFWorkbook(inputStream); 
			      XSSFSheet sheet = workbook.getSheet(sheetName);
			    	if(sheet == null)	
			    	{
			    		//Create a blank sheet
			  	      XSSFSheet spreadsheet = workbook.createSheet(sheetName);
			    	}

			      
			    	FileOutputStream outputStream = new FileOutputStream(file);
			      workbook.write(outputStream);
			      outputStream.close();
		
		
	}
	

	
	

	}


