package ar.edu.uade.ai_tpo_2c.modelos;

import ar.edu.uade.ai_tpo_2c.views.PersonaSinRolView;
import ar.edu.uade.ai_tpo_2c.views.PersonaView;

import lombok.*;

import javax.persistence.*;


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

	private String mail;

	@Column(name="contrasenia")
	private String contrasenia;

	
	public Persona(String nombre, String email, String contrasenia) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail=email;
		this.contrasenia=contrasenia;

	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre, mail);
	}

	public PersonaSinRolView toViewSinRol() {
		return new PersonaSinRolView(documento, nombre, mail);
	}
}
