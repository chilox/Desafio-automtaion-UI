package hooks;

import browserFactory.browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.helper;

import java.io.File;
import java.util.Locale;

public class hooks {
     WebDriver driver;

    @Before("@browser")
    public void setup(){
        driver = browser.inicializarNavegador(("chrome").toUpperCase());
        driver.get("https://www.demoblaze.com/index.html");
    }

    @After("@browser")
    public void tearDown(Scenario scenario){
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()){
            byte[] sc = helper.capturarImagenByte(driver);
            scenario.attach(sc, "image/png",scenarioName);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();"); // Borrar caché local
        js.executeScript("window.sessionStorage.clear();"); // Borrar caché de sesión
        js.executeScript("window.location.reload();"); // Recargar la página

        driver.quit();
    }
}
