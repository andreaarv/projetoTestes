package br.rv.andrea.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.rv.andrea.steps",
		tags = {"@funcionais"},
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class RunnerFuncional {
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver;driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("andrea_arv@hotmail.com");
		driver.findElement(By.name("senha")).sendKeys("091192");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
		
	}
}
