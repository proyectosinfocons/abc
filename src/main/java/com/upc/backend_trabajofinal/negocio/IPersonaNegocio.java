package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Persona;

import java.util.List;

public interface IPersonaNegocio {
    public Persona registrarPersona(Persona persona);
    public Persona obtenerPersona(Long id) throws Exception;
    public Persona actualizarPersona(Persona persona) throws Exception;
    public  void eliminarPersona(Persona persona);
    public List<Persona> obtenerPersonas();

    public List<Persona> obtenerPersonasPoremail(String email);
}
