package com.upc.backend_trabajofinal.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBL_Alumno")

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long id_persona;
    @OneToOne
    @JoinColumn(name = "id_persona",insertable = false,updatable = false)
    private Persona persona;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(Long codigo, Persona persona, boolean estado) {
        this.codigo = codigo;
        this.persona = persona;
        this.estado = estado;
        this.id_persona = persona.getCodigo();
    }

}
