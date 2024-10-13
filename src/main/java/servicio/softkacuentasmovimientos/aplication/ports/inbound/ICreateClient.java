package servicio.softkacuentasmovimientos.aplication.ports.inbound;

import servicio.sofkaclientepersona.aplication.dto.ClienteDto;

public interface ICreateClient {
    ClienteDto create(ClienteDto clients);
}
