package servicio.softkacuentasmovimientos.infrastructure.adapters.inbound.service;

import servicio.sofkaclientepersona.aplication.dto.MessageResponceDto;

public interface KafkaMessageObserver {
    void onMessageReceived(MessageResponceDto message);
}
