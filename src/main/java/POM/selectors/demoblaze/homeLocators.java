package POM.selectors.demoblaze;

import org.openqa.selenium.By;

public class homeLocators {
    /*Localizadores de la Home*/
    public static final By homeBtnLoc = By.xpath("//ul[@class='navbar-nav ml-auto']/li[1]/a");
    public static final By cartBtnLoc = By.xpath("//ul[@class='navbar-nav ml-auto']/li[4]/a");
    public static final By logInLoc = By.xpath("//ul[@class='navbar-nav ml-auto']/li[5]/a");
    public static final By categPhonesLoc = By.xpath("//*[@id='itemc'][1]");
    public static final By categLaptosLoc = By.xpath("//*[@id='itemc'][2]");
    public static final By categMonitosLoc = By.xpath("//*[@id='itemc'][3]");
    public static final By listProductsLoc = By.xpath("//div[@id='tbodyid']/div/div/div/h4/a");
    public static final By nameUserLoc = By.id("nameofuser");
    public static final By logoHomeLoc = By.xpath("//a[@id='nava']");
    public static final By categorLocator = By.xpath("//*[@id='cat']");

    /*Localizadores del modal de login*/
    public static final By modalLoginLocator = By.xpath("//h5[@id='logInModalLabel']");
    public static final By usernameInputLoc = By.id("loginusername");
    public static final By passwordInputLoc = By.id("loginpassword");
    public static final By loginBtnModal = By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]");
    public static final By closeBtnModal = By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]");

}
