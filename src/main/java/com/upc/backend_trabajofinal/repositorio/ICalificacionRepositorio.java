package com.upc.backend_trabajofinal.repositorio;

import com.upc.backend_trabajofinal.entidades.Calificacion;
import com.upc.backend_trabajofinal.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICalificacionRepositorio extends JpaRepository<Calificacion,Long> {

    @Query("SELECT c FROM Calificacion c WHERE c.alumno.codigo = :alumnoId")
    List<Calificacion> findByIdAlumno(@Param("alumnoId") Long alumnoId);


    @Query("SELECT c FROM Calificacion c WHERE c.unico = :unicoVal")
    List<Calificacion> findByIdUnico(@Param("unicoVal") String unicoVal);

}
