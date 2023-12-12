package ar.edu.uade.ai_tpo_2c.controlador;

import ar.edu.uade.ai_tpo_2c.exceptions.PersonaException;
import ar.edu.uade.ai_tpo_2c.modelos.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private final Controlador controlador;

    @Autowired
    public PersonaController(Controlador controlador){
        this.controlador=controlador;
    }

    @PostMapping()
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.agregarPersona(persona));
    }
    @GetMapping()
    public ResponseEntity<?> getPersonas(){
        return ResponseEntity.status(HttpStatus.OK).body(controlador.getPersonas());
    }
    @GetMapping("/DNI/{documento}")
    public ResponseEntity<?> obtenerPersonaPorDni(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.buscarPersona("DNI".concat(documento)));
    }

    @GetMapping("/CI/{documento}")
    public ResponseEntity<?> obtenerPersonaPorCi(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.buscarPersona("CI ".concat(documento)));
    }

    @GetMapping("/CPA/{documento}")
    public ResponseEntity<?> obtenerPersonaPorCpa(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.buscarPersona("CPA".concat(documento)));
    }

    @GetMapping("/unidades/DNI/{documento}")
    public ResponseEntity<?> obtenerUnidadesPorDni(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.obtenerPersonaConUnidades("DNI".concat(documento)));
    }

    @GetMapping("/unidades/CI/{documento}")
    public ResponseEntity<?> obtenerUnidadesPorCi(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.obtenerPersonaConUnidades("CI ".concat(documento)));
    }

    @GetMapping("/unidades/CPA/{documento}")
    public ResponseEntity<?> obtenerUnidadesPorCpa(@PathVariable String documento) throws PersonaException {
        return ResponseEntity.ok(controlador.obtenerPersonaConUnidades("CPA".concat(documento)));
    }

    @PutMapping("/DNI/{documento}")
    public ResponseEntity<?> updatePersonaPorDni(@RequestBody Persona persona, @PathVariable(value = "documento") String documento){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.actualizarPersona(persona, "DNI".concat(documento)));
    }

    @PutMapping("/CI/{documento}")
    public ResponseEntity<?> updatePersonaPorCi(@RequestBody Persona persona, @PathVariable(value = "documento") String documento){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.actualizarPersona(persona, "CI ".concat(documento)));
    }

    @PutMapping("/CPA/{documento}")
    public ResponseEntity<?> updatePersonaPorCpa(@RequestBody Persona persona, @PathVariable(value = "documento") String documento){
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.actualizarPersona(persona, "CPA".concat(documento)));
    }

    @PostMapping("/validar-password")
    public ResponseEntity<?> validarPassword(@RequestBody Persona persona) throws PersonaException {
        return ResponseEntity.ok(controlador.validarPassword(persona));
    }
}
