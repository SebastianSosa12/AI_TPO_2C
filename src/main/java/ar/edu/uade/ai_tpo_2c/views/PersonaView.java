package ar.edu.uade.ai_tpo_2c.views;

import ar.edu.uade.ai_tpo_2c.modelo.Rol;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaView {
	
	private String documento;
	private String nombre;
	private String email;
	private Rol rol;

}
