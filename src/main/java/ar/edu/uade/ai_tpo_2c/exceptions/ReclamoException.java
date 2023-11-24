package ar.edu.uade.ai_tpo_2c.exceptions;

import java.io.Serial;

public class ReclamoException extends Exception {

    @Serial
    private static final long serialVersionUID = 6646850323041998390L;

    public ReclamoException(String mensaje) {
        super(mensaje);
    }
}
