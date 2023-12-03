package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Alumno;
import com.upc.backend_trabajofinal.repositorio.IAlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoNegocio implements IAlumnoNegocio{
    @Autowired
    IAlumnoRepositorio alumnoRepositorio;
    @Override
    public Alumno registrarAlumno(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    @Override
    public Alumno obtenerAlumno(Long id) throws Exception {
        return alumnoRepositorio.findById(id).orElseThrow(
                ()-> new Exception("No se encontro alumno")
        );
    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) throws Exception {
        obtenerAlumno(alumno.getCodigo());
        return alumnoRepositorio.save(alumno);
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        alumnoRepositorio.delete(alumno);
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        return alumnoRepositorio.findAll();
    }
}
