package br.rv.andrea.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.rv.andrea.steps",
		tags = {"@unitários"},
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner {
	
	}

