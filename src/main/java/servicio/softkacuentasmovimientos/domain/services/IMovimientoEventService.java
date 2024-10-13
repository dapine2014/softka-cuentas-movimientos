package servicio.softkacuentasmovimientos.domain.services;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;

import java.time.LocalDate;
import java.util.List;

public interface IMovimientoEventService {

    List<MovimientoDto> obtenerMovimientosPorFecha(CuentaDto cuenta, LocalDate inicio, LocalDate fin);
}
