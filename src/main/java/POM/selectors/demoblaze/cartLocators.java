package POM.selectors.demoblaze;

import org.openqa.selenium.By;

public class cartLocators {
    public static final By productCantLoc = By.id("tbodyid");
    public static final By elementProdLoc = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr");
    public static final By btnPlaceOrder = By.xpath("//button[@data-target='#orderModal']");
    public static final By deleteOrderBtn = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr/td[4]/a");

    /*Modal de place order*/

    public static final By modalPlaceOrderLoc = By.xpath("//div[@class='modal-dialog']/div[1]");
    public static final By nameInputLocator = By.id("name");
    public static final By contryInputLocartor = By.id("country");
    public static final By cityInputLocator = By.id("city");
    public static final By cardInputLocator = By.id("card");
    public static final By monthInputLocator = By.id("month");
    public static final By yearInputLocator = By.id("year");
    public static final By purchaseBtnLocator = By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]");

    /*PopUp*/
    public static final By popUpLocator = By.xpath("/html/body/div[@class='sweet-alert  showSweetAlert visible']/p");
    public static final By btnPopUpAcept = By.xpath("/html/body/div[9]/div[7]/div/button");
}
