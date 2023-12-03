package com.upc.backend_trabajofinal.repositorio;

import com.upc.backend_trabajofinal.entidades.Horario;
import com.upc.backend_trabajofinal.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHorarioRepositorio extends JpaRepository<Horario,Long> {

}
