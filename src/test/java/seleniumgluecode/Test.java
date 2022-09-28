package seleniumgluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

public class Test {

    private static WebDriver driver;
    private DriverManager driverManager;

    private int code;

    String url="https://reqres.in/api/users?page=2";
    @Given("El usuario debe estar en la pagina home de imalittletester")
    public void el_usuario_debe_estar_en_la_pagina_home_de_imalittletester() {
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();

        driver.get("https://imalittletester.com/");

        String encabezado= "imalittletester – Testing. With Java, Selenium, TestNG, Maven, Spring, IntelliJ and friends.";
    Assert.assertEquals(encabezado,driver.getTitle());
    }
    @When("Hace click sobre el boton the little tester Comics")
    public void hace_click_sobre_el_boton_the_little_tester_comics() {
    driver.findElement(By.xpath("//a[contains(text(),'The Little Tester comics')]")).click();

    }
    @Then("Se debe redirigir a la pantalla Comicos")
    public void se_debe_redirigir_a_la_pantalla_comicos() {
        // Write code here that turns the phrase above into concrete actions
        WebElement textofinal= driver.findElement(By.className("page-title"));
        Assert.assertEquals("Category: comics",textofinal.getText());
        driverManager.quitDriver();

    }

    @Given("El usuario debe tener la url lista a consultar")
    public void el_usuario_debe_tener_la_url_lista_a_consultar() {
        // Write code here that turns the phrase above into concrete actions
      if(url=="https://reqres.in/api/users?page=2"){
          System.out.println("URL es la correcta");
      }else {
          System.out.println("Error URL");
      }
    }
    @When("Consulta la url para obtener respuesta")
    public void consulta_la_url_para_obtener_respuesta() {
        Response resp= RestAssured.get("https://reqres.in/api/users?page=2");
        code=resp.getStatusCode();
        System.out.println(" Status code is "+code);
    }
    @Then("Obtiene respuesta http200")
    public void obtiene_respuesta_http200() {
        Assert.assertEquals(code, 200);

    }

}
