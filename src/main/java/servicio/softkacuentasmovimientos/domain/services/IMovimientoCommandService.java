package servicio.softkacuentasmovimientos.domain.services;

import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;

public interface IMovimientoCommandService {

    MovimientoDto registrarMovimiento(MovimientoDto movimiento);
}
