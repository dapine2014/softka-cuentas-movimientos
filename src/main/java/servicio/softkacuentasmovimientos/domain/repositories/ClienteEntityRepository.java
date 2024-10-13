package servicio.softkacuentasmovimientos.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio.softkacuentasmovimientos.domain.entities.Cliente;

import java.util.Optional;

@Repository
public interface ClienteEntityRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByClienteId(String clienteId);
}