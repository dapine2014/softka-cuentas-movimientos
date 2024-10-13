package servicio.softkacuentasmovimientos.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente extends Persona {

    @Column(unique = true)
    private String clienteId;
    private String contrasena;
    private Boolean estado;
}
