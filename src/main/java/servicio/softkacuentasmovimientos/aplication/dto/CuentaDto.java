package servicio.softkacuentasmovimientos.aplication.dto;

import lombok.Data;


import java.io.Serializable;

/**
 * DTO for {@link servicio.softkacuentasmovimientos.domain.entities.Cuenta}
 */
@Data
public class CuentaDto implements Serializable {
    Long id;
    String numeroCuenta;
    String tipoCuenta;
    Double saldoInicial;
    Boolean estado;
    ClienteDto cliente;
}