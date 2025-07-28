package page;

import lombok.Data;

@Data
public class RegisterUserPage extends Common {

    private final String baseURLCliente = "http://localhost:3000/customers/register";
//    private final String baseURLCliente = "http://localhost:3000/customers";
    private String codClienteId = "#_r_0_";
    private String nombreDelClienteId = "#_r_1_";
    private String emailId = "#_r_2_";
    private String documentoDeIdentidadIdCombox = "(//div[@role='combobox'])[1]";
    private String grupoDeClienteidCombox = "(//div[@role='combobox'])[2]";
    private String numeroPasaporteId = "#_r_4_";
    private String buttonRegistrar = "//button[@type='submit']";
    
}
