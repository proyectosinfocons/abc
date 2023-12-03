package com.upc.backend_trabajofinal.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AlumnoCursoPK implements Serializable {
    @Column(name = "alumno_id")
    private Long alumnoId;
    @Column(name = "curso_id")
    private Long cursoId;

}
