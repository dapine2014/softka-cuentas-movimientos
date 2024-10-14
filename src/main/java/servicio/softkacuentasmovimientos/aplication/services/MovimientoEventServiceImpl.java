package servicio.softkacuentasmovimientos.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;
import servicio.softkacuentasmovimientos.domain.repositories.MovimientoRepository;
import servicio.softkacuentasmovimientos.domain.services.IMovimientoEventService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoEventServiceImpl implements IMovimientoEventService {

    private final MovimientoRepository movimientoRepository;
    private final ModelMapper mapper;

    @Autowired
    public MovimientoEventServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<MovimientoDto> obtenerMovimientosPorFecha(CuentaDto cuenta, LocalDate inicio, LocalDate fin) {
        return List.of();
    }
}
