package br.rv.andrea.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

//import cucumber.api.PendingException;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.pt.Dado;
//import cucumber.api.java.pt.Então;
//import cucumber.api.java.pt.Quando;




public class CadastrarContasSteps {
	private WebDriver driver;
	
	@Dado("^que desejo adicionar uma conta$")
	public void queDesejoAdicionarUmaConta() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("andrea_arv@hotmail.com");
		driver.findElement(By.name("senha")).sendKeys("091192");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Contas")).click();
	    driver.findElement(By.linkText("Adicionar")).click();
	    
	}

	@Quando("^adiciono a conta \"([^\"]*)\"$")
	public void adicionoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	    driver.findElement(By.tagName("button")).click();
	}
	

	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	    Assert.assertEquals(arg1, texto);
	}

	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After (order = 0, value = "@funcionais")
	public void fecharBrowser () {
		driver.quit();
		System.out.println("terminando");
	}
	
}
