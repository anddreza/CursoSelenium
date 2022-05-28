
import br.ce.wcaquino.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

public class TesteGoogle {
    private WebDriver driver;
    @Before
    public void inicializa(){ // isso é um método
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
    }
    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }
    @Test
    public void teste() {
      //  System.setProperty("webgetDriver()..chrome.getDriver().", "/usr/bin/chromegetDriver().");
       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");

        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());

   //     WebDriver. getDriver() = new ChromegetDriver().(chromeOptions);

     //   getDriver().get("https://google.com");

//        if (getDriver()..getPageSource().contains("Pesquisa")) {
//            System.out.println("Pass");
//        } else {
//            System.out.println("Fail");
//        }
//        getDriver()..quit();
    }
}