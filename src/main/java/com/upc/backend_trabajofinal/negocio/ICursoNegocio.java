package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Alumno;
import com.upc.backend_trabajofinal.entidades.Curso;

import java.util.List;

public interface ICursoNegocio {
    public Curso registrarCurso(Curso curso);
    public Curso obtenerCurso(Long id) throws Exception;
    public Curso actualizarCurso(Curso curso) throws Exception;
    public  void eliminarCurso(Curso curso);
    public List<Curso> obtenerCursos();
}
