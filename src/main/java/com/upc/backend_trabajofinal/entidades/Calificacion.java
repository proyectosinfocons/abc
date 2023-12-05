package com.upc.backend_trabajofinal.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String unico;

    @JsonManagedReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "alumno_id", referencedColumnName = "codigo", insertable = false, updatable = false)
    })
    private Alumno alumno;

    @JsonManagedReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "curso_id", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private Curso curso;

    public Calificacion() {
    }

    public Calificacion(AlumnoCursoPK id, String unico, Integer nota, String observacion, Alumno alumno, Curso curso) {
        this.id = id;
        this.unico = unico;
        this.nota = nota;
        this.observacion = observacion;
        this.alumno = alumno;
        this.curso = curso;
    }


}
