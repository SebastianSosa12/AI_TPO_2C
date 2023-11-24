package ar.edu.uade.ai_tpo_2c.modelo;

import ar.edu.uade.ai_tpo_2c.views.PersonaSinRolView;
import ar.edu.uade.ai_tpo_2c.views.PersonaView;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="personas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona {

	@Id
	private String documento;
	private String nombre;

	private String email;

	@Column(name="pass")
	private String password;

	@Enumerated(EnumType.ORDINAL)
	private Rol rol;
	
	public Persona(String nombre, String email, String password,Rol rol) {
		this.documento = documento;
		this.nombre = nombre;
		this.email=email;
		this.password=password;
		this.rol=rol;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre,email, rol);
	}

	public PersonaSinRolView toViewSinRol() {
		return new PersonaSinRolView(documento,nombre,email);
	}
}
