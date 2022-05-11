import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrames {

    private WebDriver driver; // transformei a variavel em uma variavel global
    private DSL dsl;

    @Before // o Before diz que antes de cada teste deve inicializar aquele método que está abaixo dele.
    public void inicializa(){ // isso é um método
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
//        driver.quit();
    }

    @Test
    public void deveInteragirComFrame(){

//        driver.switchTo().frame("frame1");
//        driver.findElement(By.id("frameButton")).click();
//        Alert alert = driver.switchTo().alert();
//        String msg = alert.getText();
//        Assert.assertEquals("Frame OK!", msg);
//        alert.accept();
////
//        driver.switchTo().defaultContent();
//        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        dsl.sairFrame();
        dsl.escreve("elementosForm:nome", msg);



    }

    @Test
    public void deveInteragirComFrameEscondido(){
        WebElement frame = driver.findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        dsl.entrarFrame("frame2");

        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }

    @Test
    public void deveInteragirComJanelas(){

//        driver.findElement(By.id("buttonPopUpEasy")).click();
//        driver.switchTo().window("Popup");
//        driver.findElement(By.tagName("textarea"));
//     //   driver.close();
//     //   driver.switchTo().window("");
//        driver.findElement(By.tagName("textarea"));
//
//        driver.quit();
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.trocarJanela("Popup");
        dsl.escreve(By.tagName("textarea"), "teste1");
        driver.close();
        dsl.trocarJanela("");
        dsl.escreve(By.tagName("textarea"), "teste2");

    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {

//        driver.findElement(By.id("buttonPopUpHard")).click();
//        System.out.println(driver.getWindowHandle());
//        System.out.println(driver.getWindowHandles());
//
//        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
//        driver.findElement(By.tagName("textarea"));
//        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
//        driver.findElement(By.tagName("textarea"));

        dsl.clicarBotao("buttonPopUpHard");
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getWindowHandles());
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
        dsl.escreve(By.tagName("textarea"), "Deu certo");
        driver.close();
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
        dsl.escreve(By.tagName("textarea"), "e agora");

    }
}
