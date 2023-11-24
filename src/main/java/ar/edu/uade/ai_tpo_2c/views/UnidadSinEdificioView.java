package ar.edu.uade.ai_tpo_2c.views;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UnidadSinEdificioView {

    private int id;
    private String piso;
    private String numero;
    private boolean habitado;
}
