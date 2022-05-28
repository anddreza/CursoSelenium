import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteCampoTreinamento {
    private DSL dsl;
    @Before
    public void inicializa(){ // isso é um método
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }
    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void testeTextField() {
        dsl.escreve("elementosForm:nome", "Teste de escrita");
       // getDriver()..findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));

    }

    @Test
    public void deveInteragirComTextArea() {
        dsl.escreve("elementosForm:sugestoes", "teste");
        Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));

    }

    @Test
    public void deveInteragirComRadioButton() {
    dsl.clicarRadio("elementosForm:sexo:0");
    Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
    }

    @Test
    public void deveInteragirComCheckbox(){

    dsl.clicarCheck("elementosForm:comidaFavorita:2");
    Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void deveInteragirComCombo() {
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

    }
        @Test
        public void deveVerificarValoresCombo() {
            Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
            Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));

    }

    @Test
    public void deveVerificarValoresComboMultiplico() {
        dsl.selecionarCombo("elementosForm: esportes", "Natacao");
        dsl.selecionarCombo("elementosForm: esportes", "Corrida");
        dsl.selecionarCombo("elementosForm: esportes", "O que eh esporte?");
        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
       Assert.assertEquals(3, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
       Assert.assertEquals(2, opcoesMarcadas.size());
       Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void deveInteragirComBotoes() {
        dsl.clicarBotao("buttonSimple");

        Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
    }

    @Test
    public void deveInteragirComLinks() {
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));

    }

    @Test
    //@Ignore
    public void deveBuscarTextosNaPagina() {
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                dsl.obterTexto(By.className("facilAchar")));
    }

    @Test
    public void testeJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }

    @Test
    public void deveClicarBotaoTabela(){
        dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
    }

}