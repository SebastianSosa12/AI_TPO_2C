package ar.edu.uade.ai_tpo_2c.modelos;

import ar.edu.uade.ai_tpo_2c.views.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="reclamos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReclamo")
	private int numero;
	
	@ManyToOne
	@JoinColumn(name="documento")
	private Persona usuario;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private Edificio edificio;
	private String ubicacion;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="identificador")
	private Unidad unidad;

	@Enumerated(EnumType.ORDINAL)
	private Estado estado;
	
	@OneToMany
	@JoinColumn(name="idReclamo")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Imagen> imagenes;

	public Reclamo(Persona usuario, Edificio edificio, String ubicacion, String descripcion, Unidad unidad) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.estado = Estado.NUEVO;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
	}

	
	public ReclamoView toView() {
		PersonaSinRolView auxPersona = usuario.toViewSinRol();
		EdificioView auxEdificio = edificio.toView();
		UnidadView auxUnidad = unidad.toView();
		List<ImagenView> auxImagen = new ArrayList<ImagenView>();
		for(Imagen img : imagenes) {
			auxImagen.add(img.toView());
		}
		return new ReclamoView(numero, auxPersona, auxEdificio, ubicacion, descripcion, auxUnidad, estado, auxImagen);
	}
}
