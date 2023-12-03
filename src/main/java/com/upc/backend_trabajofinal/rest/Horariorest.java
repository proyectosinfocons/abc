package com.upc.backend_trabajofinal.rest;

import com.upc.backend_trabajofinal.entidades.Horario;
import com.upc.backend_trabajofinal.negocio.HorarioNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class Horariorest{
    @Autowired
    private HorarioNegocio horarioNegocio;
    Logger logger = LoggerFactory.getLogger(Horariorest.class);
    @GetMapping("/horario")
    public Object obtenerHorarios(){
        logger.info("Obteniendo horarios");
        return horarioNegocio.obtenerHorarios();
    }
    @PostMapping("/horario")
    public Object crearHorario(@RequestBody Horario horario){
        logger.info("Creando horario");
        return horarioNegocio.registrarHorario(horario);
    }
    @PutMapping("/horario")
    public Object actualizarHorario(@RequestBody Horario horario) throws Exception {
        logger.info("Actualizando horario");
        return horarioNegocio.actualizarHorario(horario);
    }
    @DeleteMapping("/horario")
    public void eliminarHorario(@RequestBody Horario horario){
        horarioNegocio.eliminarHorario(horario);
    }
    @GetMapping("/horario/{id}")
    public Object obtenerHorario(@PathVariable Long id) throws Exception {
        logger.info("Obteniendo horario");
        return horarioNegocio.obtenerHorario(id);
    }

}
