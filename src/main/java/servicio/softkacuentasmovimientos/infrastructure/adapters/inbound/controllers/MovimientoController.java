package servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MovimientoDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.ICreateMovement;
import servicio.softkacuentasmovimientos.aplication.ports.outbound.IReadCuenta;
import servicio.softkacuentasmovimientos.aplication.ports.outbound.IReadMovement;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final ICreateMovement createMovement;
    private final IReadMovement readMovement;
    private final IReadCuenta readAccount;

    public MovimientoController(ICreateMovement createMovement, IReadMovement readMovement, IReadCuenta readAccount) {
        this.createMovement = createMovement;
        this.readMovement = readMovement;
        this.readAccount = readAccount;
    }


    @PostMapping
    public ResponseEntity<Object> createMovement(@RequestBody MovimientoDto movimientoDto) {
        MovimientoDto createdMovement = createMovement.create(movimientoDto);
        return ResponseEntity.ok(createdMovement);
    }

   @GetMapping("/reporte")
   public ResponseEntity<Object> getMovimientoReport(@RequestParam String numeroCuenta, @RequestParam String inicio, @RequestParam String fin) {
       CuentaDto cuenta = readAccount.accountPorNumero(numeroCuenta);
       List<MovimientoDto> movimientos = readMovement.movementForDate(cuenta, LocalDate.parse(inicio), LocalDate.parse(fin));
       return new ResponseEntity<>(movimientos, HttpStatus.OK);
   }
}
