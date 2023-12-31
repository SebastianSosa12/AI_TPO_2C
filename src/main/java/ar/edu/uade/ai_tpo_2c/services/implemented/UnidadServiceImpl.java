package ar.edu.uade.ai_tpo_2c.services.implemented;

import ar.edu.uade.ai_tpo_2c.modelos.Unidad;
import ar.edu.uade.ai_tpo_2c.repositorios.UnidadRepositorio;
import ar.edu.uade.ai_tpo_2c.services.interfaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadServiceImpl implements IUnidadService {

	@Autowired
	private UnidadRepositorio repositorio;
	@Override
	public List<Unidad> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Page<Unidad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<Unidad>) repositorio.findAll((Sort) pageable);
	}

	@Override
	public Optional<Unidad> findById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Unidad save(Unidad unidad) {
		// TODO Auto-generated method stub
		return repositorio.save(unidad);
	}

	@Override
	public Unidad update(Unidad unidadActualizada, int id) {
		Unidad unidadPorActualizar= repositorio.findById(id).orElse(null);

		unidadPorActualizar.setHabitado(unidadActualizada.estaHabitado());
		unidadPorActualizar.setNumero(unidadActualizada.getNumero());
		return repositorio.save(unidadPorActualizar);
	}

	@Override
	public void deleteById(Integer id) {
		repositorio.deleteById(id);

	}

}
