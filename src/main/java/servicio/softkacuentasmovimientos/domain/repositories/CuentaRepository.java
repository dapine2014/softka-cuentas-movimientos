package servicio.softkacuentasmovimientos.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio.softkacuentasmovimientos.domain.entities.Cuenta;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
  Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
}