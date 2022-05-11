import org.asynchttpclient.Dsl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

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
     //   driver.quit();
    }

    @Test
    public void deveInteragirComAlertSimples() {

        dsl.clicarBotao("alert");
       // driver.findElement(By.id("alert")).click();
        // Alert alert = driver.switchTo().alert();

      //  String texto = alert.getText();
        String texto = dsl.alertaObterTextoEAceita();

        Assert.assertEquals("Alert Simples", texto);
        //alert.accept();

        //driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        dsl.escreve("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm() {


//        //driver.findElement(By.id("confirm")).click();
//        Alert alerta = driver.switchTo().alert();
//        Assert.assertEquals("Confirm Simples", alerta.getText());
//        alerta.accept();
//        Assert.assertEquals("Confirmado", alerta.getText());
//        alerta.accept();
//
//        driver.findElement(By.id("confirm")).click();
//        alerta = driver.switchTo().alert();
//        Assert.assertEquals("Confirm Simples", alerta.getText());
//        alerta.dismiss();
//        Assert.assertEquals("Negado", alerta.getText());
//        alerta.dismiss();
        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoENega());

    }

    @Test
    public void deveInteragirComAlertPrompt() {

//        driver.findElement(By.id("prompt")).click();
//        Alert alerta = driver.switchTo().alert();
//        Assert.assertEquals("Digite um numero", alerta.getText());
//        alerta.sendKeys("12");
//        alerta.accept();
//        Assert.assertEquals("Era 12?", alerta.getText());
//        alerta.accept();
//        Assert.assertEquals(":D", alerta.getText());
//        alerta.accept();

        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());


    }

}
