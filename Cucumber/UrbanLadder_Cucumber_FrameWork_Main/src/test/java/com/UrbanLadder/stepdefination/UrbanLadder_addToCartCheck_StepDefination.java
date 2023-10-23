package com.UrbanLadder.stepdefination;

import com.UrbanLadder.pageobject.UrbanLadder_addToCartCheck;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrbanLadder_addToCartCheck_StepDefination {
	 @Given("^user landed on homepage$")
	    public void user_landed_on_homepage() throws Throwable {
	        UrbanLadder_addToCartCheck.landHomePagr();
	    }

	    @When("^user clicks cart icon$")
	    public void user_clicks_cart_icon() throws Throwable {
	    	UrbanLadder_addToCartCheck.addtocart();
	    }

	    @Then("^Product should display$")
	    public void product_should_display() throws Throwable {
	    	UrbanLadder_addToCartCheck.checkaddtocart();
	    }
}
