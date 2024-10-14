package servicio.softkacuentasmovimientos.aplication.ports.inbound;


import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;

public interface IUpdateClient {
    ClienteDto update(Long id, ClienteDto clienteDto);
}
