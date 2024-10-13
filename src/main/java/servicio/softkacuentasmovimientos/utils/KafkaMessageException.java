package servicio.softkacuentasmovimientos.utils;

public class KafkaMessageException extends RuntimeException {
    public KafkaMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
