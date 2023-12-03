package com.upc.backend_trabajofinal.repositorio;

import com.upc.backend_trabajofinal.entidades.Alumno;
import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAlumnoRepositorio extends JpaRepository<Alumno,Long> {

}
