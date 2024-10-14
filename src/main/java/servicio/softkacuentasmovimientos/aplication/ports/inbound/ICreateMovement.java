package servicio.softkacuentasmovimientos.aplication.ports.inbound;

import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;

public interface ICreateMovement {

    MovimientoDto create(MovimientoDto movimientoDto);
}
