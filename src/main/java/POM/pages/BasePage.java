package POM.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    static WebDriver driver;

    public static void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void typeText(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.click();
        element.sendKeys(text);
    }


    public void scrollElemento(By element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

    public static void elementPrecence(By locator) throws Exception {
        //By element = driver.findElement(locator);
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            throw new Exception("error");
        }

    }

    public static void isClieckeable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean validarUrl(String path) {
        return driver.getCurrentUrl().contains(path);
    }

    public void aceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void dismmisAlert1(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void dismmisAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Espera de hasta 10 segundos
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

    }

    public static void getTitle(String title){
        driver.getTitle().contentEquals(title);
    }

    public static String  getText(By locator){
        String text =driver.findElement(locator).getText();
        return text;
    }

    //public static int sizeList(By locator, int num) {
    public static int sizeList(By locator) {
            List<WebElement> list = driver.findElements(locator);

            //System.out.println(list.size());
            int size = list.size();
            //System.out.println("Tamaño de size " + list);
            return size;
    }


    public static void listaElemento(By locator, String text) {
        List<WebElement> list = driver.findElements(locator);

        for (int i = 0; i <list.size() ; i++) {
            WebElement lista = list.get(i);
            if (lista.getText().toUpperCase().contains(text.toUpperCase())){
                System.out.println("Metodo listaElemento " + lista.getText());
                lista.click();
                break;
            }else{
                System.out.println("elemento no encontrado" + text);
            }
        }

    }

    public static void deleteElmentList(By locator) {
        List<WebElement> list = driver.findElements(locator);

        for (int i = 0; i < list.size(); i++) {
            WebElement lista = list.get(i);
            lista.click();
            System.out.println("Elemento eliminado");
        }

    }

    public static void wait(int sec) throws InterruptedException {
        Thread.sleep(sec * 800);

    }


}
