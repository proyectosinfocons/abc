package com.upc.backend_trabajofinal.repositorio;

import com.upc.backend_trabajofinal.entidades.Curso;
import com.upc.backend_trabajofinal.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepositorio extends JpaRepository<Curso,Long> {
}
