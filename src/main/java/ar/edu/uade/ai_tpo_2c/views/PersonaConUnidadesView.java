package ar.edu.uade.ai_tpo_2c.views;

import ar.edu.uade.ai_tpo_2c.modelos.Persona;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaConUnidadesView {

    private String documento;
    private String nombre;
    private String mail;

    List<UnidadView> duenioDe;
    List<UnidadView> inquilinoDe;

    public PersonaConUnidadesView(Persona persona, List<UnidadView> duenioDe, List<UnidadView> inquilinoDe){
        documento= persona.getDocumento();
        nombre= persona.getNombre();
        mail= persona.getMail();
        this.duenioDe=duenioDe;
        this.inquilinoDe=inquilinoDe;
    }
}
