Feature: Factura de venta

  Scenario: Factura de venta generada correctamente
    Given que el usuario está en la página Factura de Venta
    And el usuario "Juan Pérez moo" en el campo de cliente
    And EL usuario selcciona "PRINCIPAL" del campo en almacenes
    And El usuario selecciona "CONTADO" del campo de condicion de pago
    And El usuario selecciona "TALADRO BOSCH - $50" del campo de productos
    And El usuario hace click en el botón "Agregar Producto"
    And El usuario adiciona una unidad de cantidad de "4" al Producto
    When El usuario hace clic en el botón registrar venta
    Then El sistema debe mostrar que la factura fue generada exitosamente
