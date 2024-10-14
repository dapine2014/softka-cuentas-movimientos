package servicio.softkacuentasmovimientos.aplication.ports.outbound;


import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;

import java.util.List;

public interface IReadClient {
    ClienteDto findById(Long id);
    List<ClienteDto> findAll();
}
