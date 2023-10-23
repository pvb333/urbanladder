package com.UrbanLadder.pageobject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.UrbanLadder.reusablecomponent.ReusableComponent;
import com.UrbanLadder.uistore.UrbanLadder_ProductDetailsUI;
import com.UrbanLadder.utility.Datadriven;
import com.UrbanLadder.utility.ExcelReader;
import com.UrbanLadder.utility.Log;

public class UrbanLadder_ProductDetails extends UrbanLadder_ListOfProductPage {
	static WebDriver driver;
	public static void saleAvailability() throws IOException, InterruptedException 
	{
		driver=ReusableComponent.WebDriver();
		Thread.sleep(1000);
		driver.get(url);
		driver.manage().window().maximize();
		arlist.addAll(ExcelReader.excel("Sale"));
		String expected=arlist.get(count);
		String actual=driver.findElement(UrbanLadder_ProductDetailsUI.saleAvailability).getText();
		if(expected.equals(actual))
		{	
			Log.log2.info("Product is available on sale");
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
	public static void emicheck() throws IOException
	{
		String expected=Datadriven.datadriver("EMIcheck");
		String actual=driver.findElement(UrbanLadder_ProductDetailsUI.emicheck).getText();
		if(actual.contains(expected))
		{
			Log.log2.info("EMI is available");
		}
		else
		{
			Date d = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
		}
	}
	public static void addtocart()
	{
		driver.findElement(UrbanLadder_ProductDetailsUI.addtocart).click();
	}
	

}
