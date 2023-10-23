package com.UrbanLadder.runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.UrbanLadder.pageobject.*;
import com.UrbanLadder.reusablecomponent.ReusableComponent;
import com.UrbanLadder.utility.Datadriven;
import com.UrbanLadder.utility.ExcelReader;
import com.UrbanLadder.utility.Log;
import com.UrbanLadder.utility.Screenshot;



public class Runner {
	static WebDriver driver;
	static int count=0;
	static ArrayList<String> arlist=new ArrayList<String>();
	static String searchurl=null;
	@Test(priority=1)
	public static void homepage() throws IOException
	{
		UrbanLadder_HomePage.homepage();
	}
	@Test(priority=2)
	public static void search() throws FileNotFoundException, IOException, InterruptedException
	{
		UrbanLadder_HomePage.SearchProduct();
	}
	@Test(priority=3)
	public static void UrbanLadder_ListOfProduct() throws FileNotFoundException, IOException, InterruptedException
	{
		UrbanLadder_ListOfProductPage.verifySearchResult();
	}
	@Test(priority=4)
	public static void SelectStudyTable() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ListOfProductPage.SelectStudyTable();
	}
	@Test(priority=5)
	public static void InStock() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ListOfProductPage.instockproduct();
	}
	@Test(priority=6)
	public static void SortResult() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ListOfProductPage.sortResult();
	}
	@Test(priority=7)
	public static void selectProduct() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ListOfProductPage.selectProduct();;
	}
	@Test(priority=8)
	public static void SaleAvailability() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ProductDetails.saleAvailability();
	}
	@Test(priority=9)
	public static void EMIcheck() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ProductDetails.emicheck();
	}
	@Test(priority=10)
	public static void addtocart() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_ProductDetails.addtocart();
	}
	@Test(priority=11)
	public static void checkaddtocart() throws InterruptedException, FileNotFoundException, IOException
	{
		UrbanLadder_addToCartCheck.addtocartcheck();
	}
}
