package com.UrbanLadder.stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.UrbanLadder.pageobject.*;

public class UrbanLadder_ListOfProductPage_StepDefination {
	 @Given("^User landed on searched product page$")
	    public void user_landed_on_searched_product_page() throws Throwable {
		 UrbanLadder_ListOfProductPage.verifySearchResult();
		 
	       
	    }

	    @When("^user selects study table from category$")
	    public void user_selects_study_table_from_category() throws Throwable {
	    	UrbanLadder_ListOfProductPage.SelectStudyTable();
	      
	    }

	    @When("^User select Exclude out of stock checkbox$")
	    public void user_select_exclude_out_of_stock_checkbox() throws Throwable {
	    	UrbanLadder_ListOfProductPage.instockproduct();
	    }

	    @When("^user select Sort by Low to High price$")
	    public void user_select_sort_by_low_to_high_price() throws Throwable {
	    	UrbanLadder_ListOfProductPage.sortResult();
	    }


	    @Then("user selects required product {string}")
	    public void user_selects_required_product(String string) throws FileNotFoundException, IOException, InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    	UrbanLadder_ListOfProductPage.selectProduct(string);
	    }

	    @And("^Study Table result will display$")
	    public void study_table_result_will_display() throws Throwable {
	    	UrbanLadder_ListOfProductPage.verifyselecttable();
	      
	    }

	    @And("^In stock Product gets displayed$")
	    public void in_stock_product_gets_displayed() throws Throwable {
	    	UrbanLadder_ListOfProductPage.verifyinstockproduct();
	 
	    }

	    @And("^Products should get sorted from low to high price$")
	    public void products_should_get_sorted_from_low_to_high_price() throws Throwable {
	    	UrbanLadder_ListOfProductPage.verifysortresult();
	    }

}
