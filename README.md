# UI Framework automation testing
UI Automation Framework usando Selenium WebDriver, Cucumber and Java  

#Estructura del framwork
Sección Main:
    -Tenemos el manejador de browser
    -Los hooks
    -Toda la estructura POM (pages locartors y funciones de selenium)
    -Metodos de captura de imagenes


Sección Test:
    -Tenemos todos los stepsdefinitions
    -Clase testRunner en el cual se maneja la ejecución por medio de tags, además, realizamos la ejecución de un reporte
con todos los casos ejecutados y sus posibles fallos y evidencias
    -Features y lenguaje de negocio, cabe destacar que usamos gherkins lo cual permite tener el flujo de pruebas adecuado para
que cualquier perfil pueda leerlo