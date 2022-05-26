import br.ce.waquino.core.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromegetDriver().;

public class TestePrime {

        public WebgetDriver(). getDriver().; // transformei a variavel em uma variavel global
        private DSL dsl;


        @Before
        public void inicializa(){ // isso é um método
            getDriver(). = new ChromegetDriver().();
            getDriver()..manage().window().setSize(new Dimension(1200, 765));
            dsl = new DSL(getDriver().);
        }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        getDriver()..quit();
    }

    @Test
    public void deveInteragirComRadioPrime(){
        getDriver()..get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
        dsl.clicarRadio(By.xpath("//input[@id='id_idt86:console:0']/../..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));

        dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
    }

    @Test
    public void deveInteragirCOmSelectPrime(){
        getDriver()..get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
        dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
        dsl.clicarRadio(By.xpath("//*[@id='j_idt86:console_input']/../..//span"));
        dsl.clicarRadio(By.xpath("//*[=\"id='j_idt86:console_items']//li[.='PS4']"));
        Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));

    }




}
