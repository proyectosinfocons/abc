package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Persona;
import com.upc.backend_trabajofinal.repositorio.IPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaNegocio implements IPersonaNegocio{
    @Autowired
    private IPersonaRepositorio personaRepositorio;
    @Override
    public Persona registrarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public Persona obtenerPersona(Long id) throws Exception {
        return personaRepositorio.findById(id).orElseThrow(
                ()->new Exception("No se encontro persona")
        );
    }

    @Override
    public Persona actualizarPersona(Persona persona) throws Exception {
        obtenerPersona(persona.getCodigo());
        return personaRepositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaRepositorio.delete(persona);
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return personaRepositorio.findAll();
    }

    @Override
    public List<Persona> obtenerPersonasPoremail(String email) {
        return personaRepositorio.findByEmail(email);
    }
}
