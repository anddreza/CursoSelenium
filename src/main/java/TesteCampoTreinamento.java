import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteCampoTreinamento {

    public WebDriver driver; // transformei a variavel em uma variavel global
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

      //  driver.quit();
    }



    @Test
    public void testeTextField() {
        dsl.escreve("elementosForm:nome", "Teste de escrita");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));

    }

    @Test
    public void deveInteragirComTextArea() {
        dsl.escreve("elementosForm:sugestoes", "teste");
        //driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        // driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
        Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));

    }

    @Test
    public void deveInteragirComRaddiusButton() {

    dsl.clicarRadio("elementosForm:sexo:0");
    Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
    }

    @Test
    public void deveInteragirComCheckbox(){

    dsl.clicarCheck("elementosForm:comidaFavorita:2");
    Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void deveInteragirComCombo() {
      //  WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
       // Select combo = new Select(element);
       // combo.selectByIndex(3);
        //combo.selectByValue("superior");
       // combo.selectByVisibleText("2o grau completo");
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

    }
        @Test
        public void deveVerificarValoresCombo() {

           // WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
           // Select combo = new Select(element); // encontra o combo e transforma em uma instancia do select
           // List<WebElement> options = combo.getOptions();
           // Assert.assertEquals(8, options.size());

//            boolean encontrou = false;
//            for (WebElement option: options){
//                if (option.getText().equals("Mestrado")) {
//                    encontrou = true;
//                    break;
//                }
//            }
//        Assert.assertTrue(encontrou);

            Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
            Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));

    }

    @Test
    public void deveVerificarValoresComboMultiplico() {
        dsl.selecionarCombo("elementosForm: esportes", "Natacao");
        dsl.selecionarCombo("elementosForm: esportes", "Corrida");
        dsl.selecionarCombo("elementosForm: esportes", "O que eh esporte?");

      //  WebElement element = driver.findElement(By.id("elementosForm:esportes"));
       // Select combo = new Select(element);
      //  combo.selectByVisibleText("Natacao");
       // combo.selectByVisibleText("Corrida");
       // combo.selectByVisibleText("O que eh esporte?");


//       List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
//        Assert.assertEquals(3, allSelectOptions.size());
//
//        combo.deselectByVisibleText("Corrida");
//        allSelectOptions = combo.getAllSelectedOptions();
//        Assert.assertEquals(2, allSelectOptions.size());
        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
       Assert.assertEquals(3, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
       Assert.assertEquals(2, opcoesMarcadas.size());
       Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void deveInteragirComBotoes() {
        dsl.clicarBotao("buttonSimple");

       // WebElement botao = driver.findElement(By.id("buttonSimple"));
        //driver.findElement(By.id("buttonSimple")).click();
       // botao.click();

       // Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
    }

    @Test
    @Ignore
    public void deveInteragirComLinks() {
        dsl.clicarLink("Voltar");
       // driver.findElement(By.linkText("Voltar")).click();

        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));

    }

    @Test
    //@Ignore
    public void deveBuscarTextosNaPagina() {

//        System.out.println(driver.findElement(By.tagName("body")).getText());
     //   Assert.assertTrue(driver.findElement(By.tagName("body"))
       //         .getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
//                driver.findElement(By.tagName("h3")).getText());

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                dsl.obterTexto(By.className("facilAchar")));
    }

    @Test
    public void testeJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = driver.findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }

    @Test
}