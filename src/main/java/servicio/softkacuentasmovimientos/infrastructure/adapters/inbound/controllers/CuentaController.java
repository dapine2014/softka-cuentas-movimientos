package servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.ICuentaCreate;
import servicio.softkacuentasmovimientos.aplication.ports.inbound.IDeleteCuenta;
import servicio.softkacuentasmovimientos.aplication.ports.outbound.IReadCuenta;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final ICuentaCreate account;
    private final IDeleteCuenta deleteAccount;
    private final IReadCuenta readAccount;

    @Autowired
    public CuentaController(ICuentaCreate accountCreator, IDeleteCuenta accountDelete, IReadCuenta accountReader) {
        this.account = accountCreator;
        this.deleteAccount = accountDelete;
        this.readAccount = accountReader;
    }

    @PostMapping
    public ResponseEntity<Object> createAccount(@RequestBody CuentaDto accountDto) {
        try {
            CuentaDto createdAccount = account.create(accountDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } catch (IllegalArgumentException e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the account.");
        }
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Object> getAccountByNumber(@PathVariable String numero) {
        try {
            CuentaDto account = readAccount.accountPorNumero(numero);
            return ResponseEntity.status(HttpStatus.OK).body(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the account.");
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAccounts() {
        try {
            List<CuentaDto> accounts = readAccount.readCuenta();
            return ResponseEntity.status(HttpStatus.OK).body(accounts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the accounts.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        try {
            deleteAccount.deleteCuenta(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the account.");
        }
    }




}
