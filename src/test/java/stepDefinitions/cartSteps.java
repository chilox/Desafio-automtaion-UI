package stepDefinitions;

import POM.pages.demoblaze.CartPageService;
import browserFactory.browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class cartSteps {

    CartPageService cartPageService = PageFactory.initElements(browser.getDriver(), CartPageService.class);


}
