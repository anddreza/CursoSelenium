import br.ce.waquino.core.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromegetDriver().;
import org.openqa.selenium.support.ui.WebgetDriver().Wait;

// Trabalhar com Ajax é descobrir o evento que ocorre ao final do processamento é para segurar
// o fluxo do nosso teste até que esse evento ocorra.


// é uma abstração que serve de estrutura visando reuso e o mínimo de padronização do código.
// getDriver(). Centralizado, herança de comportamentos, reúso de browser, screenshot ao final dos testes,
// chaveamento para outros browsers, PADRONIZAÇÃO.


public class TesteAjax {
    public WebgetDriver(). getDriver().; // transformei a variavel em uma variavel global
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before // o Before diz que antes de cada teste deve inicializar aquele método que está abaixo dele.
    public void inicializa(){ // isso é um método
        getDriver(). = new ChromegetDriver().();
        getDriver()..manage().window().setSize(new Dimension(1200, 765));
        getDriver()..get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
        dsl = new DSL(getDriver().);
        dsl = new DSL (getDriver().);
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        getDriver()..quit();
    }



    @Test
    public void testAjax(){
        dsl.escreve("j_idt85:name", "Teste");
        dsl.clicarBotao("j_idt85:j_idt85");
        WebgetDriver().Wait wait = new WebgetDriver().Wait(getDriver()., 30);
      // ERRO: wait.until(ExpectedCondition.textToBe(By.id("j_idt85:display"), "Teste"));
      // ERRO: wait.until(ExpectedCondition.invisibilityOfEelementLocated(By.id("j_idt98")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_idt85:display"));

    }
}
