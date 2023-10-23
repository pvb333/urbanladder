package com.UrbanLadder.reusablecomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.UrbanLadder.utility.*;

public class ReusableComponent {
	
	public static WebDriver WebDriver() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",Datadriven.datadriver("driver"));
		WebDriver driver=new ChromeDriver();
		return driver;
		
		
	}

}
