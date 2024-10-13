package servicio.softkacuentasmovimientos.domain.services;

import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import java.util.List;

public interface ICuentaEventService {
     CuentaDto obtenerCuentaPorNumero(String numeroCuenta);
     List<CuentaDto> obtenerTodasLasCuentas();
}
