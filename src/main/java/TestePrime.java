import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {

        public WebDriver driver; // transformei a variavel em uma variavel global
        private DSL dsl;


        @Before
        public void inicializa(){ // isso é um método
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            dsl = new DSL(driver);
        }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void deveInteragirComRadioPrime(){
        driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
        dsl.clicarRadio(By.xpath("//input[@id='id_idt86:console:0']/../..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));

        dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
    }

    @Test
    public void deveInteragirCOmSelectPrime(){
        driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
        dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
        dsl.clicarRadio(By.xpath("//*[@id='j_idt86:console_input']/../..//span"));
        dsl.clicarRadio(By.xpath("//*[=\"id='j_idt86:console_items']//li[.='PS4']"));
        Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));

    }





}
