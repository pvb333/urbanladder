package com.UrbanLadder.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.UrbanLadder.reusablecomponent.*;
import com.UrbanLadder.uistore.*;
import com.UrbanLadder.utility.*;




public class UrbanLadder_ListOfProductPage extends UrbanLadder_HomePage {
	static ArrayList<Integer> arlist2=new ArrayList<Integer>();
	static String url;
	public static void verifySearchResult() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		String Text=driver.findElement(UrbanLadder_ListOfProductPageUI.verifysearch).getText();
		if(Text.contains("Table"))
		{
			Log.log1.info("Result verified successfully");
		}
		else {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
		}
	}
	public static void SelectStudyTable() throws InterruptedException, FileNotFoundException, IOException
	{
		Actions a=new Actions(driver);
		WebElement hover=driver.findElement(UrbanLadder_ListOfProductPageUI.hovering);
		driver.findElement(UrbanLadder_ListOfProductPageUI.category).click();
		driver.findElement(UrbanLadder_ListOfProductPageUI.studyTableSelect).click();
		arlist.addAll(ExcelReader.excel("Type"));
		a.moveToElement(hover).build().perform();
		Thread.sleep(1000);
		String actual=driver.findElement(UrbanLadder_ListOfProductPageUI.verifyStudyTableResult).getText();
		String expected=arlist.get(count);
		if(expected.equals(actual))
		{
			Log.log1.info("Study table result verified");	
		}
		else {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
			Assert.assertEquals(expected, actual);
			
		}
		arlist.removeAll(arlist);
	}
	public static void instockproduct() throws InterruptedException, FileNotFoundException, IOException
	{
		Thread.sleep(1000);
		driver.findElement(UrbanLadder_ListOfProductPageUI.inStock).click();
		arlist.addAll(ExcelReader.excel("Available"));
		String expected=arlist.get(count);
		Thread.sleep(1000);
		String actual=driver.findElement(UrbanLadder_ListOfProductPageUI.instockVerify).getText();
		Thread.sleep(1000);
		if(expected.equals(actual))
		{	
			Log.log1.info("In stock elements are displayed");
		}
		else {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss"); 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
			Assert.assertEquals(expected, actual);
			
		}
		Thread.sleep(1000);
			
		arlist.removeAll(arlist);
		boolean check=driver.findElement(UrbanLadder_ListOfProductPageUI.inStock).isSelected();
		Assert.assertTrue(check);
		Log.log1.info("Exclude Out Of Stock Check Box Selected");
		arlist.removeAll(arlist);
	}
	public static void sortResult() throws InterruptedException, IOException
	{
		driver.findElement(UrbanLadder_ListOfProductPageUI.sortBy).click();
		driver.findElement(UrbanLadder_ListOfProductPageUI.sorting).click();
		Thread.sleep(5000);
		driver.findElement(UrbanLadder_ListOfProductPageUI.popup).click();
		Thread.sleep(1000);
		 for(int i=1;i<=20;i++)
		 {
			 String cost=driver.findElements(UrbanLadder_ListOfProductPageUI.cost).get(i).getText();
			 cost= cost.replaceAll("₹", "");
			 cost= cost.replaceAll(",", "");
			 int ele=Integer.parseInt(cost);
			 arlist2.add(ele);
		 }
		 //driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 boolean status=true;

	        for (int i = 1; i < arlist2.size(); i++)
	        	
	            if (arlist2.get(i-1) > arlist2.get(i))
	                status=false;
	        status=true;
		 if(status==true)
		 {
			 Log.log1.info("Product is sorted from low to high price");
		 }
		 else
		 {
			 Date d = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss"); 
			 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
			 Log.log1.info("Products are not sorted");
		 }
		 Thread.sleep(1000);
		
	}
	public static void selectProduct() throws FileNotFoundException, IOException, InterruptedException
	{
		arlist.addAll(ExcelReader.excel("Product Name"));
		String expected=arlist.get(count);
		int size=driver.findElements(UrbanLadder_ListOfProductPageUI.listofproduct).size();
		for(int i=1;i<=size;i++)
		{
			String actual=driver.findElements(UrbanLadder_ListOfProductPageUI.listofproduct).get(i).getText();
			if(actual.contains(expected))
			{
				driver.findElements(UrbanLadder_ListOfProductPageUI.listofproduct).get(i).click();
				break;
			}
			else {
				continue;
			}
		}
		Thread.sleep(1000);
		arlist.removeAll(arlist);
		Set<String> s=driver.getWindowHandles();
		Iterator<String>it=s.iterator();// iterator method will iterate through the Set<String> s
		it.next();
		while(it.hasNext())
		{
			String child=it.next();
			driver.switchTo().window(child);
		}
		url=driver.getCurrentUrl();
		driver.close();
		
		
	}

}
