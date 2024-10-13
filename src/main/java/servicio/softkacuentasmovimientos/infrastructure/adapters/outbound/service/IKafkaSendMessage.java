package servicio.softkacuentasmovimientos.infrastructure.adapters.outbound.service;

public interface IKafkaSendMessage {
    String sendMessage(String topic, String key, String obj);
}
