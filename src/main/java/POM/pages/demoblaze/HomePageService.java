package POM.pages.demoblaze;

import POM.pages.BasePage;
import org.openqa.selenium.WebDriver;


import static POM.selectors.demoblaze.homeLocators.*;
import static POM.selectors.demoblaze.productLocators.*;

public class HomePageService extends BasePage {
    WebDriver driver;

    public HomePageService(WebDriver driver){
        this.driver = driver;
        BasePage.setDriver(driver);
    }

    /*Valida la presencia del elemento categoria*/
    public void waitElementHome() throws Exception {
        elementPrecence(categPhonesLoc);
    }

    /*Metodo que realiza el inicio de sesion*/
    public void signIn(String user, String pass) throws Exception {

        click(logInLoc);
        //elementPrecence(modalLoginLocator);
        typeText(usernameInputLoc, user);
        typeText(passwordInputLoc, pass);
        click(loginBtnModal);

    }

    /*Valida que estamos en la home mediante el endpoint*/
    public static void validateHome(String url) throws Exception {
        wait(2);
        //elementPrecence(logoHomeLoc);
        BasePage.validarUrl(url);

    }

    /*Validamos por medio del usuario que se muestra en la home que se inicio sesion correctamente*/
    public void validarInicioSesion() throws Exception {
        try {
            elementPrecence(nameUserLoc);
        }catch (Exception e){
            throw new Exception("Debe iniciar sesión");
        }
    }

    /*Selecciona la categoria según el valor que se pasa por parametro*/
    public static void selectCategorie(String categ){

        switch (categ.toUpperCase()){
            case "PHONES" :
                click(categPhonesLoc);
                break;
            case "LAPTOPS" :
                click(categLaptosLoc);
                break;
            case "MONITORS" :
                click(categMonitosLoc);
                break;
            default:
                System.out.println("La categoría que ingreso no tiene stock");
        }
    }

    /*Recorre una lista de elemento que almacena todos los productos de una marca y selecciona la primera coincidencia*/
    public void selectProduct(String prod) throws Exception {
        try {
            wait(1);
            listaElemento(listProductsLoc, prod);
            //wait(2);
            click(addCartBtn);
            wait(1);
            aceptAlert();

        }catch (Exception e){
            throw new Exception("El articulo no se encuentra en Stock");
        }
    }

    /*Navega a la sección car*/
    public void navigateCart(){
        click(cartBtnLoc);
    }

    public void categoryIsPresent( ) throws Exception {
        elementPrecence(categorLocator);
    }




}
