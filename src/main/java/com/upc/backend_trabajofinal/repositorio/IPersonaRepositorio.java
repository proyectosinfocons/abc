package com.upc.backend_trabajofinal.repositorio;

import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonaRepositorio extends JpaRepository<Persona,Long> {

    @Query("SELECT c FROM Persona c WHERE c.email = :email")
    List<Persona> findByEmail(@Param("email") String email);
}
