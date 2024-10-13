package servicio.softkacuentasmovimientos.domain.services;


import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;

public interface IClientCommandService {
    ClienteDto crearCliente(ClienteDto cliente);
    ClienteDto actualizarCliente(Long id, ClienteDto clienteDto);
    public void eliminarCliente(Long id);

}
