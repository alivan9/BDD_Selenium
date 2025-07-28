Feature: User Register

  Scenario: Usuario agregado correctamente
    Given que el usuario está en la página "Registrar Cliente"
    And el usuario ingresa "123456" en el campo "Código del cliente"
    And el usuario ingresa "Juan Pérez moo" en el campo "Nombre del cliente"
    And el usuario ingresa "juan.perez@correo.com" en el campo "Email"
    And el usuario selecciona "Pasaporte" del campo "Tipo de Documento"
    And el usuario ingresa "9876543" en el campo "Nro CI_NIT"
    And el usuario selecciona "ESPECIALISTAS" del campo "Grupo de Clientes"
    When el usuario hace clic en el botón "REGISTRAR"
    Then el sistema debe mostrar que el codigo del cliente "Juan Pérez moo" fue registrado exitosamente

  Scenario: validacion de usuario ya registrado
    Given que el usuario está en la página "Registrar Cliente"
    And el usuario ingresa "123456" en el campo "Código del cliente"
    And el usuario ingresa "Juan Pérez moo" en el campo "Nombre del cliente"
    And el usuario ingresa "juan.perez@correo.com" en el campo "Email"
    And el usuario selecciona "Pasaporte" del campo "Tipo de Documento"
    And el usuario ingresa "9876543" en el campo "Nro CI_NIT"
    And el usuario selecciona "ESPECIALISTAS" del campo "Grupo de Clientes"
    When el usuario hace clic en el botón "REGISTRAR"
   Then el sistema muestra una notificacion de usuario ya registrado

  Scenario: validacion Debes completar el formulario
    Given que el usuario está en la página "Registrar Cliente"
    When el usuario hace clic en el botón "REGISTRAR"
    Then el sistema muestra una notificacion de debes completar el formulario

  Scenario: validacion Debes completar el formulario porque el nombre del cliente es invalido por que no tiene un nombre
    Given que el usuario está en la página "Registrar Cliente"
    And el usuario ingresa "12345" en el campo "Código del cliente"
    And el usuario ingresa "juan.perez@correo.com" en el campo "Email"
    When el usuario hace clic en el botón "REGISTRAR"
    Then el sistema muestra una notificacion de el nombre del cliente es invalido por que no tiene un nombre