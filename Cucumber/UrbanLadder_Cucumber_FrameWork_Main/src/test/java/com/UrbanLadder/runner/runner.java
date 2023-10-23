package com.UrbanLadder.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/com/UrbanLadder/feature"},
		glue={"com.UrbanLadder.stepdefination"}
		)
public class runner{
	
}