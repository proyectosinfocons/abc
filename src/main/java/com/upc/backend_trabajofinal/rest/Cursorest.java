package com.upc.backend_trabajofinal.rest;

import com.upc.backend_trabajofinal.entidades.Curso;
import com.upc.backend_trabajofinal.negocio.CursoNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class Cursorest {
    @Autowired
    private CursoNegocio cursoNegocio;
    Logger logger = LoggerFactory.getLogger(Cursorest.class);
    @GetMapping ("/cursos")//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public Object obtenerCursos(){
        logger.info("Obteniendo cursos");
        return cursoNegocio.obtenerCursos();
    }
    @GetMapping("/curso/{id}")
    public Object obtenerPersona(@PathVariable("id") Long id) throws Exception {
        logger.info("Obteniendo curso");
        return cursoNegocio.obtenerCurso(id);
    }
    @PostMapping("/curso")
    public Object crearCurso(@RequestBody Curso curso) throws Exception {
        logger.info("Creando curso");
        return cursoNegocio.registrarCurso(curso);
    }
    @PutMapping("/curso")
    public Object actualizarCurso(@RequestBody Curso curso) throws Exception {
        logger.info("Actualizando curso");
        return cursoNegocio.actualizarCurso(curso);
    }
    @DeleteMapping("/curso")
    public void eliminarCurso(@RequestBody Curso curso) throws Exception {
        cursoNegocio.eliminarCurso(curso);
    }

}
