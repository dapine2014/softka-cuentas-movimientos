package servicio.softkacuentasmovimientos.aplication.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link servicio.softkacuentasmovimientos.domain.entities.Movimiento}
 */
@Value
public class MovimientoDto implements Serializable {
    Long id;
    LocalDate fecha;
    String tipoMovimiento;
    Double valor;
    Double saldo;
    CuentaDto cuenta;
}