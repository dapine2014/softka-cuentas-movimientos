package servicio.softkacuentasmovimientos.aplication.ports.outbound;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;


import java.util.List;

public interface IReadCuenta {
    List<CuentaDto> readCuenta();
    CuentaDto accountPorNumero(String numero);
}
