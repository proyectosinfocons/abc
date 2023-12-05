package com.upc.backend_trabajofinal.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBL_Horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_curso;
    private String dia;
    private String hora_inicio;
    private String hora_fin;
    @OneToOne
    @JoinColumn(name = "id_curso",insertable = false,updatable = false)
    private Curso curso;

    public Horario() {
    }

    public Horario(Long id, String dia, String hora_inicio, String hora_fin, Curso curso) {
        this.id = id;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.curso = curso;
        this.id_curso = curso.getId();
    }
}
