package ar.edu.uade.ai_tpo_2c.services.interfaces;

import ar.edu.uade.ai_tpo_2c.modelo.Persona;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
	
	List<Persona> findAll();
	
	Page<Persona> findAll(Pageable pageable);
	
	Optional<Persona> findById(String documento);
	
	Persona save(Persona persona);

	Persona update(Persona persona, String documento);
	
	void deleteById(String documento);

}
