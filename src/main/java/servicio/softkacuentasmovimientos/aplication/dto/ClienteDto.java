package servicio.softkacuentasmovimientos.aplication.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * DTO for {@link }
 */
@Data
public class ClienteDto implements Serializable {
    private   Long id;
    private   String nombre;
    private   String genero;
    private   Integer edad;
    private   String identificacion;
    private   String direccion;
    private   String telefono;
    private   String clienteId;
    private   String contrasena;
    private   Boolean estado;
}