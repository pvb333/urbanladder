package com.UrbanLadder.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.UrbanLadder.pageobject.UrbanLadder_HomePage;
import com.UrbanLadder.reusablecomponent.*;

public class Screenshot extends UrbanLadder_HomePage{
	public static void onTestFailure() throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss"); 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\"+sdf.format(d)+"screenshot.png"));
		
		
	}

}
