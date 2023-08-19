package POM.pages.demoblaze;

import POM.pages.BasePage;
import org.openqa.selenium.WebDriver;


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
            System.out.println("Tienes " + productos + " artículos en el carro");

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

    public void elementPresentProduct() throws Exception {
        elementPrecence(btnPlaceOrder);
    }

    public void validateModalPlace() throws Exception {
     elementPrecence(modalPlaceOrderLoc);

    }

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


    public static void validateCardPopUp(String card) throws Exception {
        elementPrecence(popUpLocator);
        if(getText(popUpLocator).contains(card)){
            System.out.println("Validación correcta");
        }
    }

    public void clearTableProducts(){
        deleteElmentList(deleteOrderBtn);
    }

}
