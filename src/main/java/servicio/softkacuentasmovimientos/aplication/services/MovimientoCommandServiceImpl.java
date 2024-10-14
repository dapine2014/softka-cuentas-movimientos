package servicio.softkacuentasmovimientos.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;
import servicio.softkacuentasmovimientos.domain.entities.Movimiento;
import servicio.softkacuentasmovimientos.domain.repositories.MovimientoRepository;
import servicio.softkacuentasmovimientos.domain.services.IMovimientoCommandService;

@Service
public class MovimientoCommandServiceImpl implements IMovimientoCommandService {

    private final MovimientoRepository movimientoRepository;
    private final ModelMapper mapper;

    @Autowired
    public MovimientoCommandServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public MovimientoDto registrarMovimiento(MovimientoDto movimientoDto) {

        if (movimientoDto.getCuenta().getSaldoInicial() + movimientoDto.getValor() < 0) {
            throw new RuntimeException("Saldo no disponible");
        }
        movimientoDto.getCuenta().setSaldoInicial(movimientoDto.getCuenta().getSaldoInicial() + movimientoDto.getValor());
        Movimiento movimiento = movimientoRepository.save( mapper.map(movimientoDto, Movimiento.class));

        return mapper.map(movimiento, MovimientoDto.class);
    }
}
