package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.helper;

import java.time.Duration;

public class browser {
    static WebDriver driver = null;

    /*Metodo con el cual se selecciona el browser*/
    public static WebDriver inicializarNavegador(String browser){
        switch (browser){
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Ingreso un navegador no soportado");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    public static WebDriver getDriver(){return driver;}
}
