package stepDefinitions;

import POM.pages.demoblaze.CartPageService;
import POM.pages.demoblaze.HomePageService;
import browserFactory.browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class homeSteps {
    HomePageService homePageService = PageFactory.initElements(browser.getDriver(), HomePageService.class);
    CartPageService cartPageService = PageFactory.initElements(browser.getDriver(), CartPageService.class);

    @Given("validamos que nos encontramos en la home {string}")
    public void validamos_que_nos_encontramos_en_la_home(String home) throws Exception {
        homePageService.wait(2);
        System.out.println(home);
        homePageService.validateHome(home);

    }
    @When("Iniciamos sesión con el usuario {string} y pass {string}")
    public void iniciamos_sesión_con_el_usuario_y_pass(String string, String string2) throws Exception {
        homePageService.signIn(string, string2);
    }
    @Then("Validamos que se inicio sessión correctamente")
    public void validamos_que_se_inicio_sessión_correctamente() throws Exception {
        homePageService.validarInicioSesion();
    }
    @Given("Seleccionamos la categoria {string}")
    public void seleccionamos_la_categoria(String string) throws Exception {
        System.out.println(string);
        homePageService.waitElementHome();
        homePageService.categoryIsPresent();
        homePageService.selectCategorie(string);

    }
    @When("Agregamos el articulo al carro de compras {string}")
    public void agregamos_el_articulo_al_carro_de_compras(String string) throws Exception {
        System.out.println(string);
        homePageService.selectProduct(string);
        homePageService.navigateCart();
        cartPageService.clearTableProducts();

    }
    @When("Validamos que estamos en la sección de producto {string}")
    public void validamos_que_estamos_en_la_sección_de_producto(String url) throws Exception {
        homePageService.validarUrl(url);
    }

    @When("Navegamos al carro de compras")
    public void navegamos_al_carro_de_compras() {
        homePageService.navigateCart();
    }

    @When("Validamos que se actualiza el carro")
    public void validamos_que_se_actualiza_el_carro() {
        cartPageService.validateProductCart();
    }

    @When("Realizar pedido")
    public void realizar_pedido() {
        cartPageService.clickPlaceOrder();
    }

    @When("Validar la apertura del formulario de datos")
    public void validar_la_apertura_del_formulario_de_datos() throws Exception {
        homePageService.wait(1);
        cartPageService.validateModalPlace();
    }
    @When("Ingresar nombre {string}, Country {string}, Ciudad {string}, Card {string}, Mes {string}, Año {string}")
    public void ingresar_nombre_country_ciudad_card_mes_año(String string, String string2, String string3, String int1, String int2, String int3) {
        cartPageService.completeFormPlaceOrder(string, string2, string3, int1, int2, int3);
    }
    @Then("Completar la compra")
    public void completar_la_compra() {
        cartPageService.clickCompleteOrder();

    }
    @Then("Validar que la tarjeta de credito sea correcta {string}")
    public void validar_que_la_tarjeta_de_credito_sea_correcta_credir_card(String card) throws Exception {
        homePageService.wait(1);
        try {
            cartPageService.validateCardPopUp(card);
            System.out.println("Las tarjetas coinciden");
        }catch (Exception e){
            throw new Exception("El numero de tarjeta no coincide");
        }

    }

    @Given("Validar que el carro de compras se encuentre vacío")
    public void validar_que_el_carro_de_compras_se_encuentre_vacío() throws InterruptedException {
        homePageService.wait(1);
        homePageService.navigateCart();
        cartPageService.validateProductCart();
    }
    @When("Navegamos hacia la home")
    public void navegamos_hacia_la_home() {
        cartPageService.navigateHome();
    }

    @When("Seleccionamos la categoria {string} y un articulo {string}")
    public void seleccionamos_la_categoria_y_un_articulo(String string, String string2) throws Exception {
        homePageService.selectCategorie(string);
        homePageService.wait(1);
        homePageService.selectProduct(string2);
        homePageService.wait(1);
        homePageService.navigateCart();
        cartPageService.updateCart();
        cartPageService.validateProductCart();
    }

    @Then("validamos que se agregará el articulo")
    public void validamos_que_se_agregará_el_articulo() {
        cartPageService.validateProductCart();
    }




}
