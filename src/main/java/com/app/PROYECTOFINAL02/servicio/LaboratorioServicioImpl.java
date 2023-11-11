package com.app.PROYECTOFINAL02.servicio;

import com.app.PROYECTOFINAL02.entidad.Laboratorio;
import com.app.PROYECTOFINAL02.repositorio.LaboratorioRepositiorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaboratorioServicioImpl implements LaboratorioServicio {
    @Autowired
    private LaboratorioRepositiorio repositiorio;


    @Override
    public List<Laboratorio> listarTodosLosLaboratorios() {
        return repositiorio.findAll();
    }


    @Override
    public Laboratorio guardarLaboratorio(Laboratorio laboratorio) {
        // Verificar si ya existe un estudiante con el mismo correo electrónico
        if (repositiorio.existsByCodigolaboratorio(laboratorio.getCodigolaboratorio())) {
            throw new CorreoElectronicoDuplicadoException("Ya existe un estudiante con el mismo correo electrónico");
        }

        // Guardar el estudiante si no hay duplicados
        return repositiorio.save(laboratorio);
    }


    @Override
    public Laboratorio obteberLaboratorioPorId(Long id) {
        return repositiorio.findById(id).orElse(null);
    }


    @Override
    public Laboratorio actualizarLaboratorio(Laboratorio laboratorio) {
        return repositiorio.save(laboratorio);
    }


    @Override
    public void eliminarLaboratorio(Long id) {
        repositiorio.deleteById(id);
    }


    @Override
    public Object buscarLaboratorios(String query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLaboratorios'");
    } 
}
