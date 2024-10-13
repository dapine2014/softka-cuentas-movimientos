package servicio.softkacuentasmovimientos.domain.services;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;

public interface ICuentaCommandService {
    CuentaDto crearCuenta(CuentaDto cuenta);
    void eliminarCuenta(CuentaDto cuenta);
}
