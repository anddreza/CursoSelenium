import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteCadastro {
    private CampoTreinamentoPage page;

    @Before // o Before diz que antes de cada teste deve inicializar aquele método que está abaixo dele.
    public void inicializa() { // isso é um método
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        page = new CampoTreinamentoPage();
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza() {
        killDriver();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Wagner");
        page.setSobrenome("Costa");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsportes("Natacao");
        page.cadastrar();
        Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
        Assert.assertEquals("Wagner", page.obterNomeCadastro());
        Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Pizza", page.obterComidaCadastro());
        Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao", page.obterEsportesCadastro());


    }
}
//
//    @Test
//    public void deveValidarNomeObrigatorio(){
//        page.cadastrar();
//        Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
//
//
//    }
//
//
//
//    @Test
//    public void deveValidarSobrenomeObrigatorio(){
//        page.setNome("Nome qualquer");
//    page.cadastrar();
//
//    Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
//
//    }
//
//    @Test
//    public void deveValidarSexoObrigatorio(){
//   page.setNome("Nome qualquer");
//   page.setSobrenome("Sobrenome qualquer");
//   page.cadastrar();
//   Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
//    }
//
//    @Test
//    public void deveValidarComidaVegetariano(){
//
//        page.setNome("Nome qualquer");
//        page.setSobrenome("Sobrenome qualquer");
//        page.setSexoFeminino();
//        page.setComidaCarne();
//        page.setComidaVegetariano();
//        page.cadastrar();
//        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
//
//    }
//
//    @Test
//    public void deveValidarEsportistaIndeciso(){
//        page.setNome("Nome qualquer");
//        page.setSobrenome("Sobrenome qualquer");
//        page.setSexoFeminino();
//        page.setComidaCarne();
//        page.setEsportes("Karate", "O que eh esporte?");
//        page.cadastrar();
//
//        Assert.assertEquals("Voce faz esporte ou nao", dsl.alertaObterTextoEAceita());
//
//    }
//}
