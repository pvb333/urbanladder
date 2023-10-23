package com.UrbanLadder.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UrbanLadder_ListOfProductPageUI {
	public static By verifysearch=By.xpath("(//span[@class='key'])[1]");
	public static By category=By.xpath("(//li[@class='item'])[1]");
	public static By studyTableSelect=By.xpath("//li[@data-option-name='Study Tables']");
	public static By verifyStudyTableResult=By.xpath("(//span[@class='text'])[1]");
	public static By sizeoftable=By.xpath("//span[@class='name']");
	public static By hovering=By.xpath("//div[@data-option-name='In Stock Only']");
	public static By inStock=By.xpath("//input[@value='In Stock Only']");
	public static By instockVerify=By.xpath("(//span[@class='text'])[2]");
	public static By sortBy=By.xpath("//div[@data-group='sorting']");
	public static By sorting=By.xpath("//li[@data-key='price_asc']");
	public static By cost=By.xpath("//div[@class='price-number']//span");
	public static By listofproduct=By.xpath("//div[@class='product-info-block']");
	public static By popup=By.xpath("//a[@data-gaaction='popup.auth.close']");

}
