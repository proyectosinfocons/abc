package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Horario;
import com.upc.backend_trabajofinal.repositorio.IHorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioNegocio implements IHorarioNegocio {

    @Autowired
    private IHorarioRepositorio horarioRepositorio;
    @Override
    public Horario registrarHorario(Horario horario) {
        return horarioRepositorio.save(horario);
    }

    @Override
    public Horario obtenerHorario(Long id) throws Exception {
        return horarioRepositorio.findById(id).orElseThrow(
                ()-> new Exception("No se encontro alumno")
        );
    }

    @Override
    public Horario actualizarHorario(Horario horario) throws Exception {
        obtenerHorario(horario.getId());
        return horarioRepositorio.save(horario);
    }

    @Override
    public void eliminarHorario(Horario horario) {
         horarioRepositorio.delete(horario);
    }

    @Override
    public List<Horario> obtenerHorarios() {
        return horarioRepositorio.findAll();
    }
}
