package ar.edu.uade.ai_tpo_2c.exceptions;

import java.io.Serial;

public class ImagenException extends Exception {

    @Serial
    private static final long serialVersionUID = 6332415080946078382L;

    public ImagenException(String mensaje) {
        super(mensaje);
    }
}
