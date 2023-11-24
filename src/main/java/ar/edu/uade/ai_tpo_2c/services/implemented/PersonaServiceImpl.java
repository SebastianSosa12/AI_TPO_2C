package ar.edu.uade.ai_tpo_2c.services.implemented;

import ar.edu.uade.ai_tpo_2c.modelo.Persona;
import ar.edu.uade.ai_tpo_2c.repositorios.PersonaRepositorio;
import ar.edu.uade.ai_tpo_2c.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {

	
	@Autowired
	private PersonaRepositorio repositorio;
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<Persona>) repositorio.findAll((Sort) pageable);
	}

	@Override
	public Optional<Persona> findById(String documento) {
		// TODO Auto-generated method stub
		return repositorio.findById(documento);
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return repositorio.save(persona);
	}

	@Override
	public Persona update(Persona personaActualizada, String documento) {
		Persona personaPorActualizar= repositorio.getReferenceById(documento);
		personaPorActualizar.setNombre(personaActualizada.getNombre());
		personaPorActualizar.setEmail(personaActualizada.getEmail());
		personaPorActualizar.setPassword(personaActualizada.getPassword());
		return repositorio.save(personaPorActualizar);
	}

	@Override
	public void deleteById(String documento) {
		repositorio.deleteById(documento);

	}

}
