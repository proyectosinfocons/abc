package com.upc.backend_trabajofinal.rest;

import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.negocio.CalificacionNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class Calificacionrest {
    @Autowired
    private CalificacionNegocio calificacionNegocio;
    Logger logger = LoggerFactory.getLogger(Cursorest.class);
    @GetMapping("/calificaciones")
    public Object obtenerCalificacion(){
        logger.info("Obteniendo calificaciones");
        return calificacionNegocio.obtenerCalificacion();
    }


    @GetMapping("/calificacion/{id}")
    public Object obtenerCalificacionesPorAlumno(@PathVariable("id") Long id) throws Exception {
        logger.info("Obteniendo calificacion");
        return calificacionNegocio.obtenerCalificacionesPorAlumno(id);
    }

    @GetMapping("/calificacion_info/{unico}")
    public Object obtenerCalificacionesPorIdUnico(@PathVariable("unico") String unico) throws Exception {
        logger.info("Obteniendo calificacion");
        var result = calificacionNegocio.obtenerCalificacionPorIdUnico(unico);
        // Si la lista tiene elementos, devuelve el primer elemento; de lo contrario, devuelve null
        return result.isEmpty() ? null : result.get(0);
    }


    @PostMapping("/calificacion")
    public Object crearCalificacion(@RequestBody Calificacion calificacion) throws Exception {
        logger.info("Creando calificacion");
        return calificacionNegocio.registrarCalificacion(calificacion);
    }
    @DeleteMapping("/calificacion")
    public void eliminarCalificacion(@RequestBody Calificacion calificacion) throws Exception {
        calificacionNegocio.eliminarCalificacion(calificacion);
        logger.info("Eliminada calificacion");
    }

}
