package servicio.softkacuentasmovimientos.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio.softkacuentasmovimientos.domain.entities.Persona;

@Repository
public interface PersonaEntityRepository extends JpaRepository<Persona, Long> {
}