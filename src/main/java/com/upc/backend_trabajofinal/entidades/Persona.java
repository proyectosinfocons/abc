package com.upc.backend_trabajofinal.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "TBL_Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String password;

    public Persona() {
    }

    public Persona(Long codigo, String nombre, String apellido, String dni, String direccion, String telefono, String email, String password, String usuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Persona(String nombre, String apellido, String dni, String direccion, String telefono, String email, String password, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }
}
