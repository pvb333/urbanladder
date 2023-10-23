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

import com.UrbanLadder.reusablecomponent.*;
import com.UrbanLadder.uistore.*;
import com.UrbanLadder.utility.*;


public class UrbanLadder_HomePage {
	public static WebDriver driver; // we have to define this variable as a static variable because it is a class variable
	static ArrayList<String> arlist=new ArrayList<String>();
	static int count=0;
	public static void homepage() throws IOException
	{	
		
		driver=ReusableComponent.WebDriver();
		driver.manage().window().maximize();
		driver.get(Datadriven.datadriver("website"));
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		String expected="urbanladder";
		if(currenturl.contains(expected))
		{
			Log.log.info("Landed on urbanladder website");		
		}
		else
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss"); 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
		}
		
	}
	public static void SearchProduct() throws FileNotFoundException, IOException, InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		arlist.addAll(ExcelReader.excel("Search"));
		driver.findElement(UrbanLadderHomePageUI.searchbox).click();
		Thread.sleep(1000);
		driver.findElement(UrbanLadderHomePageUI.searchbox).sendKeys(arlist.get(count));
		Thread.sleep(1000);
		driver.findElement(UrbanLadderHomePageUI.searchbox).sendKeys(Keys.ENTER);
		arlist.removeAll(arlist);
		
		
	}
}
