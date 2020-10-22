package br.rv.andrea.steps;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class Aprendendo_Cucumber_Steps {

	@Given("^que criei o arquivo corretamente$")
	public void que_criei_o_arquivo_corretamente() throws Throwable {
	}

	@When("^executá-lo$")
	public void executá_lo() throws Throwable {
	}

	@Then("^a especificação deve finalizar com sucesso$")
	public void a_especificação_deve_finalizar_com_sucesso() throws Throwable {
	}
	
	private int contador = 0;
	
	@Given("^contador deverá iniciar com (\\d+)$")
	public void contadorDeveráIniciarCom(int arg1) throws Throwable {
		 contador = arg1;
	}

	@When("^contador for incrementado com (\\d+)$")
	public void contadorForIncrementadoCom(int arg1) throws Throwable {
		 contador = contador + arg1;
	}

	@Then("^contador será (\\d+)$")
	public void contadorSerá(int arg1) throws Throwable {
		System.out.println(arg1);
		System.out.println(contador);
		System.out.println(contador == arg1);
	//	Assert.assertTrue(contador == arg1);
		Assert.assertEquals(arg1, contador);
	}
	
	Date entrega = new Date();
	
	
	@Given("^que o prazo da entrega seja (\\d+)/(\\d+)/(\\d+)$")
	public void que_o_prazo_da_entrega_seja(int dia, int mes, int ano) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();
		
	}

	@When("^a entrega atrasar em (\\d+) (dias|meses)$")
	public void a_entrega_atrasar_em_dias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
			
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);
		}
		entrega = cal.getTime();
	}

	@Then("^a entrega será efetuada em (\\d{2}/\\d{2}/\\d{4})$")
	public void a_entrega_será_efetuada_em(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
		
	}
	
	
	@Given("^que o ticket( especial)? é A.(\\d{3})$")
	public void que_o_ticket_é_AF(String tipo, int arg1) throws Throwable {
	  
	}

	@Given("^que o valor da passagem é R\\$ (\\d+),(\\d+)$")
	public void que_o_valor_da_passagem_é_R$(int arg1, int arg2) throws Throwable {
	   
	}

	@Given("^que o nome do passageiro é \"(.{5,20})\"$")
	public void que_o_nome_do_passageiro_é(String arg1) throws Throwable {
	
	}

	@Given("^que o telefone do passageiro é ([8-9]{4})-(\\d+)$")
	public void que_o_telefone_do_passageiro_é(int arg1, int arg2) throws Throwable {
	
	}

	@When("^criar os steps$")
	public void criar_os_steps() throws Throwable {
	 
	}

	@Then("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable {
	
	}
	
}
