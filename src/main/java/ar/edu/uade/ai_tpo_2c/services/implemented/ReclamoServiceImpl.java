package ar.edu.uade.ai_tpo_2c.services.implemented;

import ar.edu.uade.ai_tpo_2c.modelos.Reclamo;
import ar.edu.uade.ai_tpo_2c.repositorios.ReclamoRepositorio;
import ar.edu.uade.ai_tpo_2c.services.interfaces.IReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamoServiceImpl implements IReclamoService {

	@Autowired
	private ReclamoRepositorio repositorio;
	@Override
	public List<Reclamo> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Page<Reclamo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<Reclamo>) repositorio.findAll((Sort) pageable);
	}

	@Override
	public Optional<Reclamo> findById(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Reclamo save(Reclamo reclamo) {
		// TODO Auto-generated method stub
		return repositorio.save(reclamo);
	}

	@Override
	public Reclamo update(Reclamo reclamoActualizado, int id) {
		Reclamo reclamoPorActualizar= repositorio.getById(id);

		reclamoPorActualizar.setDescripcion(reclamoActualizado.getDescripcion());
		reclamoPorActualizar.setImagenes(reclamoActualizado.getImagenes());

		return repositorio.save(reclamoPorActualizar);
	}

	@Override
	public void deleteById(Integer id) {
		repositorio.deleteById(id);

	}

}
