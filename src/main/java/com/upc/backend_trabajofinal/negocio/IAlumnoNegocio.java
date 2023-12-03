package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Alumno;

import java.util.List;

public interface IAlumnoNegocio {
    public Alumno registrarAlumno(Alumno alumno);
    public Alumno obtenerAlumno(Long id) throws Exception;
    public Alumno actualizarAlumno(Alumno alumno) throws Exception;
    public  void eliminarAlumno(Alumno alumno);
    public List<Alumno> obtenerAlumnos();
}
