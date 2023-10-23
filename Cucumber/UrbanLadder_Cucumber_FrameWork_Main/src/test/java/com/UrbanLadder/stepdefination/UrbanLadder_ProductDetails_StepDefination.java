package com.UrbanLadder.stepdefination;

import com.UrbanLadder.pageobject.UrbanLadder_ProductDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrbanLadder_ProductDetails_StepDefination {
	@Given("^Product details page displayed$")
    public void product_details_page_displayed() throws Throwable {
     UrbanLadder_ProductDetails.verifypage();
    }

    @When("^user check product is on sale$")
    public void user_check_product_is_on_sale() throws Throwable {
    	UrbanLadder_ProductDetails.saleAvailability();
    }

    @When("^user check product is available on EMI$")
    public void user_check_product_is_available_on_emi() throws Throwable {
    	UrbanLadder_ProductDetails.emicheck();
    }

    @Then("^user click Add to cart$")
    public void user_click_add_to_cart() throws Throwable {
    	UrbanLadder_ProductDetails.addtocart();
    }


}
