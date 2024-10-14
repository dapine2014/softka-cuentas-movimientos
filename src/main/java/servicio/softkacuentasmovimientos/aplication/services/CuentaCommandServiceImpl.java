package servicio.softkacuentasmovimientos.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.domain.entities.Cuenta;
import servicio.softkacuentasmovimientos.domain.repositories.CuentaRepository;
import servicio.softkacuentasmovimientos.domain.services.ICuentaCommandService;

@Service
public class CuentaCommandServiceImpl implements ICuentaCommandService {


    private final CuentaRepository cuentaRepository;
    private final ModelMapper mapper;

    @Autowired
    public CuentaCommandServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public CuentaDto crearCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = cuentaRepository.save(mapper.map(cuentaDto, Cuenta.class));
        cuentaDto.setId(cuenta.getId());

        return cuentaDto;
    }

    @Override
    public void eliminarCuenta(CuentaDto cuenta) {
        cuentaRepository.delete(mapper.map(cuenta, Cuenta.class));
    }
}
