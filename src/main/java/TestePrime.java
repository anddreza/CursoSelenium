import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TestePrime {
    private DSL dsl;
        @Before
        public void inicializa(){
            getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            dsl = new DSL();
        }
    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void deveInteragirComRadioPrime(){
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
        dsl.clicarRadio(By.xpath("//input[@id='id_idt86:console:0']/../..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));

        dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
    }

    @Test
    public void deveInteragirCOmSelectPrime(){
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
        dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
        dsl.clicarRadio(By.xpath("//*[@id='j_idt86:console_input']/../..//span"));
        dsl.clicarRadio(By.xpath("//*[=\"id='j_idt86:console_items']//li[.='PS4']"));
        Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));

    }




}
