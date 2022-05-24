import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class TesteCadastro {

    public WebDriver driver; // transformei a variavel em uma variavel global
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before // o Before diz que antes de cada teste deve inicializar aquele método que está abaixo dele.
    public void inicializa(){ // isso é um método
            driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Wagner");
       // dsl.escreve("elementosForm:nome", "Wagner");
       //  dsl.escreve("elementosForm:sobrenome", "Costa");
        page.setSobrenome("Costa");

        page.setSexoMasculino();

        // dsl.clicarRadio("elementosForm:sexo:0");
        page.setComidaPizza();
        //dsl.clicarRadio("elementosForm:comidaFavorita:2");

        page.setEscolaridade("Mestrado");
       // dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");

        page.setEsportes("Natacao");
        // dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        page.cadastrar();
       // dsl.clicarBotao("elementosForm:cadastrar");

//        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//        Select combo = new Select(element);
//        combo.selectByVisibleText("2o grau completo");
//        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
//
//        WebElement elements = driver.findElement(By.id("elementosForm:escolaridade"));
//        Select combos = new Select(element); // encontra o combo e transforma em uma instancia do select
//        List<WebElement> options = combo.getOptions();
//        Assert.assertEquals(8, options.size());
//
//        boolean encontrou = false;
//        for (WebElement option: options){
//            if (option.getText().equals("Mestrado")) {
//                encontrou = true;
//                break;
//            }
//        }
        Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
        Assert.assertEquals("Wagner", page.obterNomeCadastro());
        Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Pizza", page.obterComidaCadastro());
        Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao", page.obterEsportesCadastro());


    }

    @Test
    public void deveValidarNomeObrigatorio(){
        page.cadastrar();
      //  dsl.clicarBotao("elementosForm:cadastrar");
//        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
    //    driver.quit();

    }



    @Test
    public void deveValidarSobrenomeObrigatorio(){
        page.setNome("Nome qualquer");
   //     dsl.escreve("elementosForm:nome", "Nome");
  //      driver.findElement(By.id("elementosForm:cadastrar")).click();
    //    Alert alert = driver.switchTo().alert();
     //   Assert.assertEquals("Sobrenome eh obrigatorio?", alert.getText());
    page.cadastrar();
        //dsl.clicarBotao("elementosForm:cadastrar");
    Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());

    }

    @Test
    public void deveValidarSexoObrigatorio(){

//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals("Sexo eh obrigatorio?", alert.getText());
   page.setNome("Nome qualquer");
   page.setSobrenome("Sobrenome qualquer");
   page.cadastrar();
        //     dsl.escreve("elementosForm:nome", "Nome qualquer");
     //   dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarComidaVegetariano(){

//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
//        driver.findElement(By.id("elementosForm:sexo:1")).click();
//        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

//        dsl.escreve("elementosForm:nome", "Nome qualquer");
//        dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
//        dsl.clicarRadio("elementosForm:sexo:1");
//        dsl.clicarRadio("elementosForm:comidaFavorita:0");
//        dsl.clicarRadio("elementosForm:comidaFavorita:3");
//        dsl.clicarBotao("elementosForm:cadastrar");
        page.setNome("Nome qualquer");
        page.setSobrenome("Sobrenome qualquer");
        page.setSexoFeminino();
        page.setComidaCarne();
        page.setComidaVegetariano();
        page.cadastrar();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());



    }

    @Test
    public void deveValidarEsportistaIndeciso(){


//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
//        driver.findElement(By.id("elementosForm:sexo:1")).click();
//        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
//        combo.selectByVisibleText("Karate");
//        combo.selectByVisibleText("O que eh esporte?");
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alert = driver.switchTo().alert();
////        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
//        dsl.escreve("elementosForm:nome", "Nome qualquer");
//        dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
//        dsl.clicarRadio("elementosForm:Sexo:1");
//        dsl.clicarCheck("elementosForm:comidaFavorita:0");

//        dsl.clicarBotao("elementosForm:cadastrar");
        page.setNome("Nome qualquer");
        page.setSobrenome("Sobrenome qualquer");
        page.setSexoFeminino();
        page.setComidaCarne();
        page.setEsportes("Karate", "O que eh esporte?");
//        dsl.selecionarCombo("elementosForm:esportes", "Karate");
//        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        page.cadastrar();

        Assert.assertEquals("Voce faz esporte ou nao", dsl.alertaObterTextoEAceita());


    }
    


}
