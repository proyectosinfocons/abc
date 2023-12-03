package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Alumno;
import com.upc.backend_trabajofinal.entidades.Curso;
import com.upc.backend_trabajofinal.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoNegocio implements ICursoNegocio{
    @Autowired
    ICursoRepositorio cursoRepositorio;
    @Override
    public Curso registrarCurso(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    @Override
    public Curso obtenerCurso(Long id) throws Exception {
        return cursoRepositorio.findById(id).orElseThrow(
                ()->new Exception("No se encontro curso buscado")
        );
    }

    @Override
    public Curso actualizarCurso(Curso curso) throws Exception {
        obtenerCurso(curso.getId());
        return cursoRepositorio.save(curso);
    }

    @Override
    public void eliminarCurso(Curso curso) {
        cursoRepositorio.delete(curso);
    }

    @Override
    public List<Curso> obtenerCursos() {
        return cursoRepositorio.findAll();
    }
}
