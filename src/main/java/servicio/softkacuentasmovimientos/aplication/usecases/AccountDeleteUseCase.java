package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.IDeleteCuenta;
import servicio.softkacuentasmovimientos.domain.services.ICuentaCommandService;

@Component
public class AccountDeleteUseCase implements IDeleteCuenta {

    private final ICuentaCommandService commandService;

    public AccountDeleteUseCase(ICuentaCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public void deleteCuenta(Long id) {
        commandService.eliminarCuenta(id);
    }
}
