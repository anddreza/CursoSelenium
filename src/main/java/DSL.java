import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DSL {

    public WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

//    public void escreve(String id_campo, String texto){
//        driver.findElement(By.id(id_campo)).sendKeys(texto);
//
//    }
//
//    public String obterValorCampo(String id_campo){
//        return driver.findElement(By.id(id_campo)).getAttribute("value");
//
//    }
//
//    public void clicarRadio(String id ){
//    driver.findElement(By.id(id)).click();
//        }
//
//    public boolean isRadioMarcado(String id){
//        return driver.findElement(By.id(id)).isSelected();
//    }
//
//    public void selecionarCombo(String id, String valor){
//        WebElement element = driver.findElement(By.id(id));
//        Select combo = new Select(element);
//        combo.selectByVisibleText(valor);
//    }
//
//    public String obterValorCombo(String id){
//        WebElement element = driver.findElement(By.id(id));
//        Select combo = new Select(element);
//        return combo.getFirstSelectedOption().getText();
//    }
//
//    public void clicarBotao(String id){
//        driver.findElement(By.id("buttonSimple")).click();
//    }
//
//    public void clicarClick(String link){
//        driver.findElement(By.linkText(link)).click();
//    }
//
//
//    public String obterTexto(By by){
//        return driver.findElement(by).getText();
//
//    }
//
//    public String obterTexto(String id){
//        return obterTexto(By.id(id));
//
//    }
//
//
//    public void clicarCheck(String s) {
//        driver.findElement(By.id("")).click();
//    }
//
//    public int obterQuantidadeOpcoesCombo(String s) {
//        driver.findElement(By.id("combo")).click();
//        return 0;
//    }
//
//    public boolean verificarOpcaoCombo(String s, String mestrado) {
//
//    }
    // TextField e textArea
    public void escreve(By by, String texto){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }
    public void escreve(String id_campo, String texto){
        escreve(By.id(id_campo), texto);

    }
    public String obterValorCampo(String id_campo){
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }
    // Radio e Check
    public void clicarRadio(String id){
        driver.findElement(By.id(id)).click();

    }
    public boolean isRadioMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }
    public void clicarCheck(String id){
        driver.findElement(By.id(id)).click();

    }
    public boolean isCheckMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    // Combo

    public void selecionarCombo (String id, String valor){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select (element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select (element);
        combo.selectByVisibleText(valor);
    }
    public String obterValorCombo(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select (element);
        return combo.getFirstSelectedOption().getText();
    }
    public List<String> obterValoresCombo(String id){
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao: allSelectOptions){
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List <WebElement> options = combo.getOptions();
        return options.size();

    }

    public boolean verificarOpcaoCombo(String id, String opcao){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select (element);
        List <WebElement> options = combo.getOptions();
        for (WebElement option: options){
            if (option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    // Botão
    public void clicarBotao(String id){
        driver.findElement(By.id(id)).click();
    }

    public String obterValueElemento(String id){
        return driver.findElement(By.id(id)).getAttribute("value");
    }

    // Link
    public void clicarLink(String link){
        driver.findElement(By.linkText(link)).click();
    }

    // textos
    public String obterTexto(By by){
        return driver.findElement(by).getText();
    }
    public String obterTexto(String id){
        return obterTexto(By.id(id));
    }
    // Alerts
    public String alertaObterTexto(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String alertaObterTextoENega(){
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
        System.out.println("");
    }

    public void alertaEscrever(String valor){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    // Frames e Janelas
    public void entrarFrame(String id){
        driver.switchTo().frame(id);
    }
    public void sairFrame(){
        driver.switchTo().defaultContent();
    }

    public void trocarJanela(String id){
        driver.switchTo().window(id);
    }

    // JS
    public Object executarJS(String cmd, Object... param){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }

}



