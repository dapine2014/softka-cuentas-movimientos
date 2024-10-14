package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.ports.outbound.IReadCuenta;
import servicio.softkacuentasmovimientos.domain.services.ICuentaEventService;

import java.util.List;

@Component
public class AccountListUseCase implements IReadCuenta {

    private final ICuentaEventService accountService;

    public AccountListUseCase(ICuentaEventService accountService) {
        this.accountService = accountService;
    }


    @Override
    public List<CuentaDto> readCuenta() {
        return accountService.obtenerTodasLasCuentas();
    }

    @Override
    public CuentaDto accountPorNumero(String accountNumber) {
        return accountService.obtenerCuentaPorNumero(accountNumber);
    }

}
