package com.UrbanLadder.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static ArrayList<String> excel(String data) throws FileNotFoundException, IOException
	{
		ArrayList<String> dt=new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis=new FileInputStream(Datadriven.datadriver("excel"));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		Iterator<Row> rowitr=sheet.iterator();
		Row rowcol=rowitr.next();
		Iterator<Cell> colitr=rowcol.cellIterator();
		int count=0;
		while(colitr.hasNext())
		{
			String rowval=colitr.next().getStringCellValue();
			if(rowval.equals(data))
			{
				break;
			}
			else {
				count++;
			}
		}
		while(rowitr.hasNext())
		{
			Row rows=rowitr.next();
			String val=formatter.formatCellValue(rows.getCell(count));// formatter is mainly used when we want to change the data type of cell value to string.
			//String val=rows.getCell(count).getStringCellValue();
			System.out.println(val);
			dt.add(val);
			
		}
		return dt;
		
	}

}
