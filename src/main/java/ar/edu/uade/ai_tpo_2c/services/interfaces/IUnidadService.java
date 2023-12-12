package ar.edu.uade.ai_tpo_2c.services.interfaces;

import ar.edu.uade.ai_tpo_2c.modelos.Unidad;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IUnidadService {
	
	List<Unidad> findAll();
	
	Page<Unidad> findAll(Pageable pageable);
	
	Optional<Unidad> findById(Integer id);
	
	Unidad save(Unidad unidad);

	Unidad update(Unidad unidad, int id);
	
	void deleteById(Integer id);

}
