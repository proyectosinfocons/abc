package com.upc.backend_trabajofinal.negocio;

import com.upc.backend_trabajofinal.entidades.Horario;

import java.util.List;

public interface IHorarioNegocio {
    public Horario registrarHorario(Horario horario);
    public Horario obtenerHorario(Long id) throws Exception;
    public Horario actualizarHorario(Horario horario) throws Exception;
    public  void eliminarHorario(Horario horario);
    public List<Horario> obtenerHorarios();
}
