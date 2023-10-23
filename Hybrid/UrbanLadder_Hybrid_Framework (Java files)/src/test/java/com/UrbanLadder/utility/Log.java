package com.UrbanLadder.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.UrbanLadder.pageobject.UrbanLadder_HomePage;
import com.UrbanLadder.pageobject.UrbanLadder_ListOfProductPage;
import com.UrbanLadder.pageobject.UrbanLadder_ProductDetails;
import com.UrbanLadder.pageobject.UrbanLadder_addToCartCheck;
import com.UrbanLadder.runner.Runner;






public class Log {
	public static Logger log=LogManager.getLogger(UrbanLadder_HomePage.class.getName());
	public static Logger log1=LogManager.getLogger(UrbanLadder_ListOfProductPage.class.getName());
	public static Logger log2=LogManager.getLogger(UrbanLadder_ProductDetails.class.getName());
	public static Logger log3=LogManager.getLogger(UrbanLadder_addToCartCheck.class.getName());
	

}
