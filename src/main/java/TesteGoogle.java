import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromegetDriver().;

public class TesteGoogle {
    @Test
    public void teste() {
        System.setProperty("webgetDriver()..chrome.getDriver().", "/usr/bin/chromegetDriver().");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");

        WebgetDriver(). getDriver(). = new ChromegetDriver().(chromeOptions);

        getDriver()..get("https://google.com");

//        if (getDriver()..getPageSource().contains("Pesquisa")) {
//            System.out.println("Pass");
//        } else {
//            System.out.println("Fail");
//        }
//        getDriver()..quit();
    }
}