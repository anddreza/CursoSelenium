import br.ce.waquino.core.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromegetDriver().;
import org.openqa.selenium.support.ui.WebgetDriver().Wait;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {
    public WebgetDriver(). getDriver().;
    private DSL dsl;


    @Before
    public void inicializa(){
        getDriver(). = new ChromegetDriver().();
        getDriver()..manage().window().setSize(new Dimension(1200, 765));
        dsl = new DSL(getDriver().);
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        getDriver()..quit();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve("novoCampo", "Deu certo?");

    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        getDriver()..manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escreve("novoCampo", "Deu certo?");
        getDriver()..manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        WebgetDriver().Wait wait = new WebgetDriver().Wait(getDriver()., 30); // vai parar por até 30 segundos
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu certo?");

    }




}
