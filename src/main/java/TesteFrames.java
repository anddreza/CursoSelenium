import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteFrames {

  //  private WebgetDriver(). getDriver().; // transformei a variavel em uma variavel global
    private DSL dsl;

    @Before // o Before diz que antes de cada teste deve inicializar aquele método que está abaixo dele.
    public void inicializa(){ // isso é um método
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void deveInteragirComFrame(){

//        getDriver()..switchTo().frame("frame1");
//        getDriver()..findElement(By.id("frameButton")).click();
//        Alert alert = getDriver()..switchTo().alert();
//        String msg = alert.getText();
//        Assert.assertEquals("Frame OK!", msg);
//        alert.accept();
////
//        getDriver()..switchTo().defaultContent();
//        getDriver()..findElement(By.id("elementosForm:nome")).sendKeys(msg);
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        dsl.sairFrame();
        dsl.escreve("elementosForm:nome", msg);



    }

    @Test
    public void deveInteragirComFrameEscondido(){
        WebElement frame = getDriver().findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        dsl.entrarFrame("frame2");

        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }

    @Test
    public void deveInteragirComJanelas(){

//        getDriver()..findElement(By.id("buttonPopUpEasy")).click();
//        getDriver()..switchTo().window("Popup");
//        getDriver()..findElement(By.tagName("textarea"));
//     //   getDriver()..close();
//     //   getDriver()..switchTo().window("");
//        getDriver()..findElement(By.tagName("textarea"));
//
//        getDriver()..quit();
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.trocarJanela("Popup");
        dsl.escreve(By.tagName("textarea"), "teste1");
        getDriver().close();
        dsl.trocarJanela("");
        dsl.escreve(By.tagName("textarea"), "teste2");

    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {

//        getDriver()..findElement(By.id("buttonPopUpHard")).click();
//        System.out.println(getDriver()..getWindowHandle());
//        System.out.println(getDriver()..getWindowHandles());
//
//        getDriver()..switchTo().window((String) getDriver()..getWindowHandles().toArray()[1]);
//        getDriver()..findElement(By.tagName("textarea"));
//        getDriver()..switchTo().window((String) getDriver()..getWindowHandles().toArray()[0]);
//        getDriver()..findElement(By.tagName("textarea"));

        dsl.clicarBotao("buttonPopUpHard");
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getWindowHandles());
        dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
        dsl.escreve(By.tagName("textarea"), "Deu certo");
        getDriver().close();
        dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
        dsl.escreve(By.tagName("textarea"), "e agora");

    }
}
