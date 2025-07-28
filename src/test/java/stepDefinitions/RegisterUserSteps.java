package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import setup.Setup;

import java.util.List;

import page.RegisterUserPage;


public class RegisterUserSteps {
    RegisterUserPage registerPage = new RegisterUserPage();
    Setup setup = Setup.getInstance();
    WebDriver driver = setup.driver;

    @Given("que el usuario está en la página {string}")
    public void que_el_usuario_esta_en_la_pagina(String pagina) throws InterruptedException {
        driver.get(registerPage.getBaseURLCliente());
        Thread.sleep(2000);
    }

    @And("el usuario ingresa {string} en el campo \"Código del cliente\"")
    public void el_usuario_ingresa_en_codigo_cliente(String valor) throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector(registerPage.getCodClienteId()));
        input.clear();
        Thread.sleep(300);
        input.sendKeys(valor);
    }

    @And("el usuario ingresa {string} en el campo \"Nombre del cliente\"")
    public void el_usuario_ingresa_en_nombre_cliente(String valor) throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector(registerPage.getNombreDelClienteId()));
        input.clear();
        Thread.sleep(300);
        input.sendKeys(valor);
    }

    @And("el usuario ingresa {string} en el campo \"Email\"")
    public void el_usuario_ingresa_en_email(String valor) throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector(registerPage.getEmailId()));
        input.clear();
        Thread.sleep(300);
        input.sendKeys(valor);
    }

    @And("el usuario selecciona {string} del campo \"Tipo de Documento\"")
    public void el_usuario_selecciona_tipo_documento(String opcion) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(registerPage.getDocumentoDeIdentidadIdCombox()));
        combo.click();
       WebElement opcionElemento = driver.findElement(By.xpath("//li[contains(normalize-space(text()),'" + opcion + "')]"));
        opcionElemento.click();
        Thread.sleep(300);
    }

    @And("el usuario ingresa {string} en el campo \"Nro CI_NIT\"")
    public void el_usuario_ingresa_en_nro_ci_nit(String valor) throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector(registerPage.getNumeroPasaporteId()));
        input.clear();
        Thread.sleep(300);
        input.sendKeys(valor);
    }

    @And("el usuario selecciona {string} del campo \"Grupo de Clientes\"")
    public void el_usuario_selecciona_grupo_clientes(String opcion) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(registerPage.getGrupoDeClienteidCombox()));
        combo.click();
       WebElement opcionElemento = driver.findElement(By.xpath("//li[contains(normalize-space(text()),'" + opcion + "')]"));
        opcionElemento.click();
        Thread.sleep(300);
    }

    @When("el usuario hace clic en el botón \"REGISTRAR\"")
    public void el_usuario_hace_clic_en_registrar() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(registerPage.getButtonRegistrar()));
        button.click();
        Thread.sleep(1500);
    }

    @Then("el sistema debe mostrar que el codigo del cliente {string} fue registrado exitosamente")
    public void el_sistema_debe_mostrar_mensaje_exito(String codigo) {
        List<WebElement> secondRow = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        boolean encontrado = secondRow.stream().anyMatch(cell -> cell.getText().trim().equals(codigo));
        Assert.assertTrue("El código del cliente no fue encontrado en la tabla: " + codigo, encontrado);
    }

    private static String getText(WebElement cell) {
        return cell.getText();
    }

    @Then("el sistema muestra una notificacion de usuario ya registrado")
    public void el_sistema_muestra_una_notificacion_de_usuario_ya_registrado() {
        WebElement mensajeElemento = driver.findElement(By.xpath("//*[contains(text(),'El código del cliente ya existe')]"));
        Assert.assertTrue(mensajeElemento.isDisplayed());
    }

    @Then("el sistema muestra una notificacion de debes completar el formulario")
    public void el_sistema_muestra_una_notificacion_de_deber_completar_el_formulario() {
        WebElement mensajeElemento = driver.findElement(By.xpath("//*[contains(text(),'Debes completar el formulario.')]"));
        Assert.assertEquals(mensajeElemento.getText(), "Debes completar el formulario.");
    }
    @Then("el sistema muestra una notificacion de el nombre del cliente es invalido por que no tiene un nombre")
    public void el_sistema_muestra_que_el_nombre_es_invalido() {
        WebElement mensajeElemento = driver.findElement(By.xpath("//p[contains(text(),'Nombre inválido (solo letras y espacios)')]"));
        Assert.assertEquals(mensajeElemento.getText(), "Nombre inválido (solo letras y espacios)");
    }
}