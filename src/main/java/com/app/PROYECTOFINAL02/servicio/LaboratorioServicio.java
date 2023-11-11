package com.app.PROYECTOFINAL02.servicio;

import com.app.PROYECTOFINAL02.entidad.Laboratorio;

import java.util.List;

public interface LaboratorioServicio {

    public List<Laboratorio> listarTodosLosLaboratorios();

    public Laboratorio guardarLaboratorio(Laboratorio laboratorio);

    public Laboratorio obteberLaboratorioPorId(Long id);

    public Laboratorio actualizarLaboratorio(Laboratorio laboratorio);

    public void eliminarLaboratorio(Long id);

    public Object buscarLaboratorios(String query);
    
}
