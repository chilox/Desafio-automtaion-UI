package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {
    static WebDriver driver;

    public static void setDriver(WebDriver driver){ helper.driver = driver;}

    //Metodo que nos permite capturar una imagen y almacenarla en un array
    public static byte[] capturarImagenByte(WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot;
        screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    //
    public static void capturarImagenFile(WebDriver driver){

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File trg = new File("/Images/" + obtenerFecha() + ".png");
            FileUtils.copyFile(src, trg);
        }catch (IOException exception){
            System.out.println("Algo esta mal" + exception.getMessage());
        }

    }

    public static String obtenerFecha(){
        return new SimpleDateFormat("HH_mm_ss_MM_yyyy").format(new Date());
    }
}
