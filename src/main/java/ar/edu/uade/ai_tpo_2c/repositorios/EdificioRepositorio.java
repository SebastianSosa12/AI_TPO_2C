package ar.edu.uade.ai_tpo_2c.repositorios;

import ar.edu.uade.ai_tpo_2c.modelos.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepositorio extends JpaRepository<Edificio,Integer>{

}
