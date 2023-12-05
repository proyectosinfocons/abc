package com.upc.backend_trabajofinal.rest;

import com.upc.backend_trabajofinal.entidades.Alumno;
import com.upc.backend_trabajofinal.negocio.IAlumnoNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class Alumnorest {
    @Autowired
    private IAlumnoNegocio alumnoNegocio;
    Logger logger = LoggerFactory.getLogger(Alumnorest.class);
    @GetMapping("/alumnos")//http://localhost:8087/alumno/alumnos
    public Object obtenerAlumnos(){
        logger.info("Obteniendo alumnos");
        return alumnoNegocio.obtenerAlumnos();
    }
    @PostMapping("/alumno")
    public Object crearAlumno(@RequestBody Alumno alumno){
        logger.info("Creando alumno");
        return alumnoNegocio.registrarAlumno(alumno);
    }
    @PutMapping("/alumno")
    public Object actualizarAlumno(@RequestBody Alumno alumno) throws Exception {
        logger.info("Actualizando alumno");
        return alumnoNegocio.actualizarAlumno(alumno);
    }
    @DeleteMapping("/alumno")
    public void eliminarAlumno(@RequestBody Alumno alumno) throws Exception {
        logger.info("Elimando alumno");
        alumnoNegocio.eliminarAlumno(alumno);
    }
    @GetMapping("/alumno/{codigo}")
    public Alumno buscar(@PathVariable(value = "codigo")Long codigo){
        try {
            return alumnoNegocio.obtenerAlumno(codigo);
        } catch (Exception e) {
            //Escribiendo en el log
            logger.error("Error critico en la aplicación: " + e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el alumno con el codigo buscado", e);
        }
    }
}
