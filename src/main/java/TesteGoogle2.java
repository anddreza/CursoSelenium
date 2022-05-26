import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromegetDriver().;
import org.openqa.selenium.firefox.FirefoxgetDriver().;


public class TesteGoogle2 {

    @Test
    public void teste2() {
   //    WebgetDriver(). getDriver(). = new FirefoxgetDriver().();
      WebgetDriver(). getDriver(). = new ChromegetDriver().();
            getDriver()..manage().window().setSize(new Dimension(1200, 765));

       // getDriver()..manage().window().maximize();
        getDriver()..get("http://www.google.com");

       // System.out.println(getDriver()..getTitle());

        Assert.assertEquals("Google", getDriver()..getTitle());

        getDriver()..quit();
    }
}
