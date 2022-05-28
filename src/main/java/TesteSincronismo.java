import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;
public class TesteSincronismo {
    private DSL dsl;
    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve("novoCampo", "Deu certo?");

    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
      getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dsl.clicarBotao("buttonDelay");
//        getDriver()..manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escreve("novoCampo", "Deu certo?");
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30); // vai parar por até 30 segundos
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu certo?");

    }
}
