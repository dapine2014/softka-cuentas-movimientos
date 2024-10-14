package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.IUpdateClient;
import servicio.softkacuentasmovimientos.domain.services.IClientCommandService;


@Component
public class ClientUpdateUsecase implements IUpdateClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientUpdateUsecase(IClientCommandService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClienteDto update(Long id, ClienteDto clienteDto) {
        return clientService.actualizarCliente(id, clienteDto);
    }
}
