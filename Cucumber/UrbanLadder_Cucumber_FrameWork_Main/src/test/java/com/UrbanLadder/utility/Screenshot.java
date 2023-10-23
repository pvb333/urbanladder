package com.UrbanLadder.utility;

import java.io.File;
import java.io.IOException;

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
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Nitin\\Desktop\\Comprehensive\\screenshot.png"));
	}

}
