Feature: Flujo de compra
  Vamos a estar validando el flujo de la compra de articulos y todos los componentes que integran el mismo


  Background: Inicio de sessión
    Given validamos que nos encontramos en la home "index"
    When Iniciamos sesión con el usuario 'user18test' y pass 'Testing1'
    Then Validamos que se inicio sessión correctamente


  @browser @regresion
  Scenario Outline: Agregar articulos de varias categorías
    Given Seleccionamos la categoria '<Categoria>'
    Then Agregamos el articulo al carro de compras '<Articulo>'


  Examples:
    | Categoria | Articulo      |
    | Phones    | Samsung       |
    | Laptops   | Macbook Pro   |
    | Monitors  | Apple monitor |

  @browser @regresion
  Scenario Outline: Validar la actualización del carro de compras
    Given Validar que el carro de compras se encuentre vacío
    When Navegamos hacia la home
    When Seleccionamos la categoria '<Categoria>' y un articulo '<Articulo>'
    Then Navegamos al carro de compras
    And validamos que se agregará el articulo
    Examples:
      | Categoria | Articulo      |
      | Phones    | Samsung       |
      | Laptops   | Macbook Pro   |
      | Monitors  | Apple monitor |

  @browser @regresion
  Scenario Outline: Flujo Checkout con visualización del número de tarjeta
    Given Seleccionamos la categoria '<Category>'
    When Agregamos el articulo al carro '<Articulo>'
    And Validamos que estamos en la sección de producto '<url>'
    When Navegamos al carro de compras
    And Validamos que se actualiza el carro
    And Realizar pedido
    When Validar la apertura del formulario de datos
    And Ingresar nombre '<Nombre>', Country '<Country>', Ciudad '<City>', Card '<CreditCard>', Mes '<Mes>', Año '<Año>'
    Then Completar la compra
    And Validar que la tarjeta de credito sea correcta '<CreditCard>'

    Examples:
      | Category | Nombre | Country   | City    | CreditCard       | Mes | Año  | Articulo | url  |
      | PHONES   | Juan   | Argentina | Mendoza | 1234111123548978 | 01  | 2025 | Samsung  | prod |







