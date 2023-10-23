package com.UrbanLadder.pageobject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.UrbanLadder.reusablecomponent.*;
import com.UrbanLadder.uistore.*;
import com.UrbanLadder.utility.*;


public class UrbanLadder_addToCartCheck extends UrbanLadder_ProductDetails {
	public static void landHomePagr()
	{
		driver.findElement(UrbanLadder_addToCartCheckUI.navigatehomepage).click();
	}
	
	public static void addtocart()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(UrbanLadder_addToCartCheckUI.addtocarticon).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void checkaddtocart() throws IOException
	{
		try {
			arlist.addAll(ExcelReader.excel("Check Product"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected=arlist.get(count);
		String actual=driver.findElement(UrbanLadder_addToCartCheckUI.checkproduct).getText();
		if(expected.equals(actual))
		{
			Log.log3.error("Product Successfully added to cart");
		}
		else
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
		}
		
	}
	

}
