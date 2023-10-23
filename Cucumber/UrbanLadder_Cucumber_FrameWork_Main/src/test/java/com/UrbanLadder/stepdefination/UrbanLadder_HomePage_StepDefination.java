package com.UrbanLadder.stepdefination;



import org.junit.runner.RunWith;

import com.UrbanLadder.pageobject.UrbanLadder_HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrbanLadder_HomePage_StepDefination {

    @Given("^navigate to Urban Ladder website (.+)$")
    public void navigate_to_urban_ladder_website(String url) throws Throwable {
    	UrbanLadder_HomePage.homepage(url);
    	
       
    }

    @When("^user enter (.+) in the searchbox$")
    public void user_enter_in_the_searchbox(String searchdata) throws Throwable {
    	UrbanLadder_HomePage.EnterSearchData(searchdata);
       
    }

    @Then("^user press Enter Keyword$")
    public void user_press_enter_keyword() throws Throwable {
    	UrbanLadder_HomePage.PressEnter();
        
    }

}
