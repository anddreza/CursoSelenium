import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter (value=1)
    public String sobrenome;
    @Parameterized.Parameter (value=2)
    public String sexo;
    @Parameterized.Parameter (value=3)
    public List<String> comidas;
    @Parameterized.Parameter (value=4)
    public String[] esportes;
    @Parameterized.Parameter (value=5)
    public String msg;

    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }

    @After // O After diz que depois de cada teste deve finalizar.
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
        {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
        {"Wagner", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
        {"Wagner", "Costa", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
        {"Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
                {"Wagner", "Costa", "", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}


        });
    }

    @Test
    public void deveValidarRegras(){
            page.setNome(nome);
            page.setSobrenome(sobrenome);
            if (sexo.equals("Masculino")) {
                page.setSexoMasculino();
            }
        if (sexo.equals("Feminino")) {
                page.setSexoFeminino();
            }
            if (comidas.contains("Carne")) page.setComidaCarne();
            if (comidas.contains("Pizza")) page.setComidaPizza();
            if (comidas.contains("Vegetariano")) page.setComidaVegetariano();
            page.setEsportes(esportes);
            page.cadastrar();

        System.out.println(msg);
            Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
    }
}
