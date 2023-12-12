package ar.edu.uade.ai_tpo_2c.services.interfaces;

import ar.edu.uade.ai_tpo_2c.modelos.Imagen;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IImagenService {
	
	List<Imagen> findAll();
	
	Page<Imagen> findAll(Pageable pageable);
	
	Optional<Imagen> findById(Integer id);
	
	Imagen save(Imagen imagen);

	Imagen update(Imagen imagen, int id);
	
	void deleteById(Integer id);

}
