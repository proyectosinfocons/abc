package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.AlumnoCursoPK;
import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalificacionNegocio implements ICalificacionNegocio{
    @Autowired
    ICalificacionRepositorio calificacionRepositorio;
    @Override
    public Calificacion registrarCalificacion(Calificacion calificacion) {
        return calificacionRepositorio.save(calificacion);
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorAlumno(Long alumnoId) {
        return calificacionRepositorio.findByIdAlumno(alumnoId);
    }

    @Override
    public List<Calificacion> obtenerCalificacionPorIdUnico(String unico) {
        return calificacionRepositorio.findByIdUnico(unico);
    }

    @Override
    public void eliminarCalificacion(Calificacion calificacion) {
           calificacionRepositorio.delete(calificacion);
    }

    @Override
    public List<Calificacion> obtenerCalificacion() {
        //return calificacionRepositorio.findAll();

        var result = calificacionRepositorio.findAll();

       // for (var res :result) {
        //    var _id = new AlumnoCursoPK(res.getAlumno().getCodigo(),res.getCurso().getId());
            //System.out.println(_id);
         //   res.setId(_id);
       // }
        return  result;
    }
}
