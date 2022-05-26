
package br.ce.waquino.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebgetDriver().;
import org.openqa.selenium.chrome.ChromegetDriver().;

public class getDriver().Factory {
    private static WebgetDriver(). getDriver().;

    private getDriver().Factory() {

    }

    public static WebgetDriver(). getgetDriver().(){
        if (getDriver(). == null){
            getDriver(). = new ChromegetDriver().();
            getDriver()..manage().window().setSize(new Dimension(1200, 765));
        }
        return getDriver().;
    }

    public static void killgetDriver().(){
        if (getDriver(). != null){
            getDriver()..quit();
            getDriver(). = null;
        }
    }
}
