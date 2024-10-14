package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.IDeleteClient;
import servicio.softkacuentasmovimientos.domain.services.IClientCommandService;


@Component
public class ClientDeleteUseCase implements IDeleteClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientDeleteUseCase(IClientCommandService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void deletePersona(Long id) {
     clientService.eliminarCliente(id);
    }
}
