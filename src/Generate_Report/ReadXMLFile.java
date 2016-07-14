package Generate_Report;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import ExcelWork.excelUtil;

import java.io.File;

public class ReadXMLFile {

  public static void main(String argv[]) {

    try {
    	//some data edited by...And checked
    	String filepath = "D:\\Report";
    	String filename = "SummaryReport.xlsx";
    	String SummarySheet = "Summary";
    	String sheetname = "Audit";
    	String tempmodulename = "";
    	
    excelUtil.CreateExcelFile(filepath, "SummaryReport", SummarySheet);	
    excelUtil.CreateExcelFile(filepath, "SummaryReport", sheetname);
    
    int pass=0;
    int fail=0;
    int startrow =4;

	File fXmlFile = new File("src\\SummaryReport.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("TC");
			
	System.out.println("----------------------------");
	
	
	
	int ROW =0;
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, "ModuleName", 4, 2);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, "PASSED COUNT", 4, 3);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, "FAILED COUNT", 4, 4);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "ModuleName", 1, 1);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "TCName", 1, 2);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "StartTime", 1, 3);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "EndTime", 1, 4);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "ExecutionTime", 1, 5);
	excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "Status", 1, 6);
	
	
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			int row = temp+2;
			boolean newModule = true;
			String Current_module = eElement.getAttribute("ScenarioName");
			System.out.println("current module name :"+Current_module);
			excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, eElement.getAttribute("ScenarioName"), row, 1);
			excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, eElement.getAttribute("TCName"), row, 2);
			excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, eElement.getAttribute("StartTime"), row, 3);
			excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, eElement.getAttribute("endTime"), row, 4);
			excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, eElement.getAttribute("ExecutionTime"), row, 5);
			
			if(!Current_module.equalsIgnoreCase(tempmodulename))
				{
					pass=0;
					fail=0;
					newModule=true;
					startrow=startrow+1;
					excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, Current_module, startrow, 2);
					String pCount = String.valueOf(pass);
					excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, pCount, startrow, 3);
					String fCount = String.valueOf(fail);
					excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, fCount, startrow, 4);
				}
			else
				{
					newModule=false;
				}
			
				if(eElement.getAttribute("Status").equals("0"))
					
					{
			
						excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "PASSED", row, 6);
			
						
						if(!newModule)
							{
								pass=pass+1;
								String pCount = String.valueOf(pass);
								System.out.println("Pass count in if is :"+pCount);
								excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, pCount, startrow, 3);
				
							}
						else
							{
				
								pass=pass+1;
								String pCount = String.valueOf(pass);
								System.out.println("Pass count in else is :"+pCount);
								//excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, module_name, startrow, 2);
								System.out.println("module name "+Current_module);
								//excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, "PASSED", startrow, 3);
								excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, pCount, startrow, 3);
				
				
							}
						tempmodulename = Current_module;
		
					}
		
				else
					{
			
						excelUtil.SetCellDataWithExecutionStatus(filepath, filename, sheetname, "FAILED", row, 6);
						if(!newModule)
							{
								fail=fail+1;
								String fCount = String.valueOf(fail);
								excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, fCount, startrow, 4);
				
							}
						else
							{
				
							fail=fail+1;
							String fCount = String.valueOf(fail);
							//excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, module_name, startrow, 2);
							System.out.println("module name "+Current_module);
							//excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, "FAILED", startrow, 5);
							excelUtil.SetCellDataWithExecutionStatus(filepath, filename, SummarySheet, fCount, startrow, 4);
				
							}
						tempmodulename = Current_module;
			
					}
		
		
		
		ROW = temp+1;
		System.out.println(ROW+" Rows Addedd Successfully.");
		
		}
		
	}
	System.out.println("Successfully Excel Report Created.");
    } catch (Exception e) {
	
    	System.out.println("Some Error happened while creating Excel Report.");
    	e.printStackTrace();
    }
  }

}
