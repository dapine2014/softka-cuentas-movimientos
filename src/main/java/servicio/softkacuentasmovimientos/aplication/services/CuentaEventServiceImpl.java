package servicio.softkacuentasmovimientos.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.domain.entities.Cuenta;
import servicio.softkacuentasmovimientos.domain.repositories.CuentaRepository;
import servicio.softkacuentasmovimientos.domain.services.ICuentaEventService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaEventServiceImpl implements ICuentaEventService {

    private final CuentaRepository cuentaRepository;
    private final ModelMapper mapper;

    public CuentaEventServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.mapper = new ModelMapper();;
    }

    @Override
    public CuentaDto obtenerCuentaPorNumero(String numeroCuenta) {
        Optional<Cuenta> cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        return cuenta.map(value -> mapper.map(value, CuentaDto.class)).orElse(null);
    }

    @Override
    public List<CuentaDto> obtenerTodasLasCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas.stream()
                .map(cuenta -> mapper.map(cuenta, CuentaDto.class))
                .collect(Collectors.toList());
    }
}
