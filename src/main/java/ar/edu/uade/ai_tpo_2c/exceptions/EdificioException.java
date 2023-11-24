package ar.edu.uade.ai_tpo_2c.exceptions;

import java.io.Serial;

public class EdificioException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 9018648492209155948L;

    public EdificioException(String mensaje) {
        super(mensaje);
    }
}
