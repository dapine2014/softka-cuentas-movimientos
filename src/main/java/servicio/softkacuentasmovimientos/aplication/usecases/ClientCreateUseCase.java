package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.ICreateClient;
import servicio.softkacuentasmovimientos.domain.services.IClientCommandService;


@Component
public class ClientCreateUseCase implements ICreateClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientCreateUseCase(IClientCommandService clientCommandService) {
        this.clientService = clientCommandService;
    }

    @Override
    public ClienteDto create(ClienteDto clients) {
        return clientService.crearCliente(clients);
    }
}
