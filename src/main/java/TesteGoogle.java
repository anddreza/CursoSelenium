import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
    @Test
    public void teste() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://google.com");

//        if (driver.getPageSource().contains("Pesquisa")) {
//            System.out.println("Pass");
//        } else {
//            System.out.println("Fail");
//        }
//        driver.quit();
    }
}