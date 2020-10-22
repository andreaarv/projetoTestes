package br.rv.andrea.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import br.rv.andrea.entidades.Filme;
import br.rv.andrea.entidades.NotaAluguel;
import br.rv.andrea.entidades.TipoAluguel;
import br.rv.andrea.services.AluguelService;
import br.rv.andrea.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
//import cucumber.api.DataTable;
//import cucumber.api.PendingException;
//import cucumber.api.java.pt.Dado;
//import cucumber.api.java.pt.Então;
//import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	String erro;
	private TipoAluguel tipoaluguel;

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoque(arg1);
	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}

	@Dado("^um filme$")
	public void umFilme(DataTable table) throws Throwable {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque"))); 
	    filme.setAluguel(Integer.parseInt(map.get("preco"))); 
	    String tipo = map.get("tipo");
	    tipoaluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}
	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = aluguel.alugar(filme, tipoaluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	}

	/*
	 * @Então("^a data de entrega será no dia seguinte$") public void
	 * aDataDeEntregaSeráNoDiaSeguinte() throws Throwable { Calendar cal =
	 * Calendar.getInstance(); cal.add(Calendar.DAY_OF_MONTH, 1);
	 * 
	 * Date dataRetorno = nota.getDataEntrega(); Calendar calRetorno =
	 * Calendar.getInstance(); calRetorno.setTime(dataRetorno);
	 * 
	 * Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH),
	 * calRetorno.get(Calendar.DAY_OF_MONTH));
	 * Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
	 * Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR)); }
	 */

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	}

	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
		Assert.assertEquals("filme sem estoque", erro);
	}

	@Dado("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
		tipoaluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Então("^a pontuação será de (\\d+) pontos$")
	public void aPontuaçãoSeráDePontos(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getpontuacao());
	}
}
