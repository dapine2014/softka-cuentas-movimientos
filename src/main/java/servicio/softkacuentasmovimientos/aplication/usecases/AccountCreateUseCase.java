package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.ICuentaCreate;
import servicio.softkacuentasmovimientos.domain.services.ICuentaCommandService;

@Component
public class AccountCreateUseCase implements ICuentaCreate{

    private final ICuentaCommandService accountService;

    public AccountCreateUseCase(ICuentaCommandService accountCommandService) {
        this.accountService = accountCommandService;
    }

    @Override
    public CuentaDto create(CuentaDto cuentaDto) {
        return accountService.crearCuenta(cuentaDto);
    }
}