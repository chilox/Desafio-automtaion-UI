package testRunner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"json:test/report/cucumber_report.json"},
        tags = "@regresion"

)

public class TestRunner {

    @AfterClass
    public static void finish() throws IOException {
        try {
            System.out.println("Generando reporte");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte generado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
