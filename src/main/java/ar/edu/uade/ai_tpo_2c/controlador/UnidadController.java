package ar.edu.uade.ai_tpo_2c.controlador;

import ar.edu.uade.ai_tpo_2c.exceptions.PersonaException;
import ar.edu.uade.ai_tpo_2c.exceptions.UnidadException;
import ar.edu.uade.ai_tpo_2c.modelos.Unidad;
import ar.edu.uade.ai_tpo_2c.modelos.UnidadPersona;
import ar.edu.uade.ai_tpo_2c.views.UnidadSinEdificioView;
import ar.edu.uade.ai_tpo_2c.views.UnidadView;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/unidad")
public class UnidadController {
    private final Controlador controlador;

    @Autowired
    public UnidadController(Controlador controlador){
        this.controlador=controlador;
    }


    @GetMapping("/edificio")
    public ResponseEntity<List<UnidadSinEdificioView>> obtenerUnidadesSinEdificios(@PathParam("codigo") int codigo){
        return ResponseEntity.ok(controlador.getUnidadesPorEdificio(codigo));
    }

    @GetMapping()
    public ResponseEntity<List<UnidadView>> obtenerUnidadesConEdificios(){
        return ResponseEntity.ok(controlador.obtenerUnidadesConEdificios());
    }

    @PostMapping()
    public ResponseEntity<?> guardarUnidad(@RequestBody Unidad unidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.agregarUnidad(unidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUnidadPorId(@PathVariable Integer id) throws UnidadException {
        return ResponseEntity.ok(controlador.buscarUnidadPorCodigo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUnidadPorId(@RequestBody Unidad unidad, @PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.actualizarUnidad(unidad,id));
    }

    @PostMapping("/agregar-duenio")
    public ResponseEntity<?> agregarDuenio(@RequestBody UnidadPersona unidadPersona) throws PersonaException, UnidadException {
        controlador.agregarDuenioUnidad(unidadPersona);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/agregar-inquilino")
    public ResponseEntity<?> agregarInquilino(@RequestBody UnidadPersona unidadPersona) throws PersonaException, UnidadException {
        controlador.agregarInquilinoUnidad(unidadPersona);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/liberar-unidad/{id}")
    public ResponseEntity<?> liberarUnidad(@PathVariable int id) throws UnidadException {
        controlador.liberarUnidad(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/habitar-unidad/{id}")
    public ResponseEntity<?> habitarUnidad(@PathVariable int id) throws UnidadException {
        controlador.habitarUnidad(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/duenios/{id}")
    public ResponseEntity<?> obtenerDuenios(@PathVariable int id) throws UnidadException {
        return ResponseEntity.ok(controlador.dueniosPorUnidad(id));
    }

    @GetMapping("/inquilinos/{id}")
    public ResponseEntity<?> obtenerInquilinos(@PathVariable int id) throws UnidadException {
        return ResponseEntity.ok(controlador.inquilinosPorUnidad(id));
    }

    @PutMapping("/transferir-unidad")
    public ResponseEntity<?> transferirUnidad(@RequestBody UnidadPersona unidadPersona) throws UnidadException, PersonaException {
        controlador.transferirUnidad(unidadPersona);
        return ResponseEntity.ok().build();
    }
}
