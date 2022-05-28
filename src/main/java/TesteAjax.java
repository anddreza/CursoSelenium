import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

// Trabalhar com Ajax é descobrir o evento que ocorre ao final do processamento é para segurar
// o fluxo do nosso teste até que esse evento ocorra.


// é uma abstração que serve de estrutura visando reuso e o mínimo de padronização do código.
// getDriver(). Centralizado, herança de comportamentos, reúso de browser, screenshot ao final dos testes,
// chaveamento para outros browsers, PADRONIZAÇÃO.
public class TesteAjax {
    private DSL dsl;
    @Before
    public void inicializa(){
        getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
        dsl = new DSL();
    }
    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }
    @Test
    public void testAjax(){
        dsl.escreve("j_idt85:name", "Teste");
        dsl.clicarBotao("j_idt85:j_idt85");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
      // ERRO: wait.until(ExpectedCondition.textToBe(By.id("j_idt85:display"), "Teste"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_idt85:display"));
    }
}
