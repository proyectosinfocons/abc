package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.entidades.Curso;

import java.util.List;

public interface ICalificacionNegocio {
    public Calificacion registrarCalificacion(Calificacion calificacion);

    List<Calificacion> obtenerCalificacionesPorAlumno(Long alumnoId);

    //public Calificacion actualizarCalificacion(Calificacion calificacion) throws Exception;
    public  void eliminarCalificacion(Calificacion calificacion);
    public List<Calificacion> obtenerCalificacion();
}
