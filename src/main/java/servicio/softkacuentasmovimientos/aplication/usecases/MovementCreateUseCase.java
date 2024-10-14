package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.ICreateMovement;
import servicio.softkacuentasmovimientos.domain.services.IMovimientoCommandService;

@Component
public class MovementCreateUseCase implements ICreateMovement {

    private final IMovimientoCommandService movementService;

    public MovementCreateUseCase(IMovimientoCommandService movementService) {
        this.movementService = movementService;
    }

    @Override
    public MovimientoDto create(MovimientoDto movimientoDto) {
        return movementService.registrarMovimiento(movimientoDto);
    }
}
