package com.upc.backend_trabajofinal.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBL_calificacion")
public class Calificacion {
    @EmbeddedId
    private AlumnoCursoPK id;
    private Integer nota;
    private String observacion;
    @ManyToOne
    @JoinColumn(name = "alumno_id", insertable = false, updatable = false)
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "curso_id", insertable = false, updatable = false)
    private Curso curso;

    public Calificacion() {
    }

    public Calificacion(AlumnoCursoPK id, Integer nota, String observacion, Alumno alumno, Curso curso) {
        this.id = id;
        this.nota = nota;
        this.observacion = observacion;
        this.alumno = alumno;
        this.curso = curso;
    }
}
