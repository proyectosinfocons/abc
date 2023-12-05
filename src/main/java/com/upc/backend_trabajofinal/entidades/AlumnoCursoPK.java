package com.upc.backend_trabajofinal.entidades;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlumnoCursoPK implements Serializable {

    @Column(name = "alumno_id")
    private Long alumnoId;

    @Column(name = "curso_id")
    private Long cursoId;

    // constructor, getters, setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoCursoPK that = (AlumnoCursoPK) o;
        return Objects.equals(alumnoId, that.alumnoId) &&
                Objects.equals(cursoId, that.cursoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnoId, cursoId);
    }

    public AlumnoCursoPK(Long alumnoId, Long cursoId) {
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
    }
    public AlumnoCursoPK() {

    }
}

    /*
    @Column(name = "alumno_id")
    private Long alumnoId;
    @Column(name = "curso_id")
    private Long cursoId;

    public AlumnoCursoPK(Long alumnoId, Long cursoId) {
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
    }

    public AlumnoCursoPK() {

    }
     */
//}
