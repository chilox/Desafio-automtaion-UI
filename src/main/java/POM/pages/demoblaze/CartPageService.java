package POM.pages.demoblaze;

import POM.pages.BasePage;
import org.openqa.selenium.WebDriver;


import java.util.Arrays;

import static POM.selectors.demoblaze.cartLocators.*;
import static POM.selectors.demoblaze.homeLocators.*;

public class CartPageService extends BasePage {

    static int productos = 0;
    WebDriver driver;

    public CartPageService(WebDriver driver){
        this.driver = driver;
        BasePage.setDriver(driver);
    }

    /*Metodo que realiza la actualización de los articulos cargados en el Carro de compras*/
    public static void updateCart() throws Exception {
        try {
           productos = sizeList(elementProdLoc);
            //System.out.println("Tienes " + productos + " artículos en el carro");

        }catch (Exception e){
            throw new Exception("El carro se encuentra vacío");
        }
    }

    /*Método que realiza la navegación hacia la Home*/
    public void navigateHome(){
         click(homeBtnLoc);
    }

    /*Valida la cantidad de elementos tiene el Carro y los muestra por consola*/
    public void validateProductCart(){
        if (productos!=0){
            System.out.println("el Carro de compras tiene " + productos + " Artículos cargados");
        }else{
            System.out.println("el carro no tiene artículos cargados");
        }
    }
    /*Click al boton Place order en la sección Cart*/
    public void clickPlaceOrder(){
        click(btnPlaceOrder);
    }

    /*Valida que el btn Place orden se encuentra presente*/
    public void elementPresentProduct() throws Exception {
        elementPresence(btnPlaceOrder);
    }

    public void validateModalPlace() throws Exception {
     elementPresence(modalPlaceOrderLoc);

    }

    /*Mediante este metodo completamos el formulario para completar la orden*/
    public void completeFormPlaceOrder(String string, String string2, String string3, String int1, String int2, String int3){

        typeText(nameInputLocator, string);
        typeText(contryInputLocartor, string2);
        typeText(cityInputLocator, string3);
        typeText(cardInputLocator, int1);
        typeText(monthInputLocator, int2);
        typeText(yearInputLocator, int3);
    }

    public void clickCompleteOrder(){
        click(purchaseBtnLocator);
    }


    /*Valida que la tarjeta ingresada coincida con el output del popup*/
    public static void validateCardPopUp(String card) throws Exception {
        // Verificar la presencia del pop-up
        elementPresence(popUpLocator); // Supongo que esta función verifica si el pop-up está presente

        String texto = getText(popUpLocator);

        // Dividir el texto del pop-up en palabras usando el espacio como separador
        String[] arrayText = texto.split(" ");

        boolean cardFound = false;

        try {
            for (String element : arrayText) {
                if (element.contains(card)) {
                    String cardNumber = element.replace("Name:", "").trim();
                        System.out.println("La tarjeta ingresada: " + cardNumber + " Coincide con: " + card);
                        cardFound = true;
                }
            }

            if (!cardFound) {
                throw new Exception("Las tarjetas no coincide con el pop-up.");
            }
        } catch (Exception e) {
            throw new Exception("Error en la validación del pop-up: " + e.getMessage());
        }
    }

    /*Elimina los articulos cargados en el carro de compras*/
    public void clearTableProducts(){
        deleteElmentList(deleteOrderBtn);
    }

}
