package servicio.softkacuentasmovimientos.aplication.usecases;

import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;
import servicio.softkacuentasmovimientos.aplication.ports.outbound.IReadMovement;
import servicio.softkacuentasmovimientos.domain.services.IMovimientoEventService;
import java.time.LocalDate;
import java.util.List;

@Component
public class MovementListUseCase implements IReadMovement {

    private final IMovimientoEventService movementService;

    public MovementListUseCase(IMovimientoEventService movementService) {
        this.movementService = movementService;
    }

    @Override
    public List<MovimientoDto> movementForDate(CuentaDto cuenta, LocalDate inicio, LocalDate fin) {
        return movementService.obtenerMovimientosPorFecha(cuenta, inicio, fin);
    }
}
