package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import page.FacturaVentaPage;
import setup.Setup;

import java.util.List;

public class FacturaVentaSteps {
    FacturaVentaPage facturaPage = new FacturaVentaPage();
    Setup setup = Setup.getInstance();
    WebDriver driver = setup.driver;

    @Given("que el usuario está en la página Factura de Venta")
    public void que_el_usuario_esta_en_la_pagina() throws InterruptedException {
        driver.get(facturaPage.getBaseURLVentas());
        Thread.sleep(3000);
        WebElement btnMenuVenta = driver.findElement(By.xpath(facturaPage.getBtnMenuVenta()));
        btnMenuVenta.click();
        Thread.sleep(3000);
        WebElement btnRegistrarVenta = driver.findElement(By.xpath(facturaPage.getBtnRegistrarVenta()));
        btnRegistrarVenta.click();
        Thread.sleep(6000);
    }

    @And("el usuario {string} en el campo de cliente")
    public void el_usuario_en_el_campo_de_cliente(String cliente) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(facturaPage.getClienteCombox()));
        combo.click();
        java.util.List<WebElement> opciones = driver.findElements(By.xpath("//li[normalize-space(text())='" + cliente.toUpperCase() + "']"));
        if (!opciones.isEmpty()) {
            opciones.get(0).click();
        } else {
            throw new NoSuchElementException("No se encontró el cliente: " + cliente);
        }
        Thread.sleep(300);
    }

    @And("El usuario ingresa {string} en el campo de NIT_CI")
    public void el_usuario_ingresa_en_el_campo_de_nit_ci(String valor) throws InterruptedException {
        WebElement input = driver.findElement(By.xpath(facturaPage.getCiCliente()));
        input.clear();
        Thread.sleep(300);
        input.sendKeys(valor);
    }

    @And("EL usuario selcciona {string} del campo en almacenes")
    public void el_usuario_selecciona_del_campo_en_almacenes(String almacen) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(facturaPage.getAlmacenesCombox()));
        combo.click();
        java.util.List<WebElement> opciones = driver.findElements(By.xpath("//li[normalize-space(text())='" + almacen + "']"));
        if (!opciones.isEmpty()) {
            opciones.get(0).click();
        } else {
            throw new NoSuchElementException("No se encontró el almacén: " + almacen);
        }
        Thread.sleep(300);
    }

    @And("El usuario selecciona {string} del campo de condicion de pago")
    public void el_usuario_selecciona_del_campo_de_condicion_de_pago(String condicion) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(facturaPage.getCondicionDePagoCombox()));
        combo.click();
        java.util.List<WebElement> opciones = driver.findElements(By.xpath("//li[normalize-space(text())='" + condicion + "']"));
        if (!opciones.isEmpty()) {
            opciones.get(0).click();
        } else {
            throw new NoSuchElementException("No se encontró la condición de pago: " + condicion);
        }
        Thread.sleep(300);
    }

    @And("El usuario selecciona {string} del campo de productos")
    public void el_usuario_selecciona_del_campo_de_productos(String producto) throws InterruptedException {
        WebElement combo = driver.findElement(By.xpath(facturaPage.getProductosCombox()));
        combo.click();
        java.util.List<WebElement> opciones = driver.findElements(By.xpath("//li"));
        boolean seleccionado = false;
        for (WebElement opcion : opciones) {
            if (opcion.getText().trim().equalsIgnoreCase(producto.trim())) {
                opcion.click();
                seleccionado = true;
                break;
            }
        }
        if (!seleccionado) {
            throw new NoSuchElementException("No se encontró el producto: " + producto);
        }
        Thread.sleep(300);
    }

    @And("El usuario hace click en el botón {string}")
    public void el_usuario_hace_click_en_el_boton(String boton) throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='" + boton + "']"));
        button.click();
        Thread.sleep(500);
    }

    @And("El usuario adiciona una unidad de cantidad de {string} al Producto")
    public void el_usuario_adiciona_una_unidad_de_cantidad_al_producto(String cantidad) throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(facturaPage.getButtonAdicionarCantidad()));
        int veces = Integer.parseInt(cantidad);
        for (int i = 1; i < veces; i++)
        button.click();
        Thread.sleep(300);
    }

    @When("El usuario hace clic en el botón registrar venta")
    public void el_usuario_hace_clic_en_el_boton_registrar_venta() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(facturaPage.getButtonRegistrarVenta()));
        button.click();
        Thread.sleep(1500);
    }

    @Then("El sistema debe mostrar que la factura fue generada exitosamente")
    public void el_sistema_debe_mostrar_que_la_factura_fue_generada_exitosamente() {
        WebElement mensajeElemento = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[1]/div[2]"));
        Assert.assertEquals(mensajeElemento.getText(), "Venta registrada correctamente.");

    }
}
