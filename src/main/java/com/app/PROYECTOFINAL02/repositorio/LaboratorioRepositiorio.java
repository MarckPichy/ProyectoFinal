package com.app.PROYECTOFINAL02.repositorio;

import com.app.PROYECTOFINAL02.entidad.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepositiorio extends JpaRepository<Laboratorio, Long> {

    boolean existsByCodigolaboratorio(String codigolaboratorio);

}
