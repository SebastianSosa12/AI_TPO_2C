package ar.edu.uade.ai_tpo_2c.exceptions;

import java.io.Serial;

public class UnidadException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1690698840733203643L;

    public UnidadException(String mensaje) {
        super(mensaje);
    }
}

