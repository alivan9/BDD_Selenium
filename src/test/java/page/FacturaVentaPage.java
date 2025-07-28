package page;

import lombok.Data;

@Data
public class FacturaVentaPage extends Common {
    private final String baseURLVentas = "http://localhost:3000/ventas/register";
    //    private final String baseURLCliente = "http://localhost:3000/customers";

    private String clienteCombox = "(//div[@role='combobox'])[1]";
    private String almacenesCombox = "(//div[@role='combobox'])[2]";
    private String condicionDePagoCombox = "(//div[@role='combobox'])[3]";
    private String productosCombox = "(//div[@role='combobox'])[4]";
    private String ciCliente = "(//input[@type='text'])[2]";


    private String buttonAgregarProducto = "//button[normalize-space()='Agregar Producto']";
    private String buttonVolverAlListado = "//button[normalize-space()='Volver al Listado']";
    private String buttonRegistrarVenta = "//button[normalize-space()='Registrar Venta']";
    private String buttonAdicionarCantidad = "(//button[@type='button'])[3]";
    private String buttonDisminuirCantidad = "(//button[@type='button'])[2]";

}
