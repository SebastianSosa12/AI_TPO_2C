package ar.edu.uade.ai_tpo_2c.services.implemented;

import ar.edu.uade.ai_tpo_2c.modelos.Edificio;
import ar.edu.uade.ai_tpo_2c.repositorios.EdificioRepositorio;
import ar.edu.uade.ai_tpo_2c.services.interfaces.IEdificioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EdificioServiceImpl implements IEdificioService {

	

	private final EdificioRepositorio repositorio;

	@Autowired
	public EdificioServiceImpl(EdificioRepositorio repositorio){
		this.repositorio=repositorio;
	}
	@Override
	public List<Edificio> findAll() {
		return repositorio.findAll();
	}

	
	@Override
	public Page<Edificio> findAll(Pageable pageable) {
		return (Page<Edificio>) repositorio.findAll((Sort) pageable);
	}

	@Override
	public Optional<Edificio> findById(Integer id) {
		return repositorio.findById(id);
	}

	@Override
	public Edificio save(Edificio edificio) {
		return repositorio.save(edificio);
	}

	@Override
	public void deleteById(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public Edificio update(Edificio edificioActualizado, int codigo){
		Edificio edificioPorActualizar= repositorio.findById(codigo).orElse(null);
		edificioPorActualizar.setDireccion(edificioActualizado.getDireccion());
		edificioPorActualizar.setNombre(edificioActualizado.getNombre());
		edificioPorActualizar.setUnidades(edificioActualizado.getUnidades());

		log.info(edificioPorActualizar.toString());
		log.info(edificioActualizado.toString());
		return  repositorio.save(edificioPorActualizar);

	}

}
