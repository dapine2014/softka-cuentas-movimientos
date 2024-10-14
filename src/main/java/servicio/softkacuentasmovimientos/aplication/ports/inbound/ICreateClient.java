package servicio.softkacuentasmovimientos.aplication.ports.inbound;


import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;

public interface ICreateClient {
    ClienteDto create(ClienteDto clients);
}
