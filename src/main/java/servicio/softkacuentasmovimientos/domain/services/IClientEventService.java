package servicio.softkacuentasmovimientos.domain.services;



import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;

import java.util.List;

public interface IClientEventService {
    List<ClienteDto> obtenerTodosLosClientes();
    ClienteDto obtenerClientePorId(Long id);
}
