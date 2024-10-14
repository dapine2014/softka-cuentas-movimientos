package servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import servicio.softkacuentasmovimientos.aplication.dto.MessageResponceDto;
import servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.service.KafkaMessageObserver;


@Slf4j
@Component
public class KafkaMessageReception implements KafkaMessageObserver {

    @Override
    public void onMessageReceived(MessageResponceDto message) {

    }
}
