package servicio.softkacuentasmovimientos.aplication.ports.outbound;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;

import java.time.LocalDate;
import java.util.List;

public interface IReadMovement {
    List<MovimientoDto> movementForDate(CuentaDto cuenta, LocalDate inicio, LocalDate fin);
}
