package com.upc.backend_trabajofinal.rest;

import com.upc.backend_trabajofinal.entidades.Persona;
import com.upc.backend_trabajofinal.negocio.PersonaNegocio;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class PersonaRest {
    @Autowired
    private PersonaNegocio personaNegocio;
    Logger logger = LoggerFactory.getLogger(PersonaRest.class);
    @GetMapping("/personas")//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public Object obtenerPersonas(){
        logger.info("Obteniendo personas");
        return personaNegocio.obtenerPersonas();
    }
    @PostMapping("/persona")
    public Object crearPersona(@RequestBody Persona persona){
        logger.info("Creando persona");
        return personaNegocio.registrarPersona(persona);
    }
    @PutMapping("/persona")
    public Object actualizarPersona(@RequestBody Persona persona) throws Exception {
        logger.info("Actualizando persona");
        return personaNegocio.actualizarPersona(persona);
    }
    @DeleteMapping("/persona")
    public void eliminarPersona(@RequestBody Persona persona) throws Exception {
        logger.info("Eliminando persona");
        personaNegocio.eliminarPersona(persona);
        logger.info("Persona eliminada");
    }
    @GetMapping("/persona/{id}")
    public Object obtenerPersona(@PathVariable("id") Long id) throws Exception {
        logger.info("Obteniendo persona");
        return personaNegocio.obtenerPersona(id);
    }
    @GetMapping("/personaobtener/{email}")
    public List<Persona> obtenerPersona(@PathVariable("email") String email) throws Exception {
        logger.info("Obteniendo persona");
        return personaNegocio.obtenerPersonasPoremail(email);
    }
}
