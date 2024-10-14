package servicio.softkacuentasmovimientos.aplication.ports.inbound;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;

public interface ICuentaCreate {
    CuentaDto create(CuentaDto cuentaDto);
}
