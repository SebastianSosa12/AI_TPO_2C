package ar.edu.uade.ai_tpo_2c.modelo;

import ar.edu.uade.ai_tpo_2c.views.ImagenView;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="imagenes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@Column(name = "path")
	private String direccion;
	private String tipo;

	public Imagen(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public ImagenView toView() {
		return new ImagenView(numero, direccion ,tipo);
	}

}
