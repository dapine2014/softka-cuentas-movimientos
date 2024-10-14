package servicio.softkacuentasmovimientos.aplication.dto;

import lombok.Data;



import java.io.Serializable;


@Data
public class PersonaEntityDto implements Serializable {
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}