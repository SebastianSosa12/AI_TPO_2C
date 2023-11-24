package ar.edu.uade.ai_tpo_2c.exceptions;

import java.io.Serial;

public class PersonaException extends Exception {

    @Serial
    private static final long serialVersionUID = -2835873129858130160L;

    public PersonaException(String mensaje) {
        super(mensaje);
    }
}
