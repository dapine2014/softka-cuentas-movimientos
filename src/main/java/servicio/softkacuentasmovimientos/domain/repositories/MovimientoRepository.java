package servicio.softkacuentasmovimientos.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio.softkacuentasmovimientos.domain.entities.Cuenta;
import servicio.softkacuentasmovimientos.domain.entities.Movimiento;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaAndFechaBetween(Cuenta cuenta, LocalDate inicio, LocalDate fin);
}