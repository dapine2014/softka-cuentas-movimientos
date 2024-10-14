package servicio.softkacuentasmovimientos.infrastructure.adapters.outbound.listener;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.softkacuentasmovimientos.aplication.dto.ClienteDto;
import servicio.softkacuentasmovimientos.aplication.dto.CuentaDto;
import servicio.softkacuentasmovimientos.aplication.dto.MessageResponceDto;
import servicio.softkacuentasmovimientos.aplication.dto.TopicDto;
import servicio.softkacuentasmovimientos.domain.entities.Cliente;
import servicio.softkacuentasmovimientos.domain.repositories.ClienteEntityRepository;
import servicio.softkacuentasmovimientos.domain.services.ICuentaCommandService;
import servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.service.KafkaMessageObserver;


import java.util.List;
import java.util.Optional;

import static servicio.softkacuentasmovimientos.utils.JsonUtil.fromJson;

@Slf4j
@Service
public class MessageHandler {

    private final List<KafkaMessageObserver> observers ;
    private final ClienteEntityRepository repository;
    private final ICuentaCommandService accountService;
    private final ModelMapper mapper;

    @Autowired
    public MessageHandler(List<KafkaMessageObserver> observers, ClienteEntityRepository repository, ICuentaCommandService accountService) {
        this.observers = observers;
        this.repository = repository;
        this.accountService = accountService;
        this.mapper = new ModelMapper();
    }

    public void addObserver(KafkaMessageObserver observer) {
        this.observers.add(observer);
    }

    public void notify(String message) {
        for (KafkaMessageObserver observer : observers) {
            MessageResponceDto messageDto = fromJson(message, MessageResponceDto.class);
            observer.onMessageReceived(messageDto);
        }
    }

    public void processMessage(String message) {
        logReceivedMessage(message);
        TopicDto topicPojo = fromJson(message, TopicDto.class);
        if (topicPojo.getUuIdTo() == null) {
            createAndSendResponseMessage(topicPojo);
        } else {
            notify(message);
        }

    }

    public void logReceivedMessage(String message){
        log.info("Message received: {}", message);
    }

    private void createAndSendResponseMessage(TopicDto data){
       Optional<Cliente> cliente = repository.findByClienteId(data.getQuery().get(0).getMethod());
        if(cliente.isPresent()){

            //cliente.get()
             ClienteDto clienteDto = ClienteDto.builder()
                     .id(cliente.get().getId())
                     .nombre(cliente.get().getNombre())
                     .genero(cliente.get().getGenero())
                     .edad(cliente.get().getEdad())
                     .identificacion(cliente.get().getIdentificacion())
                     .direccion(cliente.get().getDireccion())
                     .telefono(cliente.get().getTelefono())
                     .clienteId(cliente.get().getClienteId())
                     .contrasena(cliente.get().getContrasena())
                     .estado(cliente.get().getEstado()).build();


            CuentaDto cuentaDto = CuentaDto.builder()
                    .numeroCuenta("0000000"+cliente.get().getId())
                    .tipoCuenta("ahorros")
                    .saldoInicial(200.0)
                    .estado(true)
                    .cliente(clienteDto)
                    .build();

            accountService.crearCuenta(cuentaDto);
            log.info("Cliente encontrado: {}", clienteDto);
        }




        log.info("MENSAJE DE KAFKA : {}", data.toString());
    }
}
